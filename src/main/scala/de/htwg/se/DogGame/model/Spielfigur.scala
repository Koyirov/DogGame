package main.scala.de.htwg.se.DogGame.model

class Spielfigur(sp: String) extends SpielfigurInterfaces{
  
   var figur: String = sp
   
   override def getFigur(): String = {
     return figur
   }
}