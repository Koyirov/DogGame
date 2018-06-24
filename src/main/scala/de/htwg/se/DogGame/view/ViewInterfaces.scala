package main.scala.de.htwg.se.DogGame.view

import scala.collection.mutable.ArrayBuffer
import main.scala.de.htwg.se.DogGame.model.Lauffeld
import main.scala.de.htwg.se.DogGame.model.Spieler
import main.scala.de.htwg.se.DogGame.model.LauffeldInterfaces
import main.scala.de.htwg.se.DogGame.model.LauffeldInterfaces

trait SwingGuiInterface {
  def update_Spiel_Brett(lF: LauffeldInterfaces, p: ArrayBuffer[Spieler], turn: Int)
}

trait TuiInterface {
  def tui_v1(lF: LauffeldInterfaces, p: ArrayBuffer[Spieler])
}

trait FensterInterface{
  def zeig_anleitung(text: String)
}