package main.scala.de.htwg.se.DogGame.model

case class Spielbrett(){
  import scala.collection.mutable.ArrayBuffer
  import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
  
  //var spPublicLf = new Lauffeld()
  private var spLf = new Lauffeld()
  private var spPl = ArrayBuffer[Spieler]()
  var revert7 = false
  
  //def set_spPublicLf(spPubLf: Lauffeld) {
    //spPublicLf = spPubLf
  //}
  
  def set_spiel_Lauf_Feld(spielLF: Lauffeld){
    spLf = spielLF
  }
  
  def set_spiel_Player(spielPl: ArrayBuffer[Spieler]){
    spPl = spielPl
  }
  
  
  //def get_spPublicLf(): Lauffeld = {
    //return spPublicLf
  //}
  
  def get_spiel_Lauf_Feld(): Lauffeld = {
    return spLf
  }
  
  def get_spiel_Player(): ArrayBuffer[Spieler] = {
    return spPl
  }
  
  def remove_Spiel_Brett(){
    //spPublicLf = new Lauffeld()
    spLf = new Lauffeld()
    spPl = ArrayBuffer[Spieler]()
    revert7 = false
  }
  
}