package main.scala.de.htwg.se.DogGame.model

class Spieler(id: Int, st: Int) {
 
  import scala.collection.mutable.ArrayBuffer
  import main.scala.de.htwg.se.DogGame.model.Spielfigur
  import main.scala.de.htwg.se.DogGame.model.Karten
  
  val spielerId = id;

  //var karten = ArrayBuffer[Int]();
  var karten = new Karten()
  var start = collection.mutable.Map[Spielfigur, Int]();
  var ziel = collection.mutable.Map[Spielfigur, Int]();
  var figuren = ArrayBuffer[Spielfigur]();
  
  val startPos = st;

  def getId(): Int = {
    return spielerId;
  }

  def getName(): String = {
    spielerId match {
      case 1 => return "B"
      case 2 => return "R"
      case 3 => return "G"
      case 4 => return "S"

    }
  }

  def setStart() {
    for (i <- 1 to 4) {
      spielerId match {
        case 1 => {
          var fig1 = new Spielfigur("B" + i) 
          start += ((fig1, i))
          figuren += fig1  
        }
        case 2 => {
          var fig2 = new Spielfigur("R" + i)
          start += ((fig2, i))
          figuren += fig2
          }
        case 3 => {
          var fig3 = new Spielfigur("G" + i)
          start += ((fig3, i))
          figuren += fig3
        }
        case 4 => {
          var fig4 = new Spielfigur("S" + i)
          start += ((fig4, i))
          figuren += fig4
        }
      }
    }
  }

  def getStart(): collection.mutable.Map[Spielfigur, Int] = {
    return start;
  }

  def getZiel(): collection.mutable.Map[Spielfigur, Int] = {
    return ziel;
  }

  //def setKarte(kar: Int) {
    //karten += kar
  //}
  
  def setKarte(kar: Int) {
    karten.getKarten() += kar
  }
  
  def getAnzKart(): Int = {
    return karten.getKarten().length;
  }

  def getKarten(): ArrayBuffer[Int] = {
    return karten.getKarten();
  }
  
  def getkleinsteKarte(): Int = {
    if(karten.getKarten().contains(14))
      return 1

    if (karten.getKarten().min == 11) {
      var ret = ArrayBuffer[Int]()
      for (k <- karten.getKarten().clone()) {
        if (k != 11)
          ret += k
      }
      if(!ret.isEmpty)
        return ret.min 
    } 
      
    return karten.getKarten().min
  }

  def getKartenAusgabe(): String = {
    var hand = "Deine Handkarten: "

    for (i <- karten.getKarten()) {
      hand += i.toString() + ", "
    }

    return hand;
  }

  def delKarte(kar: Int) {
    karten.getKarten() -= kar
  }
  
  def delAllKarte() {
    karten.getKarten().clear()
  }

  def delFigur(fig: Spielfigur): Boolean = {

    var check = false
    
    if (start.contains(fig))
      
      check = true
      start -= (fig)

    return check

  }

  def getStartPos(): Int = {
    return startPos
  }
  
  def alleImZiel(): Boolean = {
    
    if(ziel.size == 4)
      return true
    
    return false
  }
  
  def getFig(fig: String):Spielfigur = {
  
    for(figur <- figuren){
      if(figur.getFigur().startsWith(fig))
        return figur
    }
    return null
  }
  
  /*def getFigurS(fig: String):Spielfigur = {
    var res = 100
    for(sp <- start.keys){
      if(sp.getFigur().equals(fig))
        res = start.get(sp).get
    }
    var um_start = start.map(_.swap)
    
    if(res != 100){
      return um_start.get(res).get
    }else{
      return null
    }
  }
  
  def getFigurZ(fig: String):Spielfigur = {
    var res = 100
    for(sp <- ziel.keys){
      if(sp.getFigur().equals(fig))
        res = ziel.get(sp).get
    }
    var um_start = ziel.map(_.swap)
    
    if(res != 100){
      return um_start.get(res).get
    }else{
      return null
    }
  }*/

}