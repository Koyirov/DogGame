package test.scala.de.htwg.se.DogGame.model

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{ Matchers, WordSpec }
import main.scala.de.htwg.se.DogGame.model._
import scala.collection.mutable.ArrayBuffer

@RunWith(classOf[JUnitRunner])
class ModelSpec extends WordSpec with Matchers {
  "DogGame Modeltests" should {
    "not crash" in {
      // add tests when available
      true should be(true)
    }
  }

  var kartenStapel = new Karten()

  "getKarten" should {
    "karten als array liefern" in {
      kartenStapel.setKarte(1)
      kartenStapel.getKarten().contains(1) should be(true)
    }
  }

  "getKarten2" should {
    "karten als array liefern2" in {
      kartenStapel.setKarte(3)
      kartenStapel.setKarte(4)
      kartenStapel.getKarten().contains(3) should be(true)
      kartenStapel.getKarten().length should be(3)
    }
  }

  var lF = new Lauffeld()
  var feld = collection.mutable.Map[Spielfigur, Int]()
  feld += ((new Spielfigur().setSpielfigur("S1"), 1))
  feld += ((new Spielfigur().setSpielfigur("S2"), 10))
  feld += ((new Spielfigur().setSpielfigur("B1"), 16))
  feld += ((new Spielfigur().setSpielfigur("G4"), 21))
  feld += ((new Spielfigur().setSpielfigur("R3"), 32))
  feld += ((new Spielfigur().setSpielfigur("B2"), 41))

  "Lauffeld" should {
    "Figuren im Lauffeld setzen" in {
      lF.setFeld(feld)
      lF.getFeld().size should be(6)
    }

    "Figuren aus Lauffeld liefern " in {
      lF.setFeld(feld)
      lF.getFigur("G2") should be(null)
    }

    "belegt sein wenn belegt" in {
      lF.setFeld(feld)
      lF.posBelegt(32) should be(true)
    }

    "belegt sein wenn belegt3" in {
      lF.setFeld(feld)
      lF.posBelegt(9) should be(false)
    }

    var sp = new Spielfigur()

    "Spielfigur" should {
      "richtig gesetzt werden" in {
        sp.setSpielfigur("S1")
      }
    }

    "Spielfigur2" should {
      "richtig abgefragt werden" in {
        sp.getFigur() should be("S1")
      }
    }

  }
  "Spielfigur" should {

    var lF = new Lauffeld()
    var feld = collection.mutable.Map[Spielfigur, Int]()
    feld += ((new Spielfigur().setSpielfigur("S1"), 1))
    lF.setFeld(feld)
    var spielBr = new Spielbrett()

    "revert7" should {
      "richtig gesetzt werden" in {
        spielBr.set_revert7(true)
        spielBr.get_revert7() should be(true)
      }
    }

    "revert7-2" should {
      "richtig gesetzt werden2" in {
        spielBr.set_revert7(false)
        spielBr.get_revert7() should be(false)
      }
    }

    "Lauffeld" should {
      "richtig gesetzt werden" in {
        spielBr.set_spiel_Lauf_Feld(lF)
        spielBr.get_spiel_Lauf_Feld().getFeld().size should be(1)
      }
    }

  }

  "Spieler" should {

    //var lF = new Lauffeld()
    var feld = collection.mutable.Map[Spielfigur, Int]()
    feld += ((new Spielfigur().setSpielfigur("S1"), 1))
    feld += ((new Spielfigur().setSpielfigur("S2"), 2))
    feld += ((new Spielfigur().setSpielfigur("S3"), 3))
    //var spielBr = new Spielbrett()

    var sp = new Spieler()
    sp.setZiel(feld)
    sp.setKarte(5)
    sp.setKarte(14)
    sp.setSpieler(1, 0)
    sp.setStart(feld)

    "Alle im Ziel anzeigen" should {
      "alle da sein" in {
        sp.alleImZiel() should be(false)
      }
    }

    "Alle im Ziel anzeigen2" should {
      "nicht alle da sein" in {
        feld += ((new Spielfigur().setSpielfigur("S4"), 4))
        sp.setZiel(feld)
        sp.alleImZiel() should be(true)
      }
    }

    "Alle karten loeschen" should {
      "alle loeschen" in {
        sp.delAllKarte()
        sp.getAnzKart() should be(0)
      }
    }

    
    "Eine karte loeschen" should {
      "eine uebrig sein" in {
        sp.setKarte(5)
        sp.setKarte(5)
        sp.delKarte(5)
        sp.getAnzKart() should be(1)
      }
    }
    
    "Eine figur im start loeschen" should {
      "noch 3 uebrig sein" in {
        sp.delFigur(sp.getFig("S1"))
        sp.getStart().size should be(3)
      }
    }
    
    "ID" should {
      "Nr 1 sein" in {
        sp.getId() should be(1)
      }
    }
    
    "Startpos" should {
      "Nr 0 sein" in {
        sp.getStartPos() should be(0)
      }
    }
    
    "Karten" should {
      "anzahl soll 1 sein" in {
        sp.getKarten().length should be(1)
      }
    }
    
    "kleinste Karte1" should {
      "2" in {
        sp.setKarte(2)
        sp.getkleinsteKarte() should be(2)
      }
    }
    
    "kleinste Karte2" should {
      "5" in {
        sp.delKarte(2)
        sp.setKarte(13)
        sp.getkleinsteKarte() should be(5)
      }
    }

    "Alle im Start anzeigen" should {
      "alle da sein" in {
        sp.getStart().size should be(3)
      }
    }

    "Alle im Ziel anzeigen2" should {
      "3 im ziel sind" in {
        sp.getZiel().size should not be(3)
      }
    }
    
    "setKarte" should {
      "Alle Karten ueberschreiben" in {
        var alleKar = new ArrayBuffer[Int]
        alleKar += 2 += 5 += 6
        sp.setKarten(alleKar)
        sp.getKarten().length should be(3)
      }
    }
    
    "setStart" should {
      "Alle Figuren im start setzen" in {
        sp.getStart().clear()
        sp.setStart()
        sp.getStart().size should be(4)
      }
    }
    
    
    
    
    
  }

}
