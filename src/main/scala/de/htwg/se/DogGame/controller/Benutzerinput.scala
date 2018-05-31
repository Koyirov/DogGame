package main.scala.de.htwg.se.DogGame.controller

case class Benutzerinput(guiBoolean: Boolean){
  
  def figur_waehlen(): Int = {
    var check1 = false
    var fig = 0;
    while (check1 == false) {
      println("Waehlen Sie eine Figur!")
      var figStr = scala.io.StdIn.readLine()
      var s = StrToIntK(figStr)

      while (s == None) {
        println("Waehlen Sie eine Figur!")
        figStr = scala.io.StdIn.readLine()
        s = StrToIntK(figStr)

      }
      fig = s.get
      if (fig >= 1 && fig <= 4) {
        check1 = true;
      }
      if (!check1) {
        println("Diese Figur haben Sie nicht.")
      }

    }
    return fig
  }

  def spFigur_waehlen(): String = {

    return scala.io.StdIn.readLine()
  }

  def opt_waehlen(): Int = {
    var opt = -1
    var check2 = false
    while (check2 == false) {
      println("Waehlen Sie eine Option aus!")
      var optStr = scala.io.StdIn.readLine()
      var s = StrToIntK(optStr)

      while (s == None) {
        println("Waehlen Sie eine Option aus!")
        optStr = scala.io.StdIn.readLine()
        s = StrToIntK(optStr)

      }
      opt = s.get

      if (opt >= 0 && opt <= 15) {
        check2 = true;
      }
      if (!check2) {
        println("Diese Option haben Sie nicht.")
      }

    }
    return opt
  }
  
  def anz_Spieler_waehlen(): Int = {
    
    var s = StrToIntK(scala.io.StdIn.readLine())
    while (s == None || s.get != 4){
      println("Bitte eine Zahl eingeben. (4)")
      s = StrToIntK(scala.io.StdIn.readLine())
    }
    return 4
  }
  
  def karte_waehlen(): Option[Int] = {
    var spKart = scala.io.StdIn.readLine()
    var sK = StrToIntK(spKart)
    return sK       
  }
  
  
  
  def StrToIntK(s: String): Option[Int] = {
    try {
      if(s.equals("exit")){
        System.exit(1)
      }
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

}