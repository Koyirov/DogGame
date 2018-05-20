package src.test.scala.de.htwg.se.DogGame.util

import main.scala.de.htwg.se.DogGame.controller.Startspiel
import main.scala.de.htwg.se.DogGame.view.SwingGui

object Maingame {

  def main(args: Array[String]) {
    var game = new Startspiel()
    game.start_spiel()
    //SwingGui.main(args)
    //fr.top
  }
}