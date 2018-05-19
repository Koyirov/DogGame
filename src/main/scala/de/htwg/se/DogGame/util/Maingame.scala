package src.test.scala.de.htwg.se.DogGame.util

import _root_.main.scala.de.htwg.se.DogGame.controller.Startspiel

object Maingame {
 
  def main(args: Array[String]){
    var game = new Startspiel()
    game.start_spiel()
  }
}