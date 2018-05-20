package main.scala.de.htwg.se.DogGame.controller

case class Startspiel() {

  import scala.collection.mutable.ArrayBuffer
  import _root_.main.scala.de.htwg.se.DogGame.model.Spieler
  import _root_.main.scala.de.htwg.se.DogGame.model.Karten
  import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
  import _root_.main.scala.de.htwg.se.DogGame.model.Spielbrett
  import _root_.main.scala.de.htwg.se.DogGame.view.Tui
  import _root_.main.scala.de.htwg.se.DogGame.controller.{ Operationlogik => op_log }
  import main.scala.de.htwg.se.DogGame.controller.Benutzerinput

  var tuiIns = Tui()
  //var revert7 = false

  // Alle Lauffelder mit spBrett.get_spiel_Lauf_Feld() ersetzt
  def start_spiel() {
    //var kartenStapel = ArrayBuffer[Int]()
    var kartenStapel = new Karten()
    var laufFeld = new Lauffeld()
    var players = ArrayBuffer[Spieler]()
    //val kartFiguren = Array("Kreuz", "Pik", "Herz", "Karo")
    var turn = 1
    var karGrenz = 6
    var spBrett = Spielbrett()

    // init spieler
    println("Wieviele Spieler spielen?")

    var anzSpieler = 0
    var cor = false

    anzSpieler = Benutzerinput().anz_Spieler_waehlen()

    // default- 1 to 4
    addSpieler(players, anzSpieler)

    // init
    for (x <- players) {
      x.setStart();
    }

    var win = -1
    while (win == -1) {

      // kartenstapel auffuellen
      kartenStapel.getKarten().clear()
      for (wert <- 1 to 14) {
        for (anz <- 1 to 4) {
          kartenStapel.getKarten() += wert

        }

      }
      //println(kartenStapel);

      //karten verteilen

      verteieleKarte(players, kartenStapel, karGrenz)

      // karten mit partner tauschen

      tauscheKarte(players)

      // spiel ...
      var rundenEnde = false
      while (!rundenEnde) {
        for (sp <- 0 to players.length - 1) {

          // Alle Felder uebersichtlich ausgeben
          //println("**alle felder ausgeben**")
          tuiIns.tui_v1(laufFeld, players)

          // checken ob mind. eine karte moeglich

          //startkarte
          var checkSt = false
          for (kar <- players(sp).getKarten()) {

            if ((kar == 1 || kar == 13 || kar == 14))
              checkSt = true

            //if (players(sp).getStart().size + players(sp).getZiel().size != 4)
            //  checkSt = true

          }
          //if (players(sp).getStart().size == 0)
          //   checkSt = true

          if (!checkSt) {
            println("Keine mögliche Startkarte vorhanden.")
          }

          // Blokierte Spielfelder
          var bestePos = getBestPos(laufFeld, sp, players)

          var checkBl = false
          /*Hier wird ausgegeben die kleinste Karte von Spielers Karte und die großte
           Laufmöglichkeit Abstand von alle Figuren, die im Lauffeld stehen*/
          if (!(players(sp).getAnzKart() == 0) && players(sp).getStart().size != 4) {
            val klKart = players(sp).getkleinsteKarte()
            println("bestePosforallFig: " + bestePos + " klKart: " + klKart)
            if (bestePos == 0) {
              // keine figur auf dem spielfeld
              checkBl = true
            } else if (bestePos >= klKart)
              //blockiert
              checkBl = true

            if (!checkBl) {
              println("Keine mögliche Figur vorhanden!(Blockiert)")
            }
          }

          // Nur Buben , ohne moeglichkeit
          var km = false
          var allB = true
          for (k <- players(sp).getKarten()) {
            if (k != 11) {
              allB = false
            }
          }

          if (allB && (players(sp).getStart().size + players(sp).getZiel().size == 4)) {
            km = true
          }

          var andere = false
          for (fig <- laufFeld.getFeld()) {
            //wenn figur geschützt ist , nicht tauschen
            var geschuetzt = false
            if (laufFeld.getFeld().map(_.swap).get(players(sp).startPos) != None) {
              geschuetzt = true
            }

            if (!fig._1.getFigur().startsWith(players(sp).getName()) && !geschuetzt)
              andere = true
          }

          if (!andere && allB) {
            println("Keine mögliche Figur vorhanden!(alle Buben)(keine andere Figur)")
          }
          /* ueberfluessig, da schon bei startkarte gecheckt
          if (!km && allB) {
            println("Keine mögliche Figur vorhanden!(alle Buben)(keine eigene Figur)")
          }*/

          // im ziel blockiert
          var bl = zielBlockiert(sp, players)

          if (bl) {
            println("Keine mögliche Figur vorhanden!(alle Blockiert)")
          }
          // evtl andere faelle ?

          // Keine moegliche Zuege erkannt:

          if (!checkSt && !checkBl && ((km || !andere)) && bl) {
            players(sp).delAllKarte()
            println("Keine Karte zum Spielen: alle Karten abgeworfen")
          }

          /*legit verwendet, um Spieler zu wechseln, wenn sein Schritt(ausfuehren) erfolgreich war*/
          var legit = false
          while (!legit) {

            val erg = spielZugErfolgreich(laufFeld, sp, players, spBrett)
            legit = erg._2

            if (erg._1 != null) {
              players = erg._1
            }

          }
          // zug ende
          turn = (turn + 1) % 4
        }

        //testen ob runden ende
        var anzKar = 0;
        for (sp <- 1 to players.length) {
          anzKar += players(sp - 1).getAnzKart()
        }

        if (anzKar == 0) {
          // alle spieler haben keine karten mehr - runden ende!
          rundenEnde = true

          if (karGrenz > 2)
            karGrenz -= 1
          else
            karGrenz = 6
        }

      } // while rundenende

      if (players(1).alleImZiel() && players(3).alleImZiel())
        win = 1
      if (players(0).alleImZiel() && players(2).alleImZiel())
        win = 0

    } // while win ende
    var gewinner2 = win + 2
    println(win + " hat mit seinem Teampartner " + gewinner2 + "gewonnen :)")
  }

  def addSpieler(players: ArrayBuffer[Spieler], anzSp: Int) {
    for (i <- 1 to anzSp) {

      var p1 = new Spieler(i, (i - 1) * 16);
      players += p1;

    }
  }

  def verteieleKarte(players: ArrayBuffer[Spieler], kartenStapel: Karten, karGrenz: Int) {
    val r = scala.util.Random

    // spieler - default 4

    for (sp <- 1 to players.length) {

      // kartengrenze - default 6
      var kar = ArrayBuffer[Int]()
      for (j <- 1 to karGrenz) {
        val zufall = r.nextInt(kartenStapel.getKarten().length - 1)
        players(sp - 1).setKarte(kartenStapel.getKarten()(zufall))
        kartenStapel.getKarten().remove(zufall)
      }
    }

  }

  def tauscheKarte(players: ArrayBuffer[Spieler]) {
    //init
    var tauschKarten = Array[Int](0, 0, 0, 0)

    //jeder spieler
    for (sp <- 0 to players.length - 1) {

      var tKart = "0"
      var tk = Benutzerinput().StrToIntK(tKart)
      var check = false
      while (check == false) {
        println(players(sp).getName() + ", Waehlen Sie eine Karte zum tauschen aus!")
        println(players(sp).getKartenAusgabe())
        tKart = scala.io.StdIn.readLine()

        tk = Benutzerinput().StrToIntK(tKart)

        while (tk == None) {
          println(players(sp).getName() + ", Waehlen Sie eine Karte zum tauschen aus!")
          println(players(sp).getKartenAusgabe())
          tKart = scala.io.StdIn.readLine()
          tk = Benutzerinput().StrToIntK(tKart)
        }

        //checken ob karte da ist
        for (k <- players(sp).getKarten()) {

          if (k == tk.get) {
            check = true
          }
        }
        if (!check) {
          println("Diese Karte haben Sie nicht.")
        }

      }
      tauschKarten((sp + 2) % 4) = tk.get
      players(sp).delKarte(tk.get)
    }

    for (sp <- 1 to players.length) {
      players(sp - 1).setKarte(tauschKarten(sp - 1))
    }
  }

  def getBestPos(laufFeld: Lauffeld, sp: Int, players: ArrayBuffer[Spieler]): Int = {

    var bestePos = 0

    for (fig <- laufFeld.getFeld()) {
      if (fig._1.getFigur().startsWith(players(sp).getName())) {

        var break = false
        for (i <- 1 to 13) {

          if (op_log().lFIstFrei(laufFeld, players, i + fig._2)) {

            if ((i > bestePos) && !break)
              bestePos = i

          } else {
            break = true

          }
        }
      }
    }
    return bestePos
  }

  def zielBlockiert(sp: Int, players: ArrayBuffer[Spieler]): Boolean = {
    // im ziel blockiert
    var bl = false

    if (!players(sp).ziel.isEmpty) {

      // Figur nicht im Lauffeld -> Figur ist im Zielfeld

      if (!(players(sp).getAnzKart() == 0)) {
        val klKart = players(sp).getkleinsteKarte()

        for (fig <- players(sp).ziel) {
          var pos = fig._2
          var schritt = 4 - pos

          // ------------
          var l = players(sp).ziel.map(_.swap)

          if (klKart <= schritt) {
            var belegt = false
            for (i <- pos + 1 to 4) {
              if (l.contains(i)) {
                belegt = true
              }
            }
            if (!belegt) {
              bl = true
            }
          }
        }
      }
    }
    return bl
  }

  def spielZugErfolgreich(laufFeld: Lauffeld, sp: Int, players: ArrayBuffer[Spieler], spBrett: Spielbrett): (ArrayBuffer[Spieler], Boolean) = {

    // karten anzeigen
    println("Du bist dran: " + players(sp).getName())
    println("Ass = 1, Bube = 11, Dame = 12, Koenig = 13, Joker = 14, 0 = keine moegliche")
    println(players(sp).getKartenAusgabe())

    if ((players(sp).getAnzKart() == 0)) {
      return (null, true)
    }
    //auswaehlen + loeschen
    println("Waehle eine Karte zum Spielen aus.")
    var spKart = Benutzerinput().karte_waehlen()
    while (spKart == None || (!players(sp).getKarten().contains(spKart.get) && spKart.get != 0)) {
      println("Du hast nicht diese Karte.")
      println("Waehle eine Karte zum Spielen aus.")
      spKart = Benutzerinput().karte_waehlen()
    }
    // spkart.get ist gecheckt
    var sK = spKart.get

    if (sK == 0) {
      println("Keine Karte zum Spielen.")
      // Karten loeschen und naechster spieler
      players(sp).delAllKarte()
      return (null, true)

    } else {

      // kartenlogik ausfuehren

      if (op_log().ausfuehren14(laufFeld, sK, players(sp), players, spBrett)) {

        players(sp).delKarte(sK)
        return (null, true)

      } else if (spBrett.revert7) {
        laufFeld.setFeld(spBrett.get_spiel_Lauf_Feld().getFeld())
        var newPlayers = spBrett.get_spiel_Player()
        spBrett.revert7 = false
        spBrett.remove_Spiel_Brett()
        println("Jetzt eine neue Karte angeben.(7)")
        return (newPlayers, false)
      } else {
        println("Jetzt eine neue Karte angeben.")
        return (null, false)
      }

    }

  }
}