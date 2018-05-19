package main.scala.de.htwg.se.DogGame.model

class Zielfeld {
  
  import scala.collection.mutable.ArrayBuffer
  
  var ziel = collection.mutable.Map[String, Int]();
  
  def getZiel(): collection.mutable.Map[String, Int] = {
    return ziel
  }
  
  def alleImZiel(): Boolean = {
    
    if(ziel.size == 4)
      return true
    
    return false
  }

}