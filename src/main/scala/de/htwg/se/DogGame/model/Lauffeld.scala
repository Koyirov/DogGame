package main.scala.de.htwg.se.DogGame.model

class Lauffeld extends Abstractfeld{
 
  import scala.collection.mutable.ArrayBuffer
  
  def lFIstFrei(p: ArrayBuffer[Spieler], pos: Int): Boolean = {

    var l = feld.map(_.swap)
    for (einer <- p) {
      //auf einer startposition
      if (pos == einer.getStartPos()) {
        if (l.get(pos) != None) {
          //die richtige figur auf dieser startPos
          if (l.get(pos).get.getFigur().startsWith(einer.getName())) {
            println("Block erkannt.")
            return false
          }
        }
      }
    }

    return true
  }
  
  
  def getFigur(fig: String):Spielfigur = {
    var res = 100
    for(sp <- feld.keys){
      if(sp.getFigur().equals(fig))
        res = feld.get(sp).get
    }
    var um_start = feld.map(_.swap)
    
    if(res != 100){
      return um_start.get(res).get
    }else{
      return null
    }
  }
}