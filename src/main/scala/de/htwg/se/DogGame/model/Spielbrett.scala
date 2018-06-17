package main.scala.de.htwg.se.DogGame.model

case class Spielbrett() extends SpielbrettInterfaces{
  import scala.collection.mutable.ArrayBuffer
  import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
  
  private var spLf = new Lauffeld()
  private var spPl = ArrayBuffer[Spieler]()
  private var revert7 = false
  
  override def set_spiel_Lauf_Feld(spielLF: Lauffeld){
    spLf = spielLF
  }
  
  override def set_spiel_Player(spielPl: ArrayBuffer[Spieler]){
    spPl = spielPl
  }
  
  override def set_revert7(revert: Boolean){
    revert7 = revert
  }
  
  override def get_spiel_Lauf_Feld(): Lauffeld = {
    return spLf
  }
  
  override def get_spiel_Player(): ArrayBuffer[Spieler] = {
    return spPl
  }
  
  override def get_revert7(): Boolean = {
    return revert7
  }
  
  override def remove_Spiel_Brett(){
    spLf = new Lauffeld()
    spPl = ArrayBuffer[Spieler]()
    revert7 = false
  }
}