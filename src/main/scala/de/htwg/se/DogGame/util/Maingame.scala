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
import com.google.inject.Guice
import main.scala.de.htwg.se.DogGame.DependencyModule
import main.scala.de.htwg.se.DogGame.controller.StartspielInterface

object Maingame {

  val logger: Logger = LogManager.getLogger(this.getClass.getName)

  def main(args: Array[String]) {

    var guiBoolean = false
    println("gui?")
    var input = scala.io.StdIn.readLine()
    if (input == "gui") {
      guiBoolean = true
    }
    val injector = Guice.createInjector(new DependencyModule(guiBoolean))
    //var game = injector.getInstance(classOf[StartspielInterface])
    var game = new Startspiel(guiBoolean)
    
    if (guiBoolean) {
      val filename = "/home/shohrukh/Schreibtisch/Eclipse_projecte/DogGame/Anleitung.txt"
      var anleitung = ""
      for (line <- Source.fromFile(filename).getLines) {
        anleitung += line + "\n"
      }
      var anl_fenster = injector.getInstance(classOf[Fenster])
      //var anl_fenster = new Fenster()
      anl_fenster.zeig_anleitung(anleitung)
      anl_fenster.visible_=(true)

      while (anl_fenster.visible) {}

      game.guiIns.size_=(new Dimension(1280, 720))
      game.guiIns.visible_=(true)

    }
    logger.log(Level.INFO, "Maingame() User will " + input)
    game.start_spiel()
  }

}
