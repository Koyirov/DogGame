package main.scala.de.htwg.se.DogGame.model

class Startfeld(st: Int) extends Abstractfeld{
  import _root_.main.scala.de.htwg.se.DogGame.model.Spielfigur
  
  def setStart(spielerId: Int) {
    for (i <- 1 to 4) {
      spielerId match {
        case 1 => feld += ((new Spielfigur("B" + i), i))
        case 2 => feld += ((new Spielfigur("R" + i), i))
        case 3 => feld += ((new Spielfigur("G" + i), i))
        case 4 => feld += ((new Spielfigur("S" + i), i))
      }
    }
  }
}