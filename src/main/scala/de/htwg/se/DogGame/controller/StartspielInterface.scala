package main.scala.de.htwg.se.DogGame.controller

import main.scala.de.htwg.se.DogGame.view.SwingGui 

trait StartspielInterface{
  
  var guiIns = new SwingGui()
  
  def start_spiel()
}