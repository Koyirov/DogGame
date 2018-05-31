package src.test.scala.de.htwg.se.DogGame.util

import java.awt.Dimension
import main.scala.de.htwg.se.DogGame.controller.Startspiel
import main.scala.de.htwg.se.DogGame.view.SwingGui

object Maingame {

  def main(args: Array[String]) {

    var guiBoolean = false
    println("gui?")
    var input = scala.io.StdIn.readLine()
    if (input == "gui") {
      guiBoolean = true
    }
    var game = new Startspiel(guiBoolean)

    if (guiBoolean) {
      game.guiIns = new SwingGui()
      //game.guiIns.size_=(new Dimension(580, 680))
      game.guiIns.size_=(new Dimension(1280, 720))
      game.guiIns.visible_=(true)

    }
    game.start_spiel()
    //SwingGui.main(args)
    //fr.top
  }
}