package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer

class Karten() extends KartenInterfaces{
    
  var karten = ArrayBuffer[Int]()
  
  override def setKarte(kar: Int) {
    karten += kar
  }

  override def getAnzKart(): Int = {
    return karten.length;
  }

  override def getKarten(): ArrayBuffer[Int] = {
    return karten;
  }
  
//  def getkleinsteKarte(): Int = {
//    if(karten.contains(14))
//      return 1
//      
//    return karten.min
//  }

//  def getKartenAusgabe(): String = {
//    var hand = "Deine Handkarten: "
//
//    for (i <- karten) {
//      hand += i.toString() + ", "
//    }
//
//    return hand;
//  }
//
//  def delKarte(kar: Int) {
//    karten -= kar
//  }
//  
//  def delAllKarte() {
//    karten.clear()
//  }

}