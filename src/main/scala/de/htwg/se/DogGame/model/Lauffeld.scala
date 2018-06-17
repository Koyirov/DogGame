package main.scala.de.htwg.se.DogGame.model

class Lauffeld extends FeldInterfaces{
 
  import scala.collection.mutable.ArrayBuffer
  import main.scala.de.htwg.se.DogGame.model.Spieler
  import main.scala.de.htwg.se.DogGame.model.Spielfigur
  
  private var feld = collection.mutable.Map[Spielfigur, Int]() 
  
  override def getFeld(): collection.mutable.Map[Spielfigur, Int] = {
    return feld
  }
  
  override def posBelegt(pos: Int): Boolean = {
    var check = false
    for ((k, v) <- feld) {
      if (v == pos) {
        check = true
      }
    }
    return check
  }
  
  override def setFeld(lF: collection.mutable.Map[Spielfigur, Int]){
    feld.clear() 
    feld ++= lF
  }
  
  override def lFIstFrei(p: ArrayBuffer[Spieler], pos: Int): Boolean = { 

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
  
  override def getFigur(fig: String):Spielfigur = {
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