package main.scala.de.htwg.se.DogGame.controller

import _root_.main.scala.de.htwg.se.DogGame.model.Spieler
import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
import main.scala.de.htwg.se.DogGame.view.tui.Tui
import main.scala.de.htwg.se.DogGame.model.Spielbrett
import main.scala.de.htwg.se.DogGame.model.Spielfigur
import _root_.main.scala.de.htwg.se.DogGame.controller.{Benutzerinput => us_in}

case class Operationlogik(){
  
  import scala.collection.mutable.ArrayBuffer

  //case 1 => start += "B" + i;
  //case 2 => start += "R" + i;
  //case 3 => start += "G" + i;
  //case 4 => start += "S" + i;
  
  def laufen(lF: Lauffeld, figur: Spielfigur, opt: Int, spieler: Spieler, alleSp: ArrayBuffer[Spieler], spBrett: Spielbrett): Boolean = {

    opt match {
      case 0 => {
        if (!spieler.delFigur(figur)) {
          println("Etwas lief falsch - keine Figur geloescht")
          return false
        }
        if (lF.posBelegt(spieler.getStartPos())) {
          //nachhause schicken
          schickStart(lF, alleSp, spieler.getStartPos())
        }

        //aus dem start gehen
        lF.getFeld() += ((figur, spieler.getStartPos()))
        return true

      }
      case 7 => {
        // 7

        //println("**alle felder ausgeben**")
        Tui().tui_v1(lF, alleSp)

        if (lF.getFeld().contains(figur)) {
          var pos = lF.getFeld().get(figur)
          var erg = (pos.get + 1) % 64
          
          if (!lFIstFrei(lF, alleSp, erg)) {
            println("Blockiert durch StartFigur")
            return false
          }
                   
          lF.getFeld().remove(figur)

          var vorPos = 1000
          
          if (spBrett.get_spiel_Lauf_Feld().getFeld().get(figur) != None) {
            vorPos = spBrett.get_spiel_Lauf_Feld().getFeld().get(figur).get % 16
            //println("Zugriff erfolgt!")
          }
          
          var bisZiel = 64 - spieler.startPos
          if (pos.get == spieler.startPos && (9 <= vorPos && vorPos <= 15)) {
            // Ins Ziel laufen wenn davor vor dem ziel war( 9 bis 15)!
            val zielPos = erg - spieler.startPos
            spieler.ziel += ((figur, zielPos))
          } else {
            // noch eine runde laufen
            if (lF.posBelegt(erg))
              //figur schlagen
              schickStart(lF, alleSp, erg)
            lF.getFeld() += ((figur, erg))
          }
        } else if (spieler.ziel.contains(figur)) {
          // Figur nicht im Lauffeld -> Figur ist im Zielfeld

          var pos = spieler.ziel.get(figur)
          var schritt = 4 - pos.get
          var l = spieler.ziel.map(_.swap)

          if (1 <= schritt) {
            var belegt = false
            if (l.contains(pos.get + 1)) {
              belegt = true

            }
            if (!belegt) {
              spieler.ziel.remove(figur)
              spieler.ziel += ((figur, pos.get + 1))
            } else {
              println("Figur kann sich nicht mehr laufen!")
              return false
            }

          }
        } else {
          // Figur nicht im Lauffeld , Figur ist nicht im Zielfeld -> Figur im Startfeld
          return false
        }
        return true
      }
      case 14 => {
        // 4 zurueck
        if (lF.getFeld().contains(figur)) {
          var pos = lF.getFeld().get(figur)
          lF.getFeld().remove(figur)
          var erg = (pos.get - 4)

          if (erg < 0) {
            erg = 64 + erg
          }

          erg = erg % 64

          if (lF.posBelegt(erg))
            //figur schlagen
            schickStart(lF, alleSp, erg)
          lF.getFeld() += ((figur, erg))
          return true
        } else {
          //Figur nicht im Lauffeld
          println("Figur nicht im Lauffeld: bitte nochmal eingeben");
          return false
        }
      }
      case 15 => {
        var checkAndere = false
        for (figs <- lF.getFeld().seq) {
          if (!figs._1.getFigur().startsWith(spieler.getName()))
            checkAndere = true
        }

        if (!checkAndere)
          return false
         /*Tauschen mit Figuren, die sich im Lauffeld befinden.*/
        println("Figur von andere Spieler waehlen! (z.B. R1)");
        //var fig2 = spieler.getFigur(us_in().spFigur_waehlen())
        var fig_name = us_in().spFigur_waehlen()
        var fig2 = new Spielfigur("z1")
        for(sp <- alleSp){
          if(fig_name.startsWith(sp.getName())){
            fig2 = sp.getFig(sp.getName())
          } 
        }
        
        // Check falls tauschbar
        while ((fig2 == null) || (!lF.getFeld().contains(fig2) && !fig2.getFigur().startsWith(spieler.getName()))) {
          println("Diese Figur kann man nicht tauschen.")
          println("Figur von anderem Spieler waehlen! (z.B. R1)");
          fig_name = us_in().spFigur_waehlen()
          for(sp <- alleSp){
            if(fig_name.startsWith(sp.getName())){
              fig2 = sp.getFig(sp.getName())
            } 
          }
          
        }

        if(lF.getFeld().get(figur) == None || lF.getFeld().get(fig2) == None ){
          println("Entweder falsche Figur gewählt oder falsche Name eingegeben!")
          return false
        }
          // get erledigt
        var pos = lF.getFeld().get(figur).get
        var pos2 = lF.getFeld().get(fig2).get
        
        lF.getFeld().remove(figur)
        lF.getFeld().remove(fig2)

        lF.getFeld() += ((figur, pos2))
        lF.getFeld() += ((fig2, pos))
        return true

      }
      case _ => {
        // im normalfall : 1-13
        if (lF.getFeld().contains(figur)) {
          var pos = lF.getFeld().get(figur)
          var erg = (pos.get + opt) % 64

          //was wenn blockiert
          for (i <- pos.get + 1 to pos.get + opt) {
            var s = i % 64
            if (!lFIstFrei(lF, alleSp, s)) {
              println("Diese Figur ist blockiert.")
              return false
            }
          }

          lF.getFeld().remove(figur)

          if ((pos.get < spieler.startPos || (spieler.getId() == 1 && pos.get > 4)) && 1 <= (erg - spieler.startPos) % 64 && (erg - spieler.startPos) % 64 <= 4) {
            // Ins Ziel laufen
            
            val zielPos = erg - spieler.startPos
            
            var posZielF = 4
            for(f <- spieler.ziel){
              if(posZielF == 4){
                posZielF = f._2
              }
            }
              
            if(zielPos < posZielF){  
              spieler.ziel += ((figur, zielPos))
            }else{
              println("Zielfeld nicht erreichbar!")
              return false
            }
          } else {
            // noch eine runde laufen
            if (lF.posBelegt( erg))
              //figur schlagen
              schickStart(lF, alleSp, erg)
            lF.getFeld() += ((figur, erg))
          }
        } else if (spieler.ziel.contains(figur)) {
          // Figur nicht im Lauffeld -> Figur ist im Zielfeld

          var pos = spieler.ziel.get(figur)
          
          if(pos == None){
            println("Figur nicht gefunden.")
            return false
          }
          var schritt = 4 - pos.get
          var l = spieler.ziel.map(_.swap)

          if (opt <= schritt) {
            var belegt = false
            for (i <- pos.get + 1 to schritt) {
              if (l.contains(i)) {
                belegt = true
              }
            }
            if (!belegt) {
              spieler.ziel.remove(figur)
              spieler.ziel += ((figur, pos.get + schritt))
            } else {
              println("Figur kann sich nicht mehr laufen!")
              return false
            }

          }
        } else {
          // Figur nicht im Lauffeld , Figur ist nicht im Zielfeld -> Figur im Startfeld
          println("Diese Figur ist im Startfeld.")
          return false
        }
        return true
      }
    }
  }

  def ausfuehren(lF: Lauffeld, karte: Int, spieler: Spieler, alleSp: ArrayBuffer[Spieler], spBrett: Spielbrett): Boolean = {

    //Fall:joker
    var karteE = karte
    
    //TODO diese if Verzweiflung als Funktion rausnehmen
    if (karte == 14) {
      var kart = 0
      var check2 = false
      while (check2 == false) {
        println("Waehlen Sie eine Karte aus die der Joker sein soll.")
        var optStr = Benutzerinput().karte_waehlen()

        while (optStr == None || optStr.get == 14) {
          println("Waehlen Sie eine Karte aus die der Joker sein soll.")
          optStr = Benutzerinput().karte_waehlen()

        }
        //get ist gecheckt
        kart = optStr.get
        if (kart >= 1 && kart <= 13) {
          check2 = true;
        }
        if (!check2) {
          println("Diese Karte gibt es nicht.")
        }

      }
      karteE = kart
    }
    var tmp = spieler.getName() + us_in().figur_waehlen()
    var fig = spieler.getFig(tmp)
    		
    karteE match {
      case 0 => { // keine moegliche karte Etwas lief falsch

        println("Es gibt keine ausspielbare Karte.")
        return true
      }
      case 1 => { // ASS
        //var fig = new Figur(spieler.getName() + us_in().figur_waehlen())
        // optionen bestimmen
        println("0 -> Aus Startfeld rausgehen.")
        println("1 -> 1 Schritt im Lauffeld weiter laufen.")
        println("11 -> 11 Schritte im Lauffeld weiter laufen.")
        var opt = us_in().opt_waehlen()

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 2 => {
        //var fig = new Figur(spieler.getName() + us_in().figur_waehlen())
        // optionen bestimmen
        var opt = 2
        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 3 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 3
        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 4 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        println("14 -> 4 Schritte im Lauffeld Rueckwaerts laufen.")
        println("4 -> 4 Schritte im Lauffeld weiter laufen.")
        var opt = us_in().opt_waehlen()

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 5 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 5

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 6 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 6

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 7 => {
        /*TODo: Wieso die beide Zeile nicht in for Schleife drin*/
        var parlF = new Lauffeld()
        parlF.setFeld(lF.getFeld())
        spBrett.set_spiel_Lauf_Feld(parlF)
        spBrett.set_spiel_Player(alleSp)
        

        for (i <- 1 to 7) {
          var tmp = spieler.getName() + us_in().figur_waehlen()
          var fig = spieler.getFig(tmp)
          // optionen bestimmen

          var opt = 7

          if (!laufen(lF, fig, opt, spieler, alleSp, spBrett)) {
            spBrett.revert7 = true
            return false
          }
        }
        return true
      }
      case 8 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 8

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 9 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 9

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 10 => {
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        var opt = 10

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 11 => { // Bube
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen

        var opt = 15

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)
      }
      case 12 => { // Dame
        //var fig = spieler.getName() + us_in().figur_waehlen()
        var opt = 12

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)

      }
      case 13 => { // Koenig
        //var fig = spieler.getName() + us_in().figur_waehlen()
        // optionen bestimmen
        println("0 -> Aus Startfeld rausgehen.")
        println("13 -> 13 Schritte im Lauffeld weiter laufen.")
        var opt = us_in().opt_waehlen()

        return laufen(lF, fig, opt, spieler, alleSp, spBrett)

      }
      case _ => { // etwas lief schief
        println("Etwas lief falsch: Error match-ausfuehren")
        return false
      }
    }
  }

//  def posBelegt(lF: collection.mutable.Map[String, Int], pos: Int): Boolean = {
//    var check = false
//    for ((k, v) <- lF) {
//      if (v == pos) {
//        check = true
//      }
//    }
//    return check
//  }

  def schickStart(lF: Lauffeld, alleSp: ArrayBuffer[Spieler], pos: Int) = {
    // get figur
    var fig = new Spielfigur("0")
    for ((k, v) <- lF.getFeld()) {
      if (v == pos) {
        fig = k
      }
    }
    //todo fehlerbehandlung
    // loesche im lF
    lF.getFeld() -= ((fig))

    // setze in zielSpieler.start
    for (sp <- alleSp) {
      if (fig.getFigur().startsWith(sp.getName())) {
        sp.start += ((fig, sp.getFigPos(fig)))
      }
    }

  }
/*
  def StrToIntK(s: String): Option[Int] = {
    try {
      if(s.equals("exit")){
        System.exit(1)
      }
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }
  */
  def lFIstFrei(lF: Lauffeld, p: ArrayBuffer[Spieler], pos: Int): Boolean = {

    var l = lF.getFeld().clone().map(_.swap)
    for (einer <- p) {
      //auf einer startposition
      if (pos == einer.getStartPos()) {
        if (l.get(pos) != None) {
          //die richtige figur auf dieser startPos
          if (l.get(pos).get.getFigur().startsWith(einer.getName())) {
            println("Block erkannt.")
            return false
          }
        }
      }
    }

    return true
  }

  
}