package main.scala.de.htwg.se.DogGame.model


abstract class Abstractfeld {
  import scala.collection.mutable.ArrayBuffer
  import _root_.main.scala.de.htwg.se.DogGame.model.Spielfigur

  var feld = collection.mutable.Map[Spielfigur, Int]() 
  
  
  def getFeld(): collection.mutable.Map[Spielfigur, Int] = {
    return feld
  }
  
  def posBelegt(pos: Int): Boolean = {
    var check = false
    for ((k, v) <- feld) {
      if (v == pos) {
        check = true
      }
    }
    return check
  }
  
  def setFeld(lF: collection.mutable.Map[Spielfigur, Int]){
    feld.clear()
    feld ++= lF
  }
}