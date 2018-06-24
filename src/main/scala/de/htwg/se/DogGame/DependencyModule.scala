package main.scala.de.htwg.se.DogGame

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule

import main.scala.de.htwg.se.DogGame.controller.StartspielInterface
import main.scala.de.htwg.se.DogGame.model.{LauffeldInterfaces, KartenInterfaces, 
  SpielbrettInterfaces, SpielerInterfaces, SpielfigurInterfaces}

import main.scala.de.htwg.se.DogGame.controller.Startspiel
import main.scala.de.htwg.se.DogGame.model.{Lauffeld, Karten, 
  Spielbrett, Spieler, Spielfigur}

class DependencyModule(guiBoolean: Boolean) extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    //bind(classOf[StartspielInterface]).toInstance(new Startspiel(guiBoolean))
    bind(classOf[LauffeldInterfaces]).to(classOf[Lauffeld]) 
    bind(classOf[SpielbrettInterfaces]).to(classOf[Spielbrett]) 
    bind(classOf[SpielerInterfaces]).to(classOf[Spieler]) 
    bind(classOf[SpielfigurInterfaces]).to(classOf[Spielfigur])
    bind(classOf[KartenInterfaces]).to(classOf[Karten])
  }
}