package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer

class Karten() {
    
  var karten = ArrayBuffer[Int]()
  
  def setKarte(kar: Int) {
    karten += kar
  }

  def getAnzKart(): Int = {
    return karten.length;
  }

  def getKarten(): ArrayBuffer[Int] = {
    return karten;
  }
  
  def getkleinsteKarte(): Int = {
    if(karten.contains(14))
      return 1
      
    return karten.min
  }

  def getKartenAusgabe(): String = {
    var hand = "Deine Handkarten: "

    for (i <- karten) {
      hand += i.toString() + ", "
    }

    return hand;
  }

  def delKarte(kar: Int) {
    karten -= kar
  }
  
  def delAllKarte() {
    karten.clear()
  }

}