package main.scala.de.htwg.se.DogGame.controller

import main.scala.de.htwg.se.DogGame.model.Spieler
import main.scala.de.htwg.se.DogGame.model.Lauffeld
import main.scala.de.htwg.se.DogGame.view.tui.Tui
import main.scala.de.htwg.se.DogGame.model.Spielbrett
import main.scala.de.htwg.se.DogGame.model.Spielfigur
import main.scala.de.htwg.se.DogGame.controller.{ Benutzerinput => us_in }

case class Operationlogik() {

  import scala.collection.mutable.ArrayBuffer

  def ausfuehren14(lF: Lauffeld, karte: Int, spieler: Spieler, alleSp: ArrayBuffer[Spieler], spBrett: Spielbrett): Boolean = {
    var karteE = karte
    if (karte == 14) {
      var kart = 0
      var check2 = false
      while (check2 == false) {
        println("Waehlen Sie eine Karte aus die der Joker sein soll.")
        var optStr = Benutzerinput().karte_waehlen()

        while (optStr == None || optStr.get == 14) {
          println("Falsche Eingabe! Waehlen Sie eine Karte aus, die der Joker sein soll.")
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
    return ausfuehren(lF, karteE, spieler, alleSp, spBrett)
  }
  
  def ausfuehren(lF: Lauffeld, karte: Int, spieler: Spieler, alleSp: ArrayBuffer[Spieler], spBrett: Spielbrett): Boolean = {

    var tmp = spieler.getName() + us_in().figur_waehlen()
    var fig = spieler.getFig(tmp)

    karte match {
      case 0 => { // keine moegliche karte Etwas lief falsch

        println("Es gibt keine ausspielbare Karte.")
        return true
      }
      case 1 => { // ASS
        
        // optionen bestimmen
        var opt = -1
        do {
          println("0 -> Aus Startfeld rausgehen.")
          println("1 -> 1 Schritt im Lauffeld weiter laufen.")
          println("11 -> 11 Schritte im Lauffeld weiter laufen.")
          opt = us_in().opt_waehlen()
        } while (opt != 0 && opt != 11 && opt != 1)

        if (opt == 0) {
          return laufen0(lF, fig, spieler, alleSp)
        } else {
          return laufenN(lF, fig, opt, spieler, alleSp)
        }

       
      }
      
      case 4 => {
        
        // optionen bestimmen
        var opt = -1
        do {
          println("14 -> 4 Schritte im Lauffeld Rueckwaerts laufen.")
          println("4 -> 4 Schritte im Lauffeld weiter laufen.")
          opt = us_in().opt_waehlen()
        } while (opt != 14 && opt != 4)

        if (opt == 14) {
          return laufen14(lF, fig, spieler, alleSp)
        } else {
          return laufenN(lF, fig, opt, spieler, alleSp)
        }
        
      }
      case 7 => {

        var parlF = new Lauffeld()
        parlF.setFeld(lF.getFeld())
        spBrett.set_spiel_Lauf_Feld(parlF)
        spBrett.set_spiel_Player(alleSp)

        for (i <- 1 to 7) {
          // optionen bestimmen

          if (!laufen7(lF, fig, spieler, alleSp, spBrett)) {
            spBrett.revert7 = true
            return false
          }

          if (i != 7) {
            var tmp = spieler.getName() + us_in().figur_waehlen()
            fig = spieler.getFig(tmp)
          }
        }
        return true
      }
      
      case 11 => { // Bube
        
        return laufen15(lF, fig, spieler, alleSp)
      }
      
      case 13 => { // Koenig
        
        // optionen bestimmen
        var opt = -1
        do {
          println("0 -> Aus Startfeld rausgehen.")
          println("13 -> 13 Schritte im Lauffeld weiter laufen.")
          opt = us_in().opt_waehlen()
        } while (opt != 0 && opt != 13)

        if (opt == 0) {
          return laufen0(lF, fig, spieler, alleSp)
        } else {
          return laufenN(lF, fig, opt, spieler, alleSp)
        }

       

      }
      case _ => { // der rest - normale karten: 2,3,5,6,8,9,10,12

        return laufenN(lF, fig, karte, spieler, alleSp)

      }
    }
  }

  def schickStart(lF: Lauffeld, alleSp: ArrayBuffer[Spieler], pos: Int) = {
    // get figur
    var fig = new Spielfigur("0")
    for ((k, v) <- lF.getFeld()) {
      if (v == pos) {
        fig = k
      }
    }
    //TODO fehlerbehandlung
    // loesche im lF
    lF.getFeld() -= ((fig))

    // setze in zielSpieler.start
    for (sp <- alleSp) {
      if (fig.getFigur().startsWith(sp.getName())) {
        sp.start += ((fig, sp.getFigPos(fig)))
      }
    }

  }
 
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

  def laufen0(lF: Lauffeld, figur: Spielfigur, spieler: Spieler, alleSp: ArrayBuffer[Spieler]): Boolean = {

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

  def laufen7(lF: Lauffeld, figur: Spielfigur, spieler: Spieler, alleSp: ArrayBuffer[Spieler], spBrett: Spielbrett): Boolean = {
    // 7
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
    // tui anzeigen
    Tui().tui_v1(lF, alleSp)
    return true
  }

  def laufen14(lF: Lauffeld, figur: Spielfigur, spieler: Spieler, alleSp: ArrayBuffer[Spieler]): Boolean = {
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

  def laufen15(lF: Lauffeld, figur: Spielfigur, spieler: Spieler, alleSp: ArrayBuffer[Spieler]): Boolean = {

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
    for (sp <- alleSp) {
      if (fig_name.startsWith(sp.getName())) {
        fig2 = sp.getFig(sp.getName())
      }
    }

    // Check falls tauschbar
    while ((fig2 == null) || (!lF.getFeld().contains(fig2) && !fig2.getFigur().startsWith(spieler.getName()))) {
      println("Diese Figur kann man nicht tauschen.")
      println("Figur von anderem Spieler waehlen! (z.B. R1)");
      fig_name = us_in().spFigur_waehlen()
      for (sp <- alleSp) {
        if (fig_name.startsWith(sp.getName())) {
          fig2 = sp.getFig(sp.getName())
        }
      }

    }

    if (lF.getFeld().get(figur) == None || lF.getFeld().get(fig2) == None) {
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

  def laufenN(lF: Lauffeld, figur: Spielfigur, opt: Int, spieler: Spieler, alleSp: ArrayBuffer[Spieler]): Boolean = {

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
        for (f <- spieler.ziel) {
          if (posZielF == 4) {
            posZielF = f._2
          }
        }

        if (zielPos < posZielF) {
          spieler.ziel += ((figur, zielPos))
        } else {
          println("Zielfeld nicht erreichbar!")
          return false
        }
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

      if (pos == None) {
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