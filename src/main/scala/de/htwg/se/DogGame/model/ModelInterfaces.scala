package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer

trait FeldInterfaces {
  
  import main.scala.de.htwg.se.DogGame.model.Spielfigur
  
  //die Variable gehoert nur zu Zielfeld
  var feld = collection.mutable.Map[Spielfigur, Int]() 
  var ziel = collection.mutable.Map[String, Int]();

  def getFeld: collection.mutable.Map[Spielfigur, Int]
  def posBelegt(pos: Int): Boolean
  def setFeld(lF: collection.mutable.Map[Spielfigur, Int])
  //gehoert nur zu Lauffeld
  def lFIstFrei(p: ArrayBuffer[Spieler], pos: Int)
  def getFigur(fig: String):Spielfigur
  //gehoert nur zu Startfeld
  def setStart(spielerId: Int)
  //gehoert nur zu Zielfeld
  def getZiel(): collection.mutable.Map[String, Int]
  def alleImZiel(): Boolean
}

trait KartenInterfaces {
  
  def setKarte(kar: Int)
  def getAnzKart: Int
  def getKarten: ArrayBuffer[Int]
}

trait SpielbrettInterfaces {
  
  import main.scala.de.htwg.se.DogGame.model.Lauffeld

  private var spLf = new Lauffeld()
  private var spPl = ArrayBuffer[Spieler]()
  var revert7 = false

  def set_spiel_Lauf_Feld(spielLF: Lauffeld)
  def set_spiel_Player(spielPl: ArrayBuffer[Spieler])
  def get_spiel_Lauf_Feld: Lauffeld
  def get_spiel_Player: ArrayBuffer[Spieler]
  def remove_Spiel_Brett
}

trait SpielerInterfaces {

  import main.scala.de.htwg.se.DogGame.model.Spielfigur
  import main.scala.de.htwg.se.DogGame.model.Karten

  var karten = new Karten()
  var start = collection.mutable.Map[Spielfigur, Int]();
  var ziel = collection.mutable.Map[Spielfigur, Int]();
  var figuren = ArrayBuffer[Spielfigur]();

  var startPos: Int = _
  var spielerId: Int = _

  def getId: Int
  def getName: String
  def setStart
  def getStart: collection.mutable.Map[Spielfigur, Int]
  def getZiel: collection.mutable.Map[Spielfigur, Int]
  def setKarte(kar: Int)
  def getAnzKart: Int
  def getKarten: ArrayBuffer[Int]
  def getkleinsteKarte: Int
  def getKartenAusgabe: String
  def delKarte(kar: Int)
  def delAllKarte
  def delFigur(fig: Spielfigur): Boolean
  def getStartPos: Int
  def alleImZiel: Boolean
  def getFig(fig: String): Spielfigur
}

trait SpielfigurInterfaces {
  var figur: String = _

  def setFigur(fig: String)
  def getFigur: String
  def compare(a: Spielfigur, b: Spielfigur): Int
  def equals(a: Spielfigur): Boolean
}