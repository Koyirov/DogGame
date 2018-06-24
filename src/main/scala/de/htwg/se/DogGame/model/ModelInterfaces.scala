package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer

trait LauffeldInterfaces {
  def getFeld: collection.mutable.Map[Spielfigur, Int]
  def posBelegt(pos: Int): Boolean
  def setFeld(lF: collection.mutable.Map[Spielfigur, Int])
  def getFigur(fig: String): Spielfigur
}

trait KartenInterfaces {
  def setKarte(kar: Int)
  def getKarten: ArrayBuffer[Int]
}

trait SpielbrettInterfaces {
  def set_spiel_Lauf_Feld(spielLF: Lauffeld)
  def set_spiel_Player(spielPl: SpielerInterfaces)
  def set_revert7(revert: Boolean)
  def get_spiel_Lauf_Feld: Lauffeld
  def get_spiel_Player: Spieler
  def get_revert7: Boolean
  def remove_Spiel_Brett
}

trait SpielerInterfaces{
  def setSpieler(id: Int, stPos: Int): Spieler
  def getId: Int
  def getName: String
  def setStart
  def getStart: collection.mutable.Map[Spielfigur, Int]
  def setStart(zielF: collection.mutable.Map[Spielfigur, Int])
  def getZiel: collection.mutable.Map[Spielfigur, Int]
  def setZiel(zielF: collection.mutable.Map[Spielfigur, Int])
  def setKarte(kar: Int)
  def getAnzKart: Int
  def getKarten: ArrayBuffer[Int]
  def setKarten(kart: ArrayBuffer[Int])
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
  def setSpielfigur(sp: String): Spielfigur
  def getFigur: String
}