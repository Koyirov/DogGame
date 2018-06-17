package main.scala.de.htwg.se.DogGame

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule

import main.scala.de.htwg.se.DogGame.view.{FensterInterface, SwingGuiInterface, TuiInterface}
import main.scala.de.htwg.se.DogGame.controller.StartspielInterface
import main.scala.de.htwg.se.DogGame.model.{FeldInterfaces, KartenInterfaces, 
  SpielbrettInterfaces, SpielerInterfaces, SpielfigurInterfaces}

class DependencyModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {

  }
}