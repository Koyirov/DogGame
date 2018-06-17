package src.test.scala.de.htwg.se.DogGame.util

import java.awt.Dimension
import main.scala.de.htwg.se.DogGame.controller.Startspiel
import main.scala.de.htwg.se.DogGame.view.{ SwingGui }
import main.scala.de.htwg.se.DogGame.view.Fenster
import org.apache.logging.log4j.{ LogManager, Logger, Level }
import scala.io.Source
import scala.swing._
import scala.swing.event._
import scala.swing.BorderPanel.Position._

object Maingame {

  val logger: Logger = LogManager.getLogger(this.getClass.getName)

  def main(args: Array[String]) {

    var guiBoolean = false
    println("gui?")
    var input = scala.io.StdIn.readLine()
    //var input = "gui"
    if (input == "gui") {
      guiBoolean = true
    }
    var game = new Startspiel(guiBoolean)

    if (guiBoolean) {
      val filename = "/home/shohrukh/Schreibtisch/Eclipse_projecte/DogGame/Anleitung.txt"
      var anleitung = ""
      for (line <- Source.fromFile(filename).getLines) {
        anleitung += line + "\n"
      }
      var anl_fenster = new Fenster()
      anl_fenster.zeig_anleitung(anleitung)
      anl_fenster.visible_=(true)
      
      while(anl_fenster.visible){}

      game.guiIns.size_=(new Dimension(1280, 720))
      game.guiIns.visible_=(true)

    }
    logger.log(Level.INFO, "Maingame() User will " + input)
    game.start_spiel()
    //SwingGui.main(args)
    //fr.top
  }

}
