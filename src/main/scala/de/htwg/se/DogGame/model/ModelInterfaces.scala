package main.scala.de.htwg.se.DogGame.model

import scala.collection.mutable.ArrayBuffer

trait FeldInterfaces {
  def getFeld: collection.mutable.Map[Spielfigur, Int]
  def posBelegt(pos: Int): Boolean
  def setFeld(lF: collection.mutable.Map[Spielfigur, Int])
  def lFIstFrei(p: ArrayBuffer[Spieler], pos: Int): Boolean
  def getFigur(fig: String):Spielfigur
}

trait KartenInterfaces {
  def setKarte(kar: Int)
  def getKarten: ArrayBuffer[Int]
}

trait SpielbrettInterfaces {
  def set_spiel_Lauf_Feld(spielLF: Lauffeld)
  def set_spiel_Player(spielPl: ArrayBuffer[Spieler])
  def set_revert7(revert: Boolean)
  def get_spiel_Lauf_Feld: Lauffeld
  def get_spiel_Player: ArrayBuffer[Spieler]
  def get_revert7: Boolean
  def remove_Spiel_Brett
}

trait SpielerInterfaces {
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
    def getFigur: String
}