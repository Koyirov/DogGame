package main.scala.de.htwg.se.DogGame.model

class Spielfigur(sp: String) extends Ordering[Spielfigur]{
  
   var figur: String = sp
   
   def setFigur(fig: String){
     figur = fig
   }
   
   def getFigur(): String = {
     return figur
   }
   
   def compare(a: Spielfigur, b: Spielfigur):Int = {
     
     return a.getFigur() compare b.getFigur();
   }
   
   def equals (a: Spielfigur):Boolean={
     return a.getFigur().equals( getFigur());
   }
}