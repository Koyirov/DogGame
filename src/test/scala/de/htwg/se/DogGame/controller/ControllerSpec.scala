package test.scala.de.htwg.se.DogGame.controller
import main.scala.de.htwg.se.DogGame.controller.StartspielInterface
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{ Matchers, WordSpec }
import main.scala.de.htwg.se.DogGame.controller.Startspiel
import scala.collection.mutable.ArrayBuffer
import main.scala.de.htwg.se.DogGame.model.Spieler
import main.scala.de.htwg.se.DogGame.model.Karten
import org.scalatest.Ignore

@Ignore
@RunWith(classOf[JUnitRunner])
class ControllerSpec extends WordSpec with Matchers {
  "DogGame startSpiel" should {
    "not crash" in {
      // add tests when available
      true should be(true)
    }
  }
  var players = new ArrayBuffer[Spieler]
  var sp = new Startspiel(false)
  var kartenStapel = new Karten()
  // kartenstapel auffuellen
  kartenStapel.getKarten().clear()
  for (wert <- 1 to 14) {
    for (anz <- 1 to 4) {
      kartenStapel.setKarte(wert)

    }

  }

  "addSpieler" should {
    "add 4 Spieler" in {
      sp.addSpieler(players, 4)
      players.length should be(4)
    }
  }

  "VerteileKarte " should {
    "6 karten geben" in {
      sp.verteieleKarte(players, kartenStapel, 6)
      players(1).getAnzKart() should be(6)
    }
    "4 karten geben" in {
      
      players(1).delAllKarte()
      sp.verteieleKarte(players, kartenStapel, 4)
      players(1).getAnzKart() should be(4)
    }
    "2 karten geben" in {
     
      players(1).delAllKarte()
      sp.verteieleKarte(players, kartenStapel, 2)
      players(1).getAnzKart() should be(2)
    }
  }

}
