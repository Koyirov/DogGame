package main.scala.de.htwg.se.DogGame.view

case class Tui() {
  
  import scala.collection.mutable.ArrayBuffer
  import main.scala.de.htwg.se.DogGame.model.Spieler
  import main.scala.de.htwg.se.DogGame.model.Spielfigur
  import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
  import org.apache.logging.log4j.{ LogManager, Logger, Level}
  
  val logger: Logger = LogManager.getLogger(this.getClass.getName)
  
  def tui_v1(lF: Lauffeld, p: ArrayBuffer[Spieler]) {
    
    logger.log(Level.INFO, "tui_v1() zeigt auktuelle Spiel Zustand")
    var l = lF.getFeld().map(_.swap)

    println("Spielfeld:")
    println("                                                            " + sz(p, 2, 0, 1) + "  " + sz(p, 2, 0, 2) + "  " + sz(p, 2, 0, 3) + "  " + sz(p, 2, 0, 4) + "           ")
    println("                                                                        ")
    println("        " + pos(l, p, 0) + "  " + pos(l, p, 1) + "  " + pos(l, p, 2) + "  " + pos(l, p, 3) + "  " + pos(l, p, 4) + "  " + pos(l, p, 5) + "  " + pos(l, p, 6) + "  " + pos(l, p, 7) + "  " + pos(l, p, 8) + "  " + pos(l, p, 9) + "  " + pos(l, p, 10) + "  " + pos(l, p, 11) + "  " + pos(l, p, 12) + "  " + pos(l, p, 13) + "  " + pos(l, p, 14) + "  " + pos(l, p, 15) + "  " + pos(l, p, 16) + "      ")
    println("                                                                        ")
    println("    " + sz(p, 1, 0, 1) + "  " + pos(l, p, 63) + "      " + sz(p, 1, 1, 1) + "                                              " + sz(p, 2, 1, 1) + "      " + pos(l, p, 17) + "        ")
    println("                                                                         ")
    println("    " + sz(p, 1, 0, 2) + "  " + pos(l, p, 62) + "          " + sz(p, 1, 1, 2) + "                                      " + sz(p, 2, 1, 2) + "          " + pos(l, p, 18) + "        ")
    println("                                                                         ")
    println("    " + sz(p, 1, 0, 3) + "  " + pos(l, p, 61) + "              " + sz(p, 1, 1, 3) + "                              " + sz(p, 2, 1, 3) + "              " + pos(l, p, 19) + "        ")
    println("                                                                         ")
    println("    " + sz(p, 1, 0, 4) + "  " + pos(l, p, 60) + "                  " + sz(p, 1, 1, 4) + "                      " + sz(p, 2, 1, 4) + "                  " + pos(l, p, 20) + "        ")
    println("                                                                         ")
    println("        " + pos(l, p, 59) + "                                                              " + pos(l, p, 21) + "        ")
    println("                                                                         ")
    println("        " + pos(l, p, 58) + "                                                              " + pos(l, p, 22) + "        ")
    println("                                                                        ")
    println("        " + pos(l, p, 57) + "                                                              " + pos(l, p, 23) + "        ")
    println("                                                                        ")
    println("        " + pos(l, p, 56) + "                                                              " + pos(l, p, 24) + "        ")
    println("                                                                              ")
    println("        " + pos(l, p, 55) + "                                                              " + pos(l, p, 25) + "        ")
    println("                                                                        ")
    println("        " + pos(l, p, 54) + "                                                              " + pos(l, p, 26) + "        ")
    println("                                                                        ")
    println("        " + pos(l, p, 53) + "                                                              " + pos(l, p, 27) + "        ")
    println("                                                                        ")
    println("        " + pos(l, p, 52) + "                  " + sz(p, 4, 1, 4) + "                      " + sz(p, 3, 1, 4) + "                  " + pos(l, p, 28) + "  " + sz(p, 3, 0, 4) + "     ")
    println("                                                                        ")
    println("        " + pos(l, p, 51) + "              " + sz(p, 4, 1, 3) + "                              " + sz(p, 3, 1, 3) + "              " + pos(l, p, 29) + "  " + sz(p, 3, 0, 3) + "     ")
    println("                                                                        ")
    println("        " + pos(l, p, 50) + "          " + sz(p, 4, 1, 2) + "                                      " + sz(p, 3, 1, 2) + "          " + pos(l, p, 30) + "  " + sz(p, 3, 0, 2) + "     ")
    println("                                                                        ")
    println("        " + pos(l, p, 49) + "      " + sz(p, 4, 1, 1) + "                                              " + sz(p, 3, 1, 1) + "      " + pos(l, p, 31) + "  " + sz(p, 3, 0, 1) + "     ")
    println("                                                                        ")
    println("        " + pos(l, p, 48) + "  " + pos(l, p, 47) + "  " + pos(l, p, 46) + "  " + pos(l, p, 45) + "  " + pos(l, p, 44) + "  " + pos(l, p, 43) + "  " + pos(l, p, 42) + "  " + pos(l, p, 41) + "  " + pos(l, p, 40) + "  " + pos(l, p, 39) + "  " + pos(l, p, 38) + "  " + pos(l, p, 37) + "  " + pos(l, p, 36) + "  " + pos(l, p, 35) + "  " + pos(l, p, 34) + "  " + pos(l, p, 33) + "  " + pos(l, p, 32) + "      ")
    println("                                                              ")
    println("            " + sz(p, 4, 0, 1) + "  " + sz(p, 4, 0, 2) + "  " + sz(p, 4, 0, 3) + "  " + sz(p, 4, 0, 4) + "                                         ")
    println("")
  }

  def pos(l: collection.mutable.Map[Int, Spielfigur], p: ArrayBuffer[Spieler], pos: Int): String = {
    logger.log(Level.INFO, "pos() bestimmt, ob ein Figur sich in angegeben Position befindet")
    if (l.contains(pos))
      // TODO option auspacken
      return l.get(pos).get.getFigur()
    else
      return "■ "
  }

  //AUFRUF: sz(ArrayMitSpielern, SpielerID, 0=start/1=ziel, PositionImFeld)
  def sz(p: ArrayBuffer[Spieler], sID: Int, feldID: Int, posID: Int): String = {
    logger.log(Level.INFO, "sz() bestimmt fuer Start und Zielfelds, ob ein Figur sich in angegeben Position befindet")
    if (feldID == 0) {
      //START
      var st: collection.mutable.Map[Int, Spielfigur] = p(sID - 1).getStart().map(_.swap)
      if (st.contains(posID))
      // TODO option auspacken
        return st.get(posID).get.getFigur()
      else
        return "■ "

    } else {
      //ziel
      var st: collection.mutable.Map[Int, Spielfigur] = p(sID - 1).getZiel().map(_.swap)
      if (st.contains(posID))
      // TODO option auspacken
        return st.get(posID).get.getFigur()
      else
        return "■ "
    }

  }

}