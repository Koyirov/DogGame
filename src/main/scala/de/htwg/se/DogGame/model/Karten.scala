package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer
import com.google.inject.Inject

@Inject
class Karten() extends KartenInterfaces{
    
  var karten = ArrayBuffer[Int]()
  
  override def setKarte(kar: Int) {
    karten += kar
  }

  override def getKarten(): ArrayBuffer[Int] = {
    return karten;
  }
  
  def getAnzKart(): Int = {
    return karten.length;
  }
}