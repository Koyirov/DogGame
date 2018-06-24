package main.scala.de.htwg.se.DogGame.model

import com.google.inject.Inject

@Inject
class Spielfigur () extends SpielfigurInterfaces{
  
   var figur: String = null
   
   override def setSpielfigur(sp: String): Spielfigur={
     figur = sp
     return this
   }
   override def getFigur(): String = {
     return figur
   }
}