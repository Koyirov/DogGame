package main.scala.de.htwg.se.DogGame

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule

import main.scala.de.htwg.se.DogGame.view.{FensterInterface, SwingGuiInterface, TuiInterface}
import main.scala.de.htwg.se.DogGame.controller.StartspielInterface
import main.scala.de.htwg.se.DogGame.model.{FeldInterfaces, KartenInterfaces, 
  SpielbrettInterfaces, SpielerInterfaces, SpielfigurInterfaces}

import main.scala.de.htwg.se.DogGame.view.{Fenster, SwingGui, Tui}
import main.scala.de.htwg.se.DogGame.controller.Startspiel
import main.scala.de.htwg.se.DogGame.model.{Lauffeld, Karten, 
  Spielbrett, Spieler, Spielfigur}

class DependencyModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[FensterInterface].to[Fenster]
    bind[SwingGuiInterface].to[SwingGui]
    bind[TuiInterface].to[Tui]
    bind[StartspielInterface].to[Startspiel]
    bind[FeldInterfaces].to[Lauffeld]
    bind[SpielbrettInterfaces].to[Spielbrett]
    bind[SpielerInterfaces].to[Spieler]
    bind[SpielfigurInterfaces].to[Spielfigur]
  }
}