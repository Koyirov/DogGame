package main.scala.de.htwg.se.DogGame.view

import scala.swing._
//used to listen
import scala.swing.event._
// for borderlayout
import scala.swing.BorderPanel.Position._
//used for dice
import scala.util.Random
//Use the ImageIcon directly from Java
import javax.swing.ImageIcon
import javax.swing.UIManager
import javax.swing.border.Border
import java.awt
import scala.collection.mutable.ArrayBuffer
import main.scala.de.htwg.se.DogGame.model.Spieler
import main.scala.de.htwg.se.DogGame.model.Spielfigur
import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld
import _root_.main.scala.de.htwg.se.DogGame.view.FrameComp

//object SwingGui extends SimpleSwingApplication {
class SwingGui extends MainFrame {

  title = "DogGame"
  //contents = ui
  var frame_comp = new FrameComp()
  contents = frame_comp.ui
  
  //val lf_buttons = new ArrayBuffer[Button]()
  var lf_buttons = frame_comp.lf_buttons //collection.mutable.Map[Int, Button]()
  var sp_st_zi_fl = frame_comp.sp_st_zi_fl //collection.mutable.Map[String, (ArrayBuffer[Button], ArrayBuffer[Button])]()
  var spieler = Array("B", "R", "G", "S")

  for (pos <- 0 to 63) {
    listenTo(lf_buttons.get(pos).get)
  }
  for (sp <- spieler) {
    var st_feld = sp_st_zi_fl.get(sp).get._1
    var zi_feld = sp_st_zi_fl.get(sp).get._2
    for (pos <- 0 to 3) {
      listenTo(st_feld(pos))
      listenTo(zi_feld(pos))
    }
  }
  listenTo(frame_comp.ok_button)
  var butID = 0
  var clickAnz = 0
  reactions += {
    case e: ButtonClicked => {
      if(e.source.text == "Ok"){
        var result = "4".toCharArray.map(_.toByte)
        var backup = System.in
        var newIn = new java.io.ByteArrayInputStream(result)
        System.setIn(newIn)
        newIn.read(result)
        println("Hier!")
        
        System.setIn(backup)
      }
      if (clickAnz == 0){
        clickAnz += 1
        if (butID != e.hashCode()) {
          butID = e.hashCode()
          e.source.background_=(java.awt.Color.green)
        }
      }else{
        if (butID != e.hashCode()) {
          e.source.background_=(java.awt.Color.lightGray)
          clickAnz -= 1
        }
      }
    }
  }

  def update_Spiel_Brett(lF: Lauffeld, p: ArrayBuffer[Spieler]) {

    var l = lF.getFeld().map(_.swap)

    /*Um alte Farbe und text zu loeschen von Lauffeld*/
    for (pos <- 0 to 63) {
      var button = lf_buttons.get(pos).get
      button.text_=("*")
      button.background_=(java.awt.Color.white)
    }

    for (pos <- 0 to 63) {
      if (l.contains(pos)) {
        var fig_name = l.get(pos).get.getFigur()
        var button = lf_buttons.get(pos).get
        button.text_=(fig_name(1).toString())
        if (fig_name.startsWith("B")) {
          button.background_=(java.awt.Color.blue)
        } else if (fig_name.startsWith("R")) {
          button.background_=(java.awt.Color.red)
        } else if (fig_name.startsWith("G")) {
          button.background_=(java.awt.Color.green)
        } else {
          button.background_=(java.awt.Color.yellow)
        }
      }
    }
    /*Um alte Farbe und text zu loeschen von Start und Zielfeld*/

    for (sp <- spieler) {
      var st_feld = sp_st_zi_fl.get(sp).get._1
      var zi_feld = sp_st_zi_fl.get(sp).get._2
      for (pos <- 0 to 3) {
        var button_st = st_feld(pos)
        button_st.text_=("*")
        button_st.background_=(java.awt.Color.white)
        var button_zi = zi_feld(pos)
        button_zi.text_=("*")
        button_zi.background_=(java.awt.Color.white)
      }

    }

    for (sp <- p) {
      var sp_name = sp.getName()
      var sp_st_feld = sp.getStart().map(_.swap)
      var sp_zi_feld = sp.getZiel().map(_.swap)
      var st_feld = sp_st_zi_fl.get(sp_name).get._1
      var zi_feld = sp_st_zi_fl.get(sp_name).get._2
      if (sp_name == "B") {
        for (pos <- 1 to 4) {
          if (sp_st_feld.contains(pos)) {
            var button = st_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.blue)
          }
          if (sp_zi_feld.contains(pos)) {
            var button = zi_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.blue)
          }
        }
      } else if (sp_name == "R") {
        for (pos <- 1 to 4) {
          if (sp_st_feld.contains(pos)) {
            var button = st_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.red)
          }
          if (sp_zi_feld.contains(pos)) {
            var button = zi_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.red)
          }
        }
      } else if (sp_name == "G") {
        for (pos <- 1 to 4) {
          if (sp_st_feld.contains(pos)) {
            var button = st_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.green)
          }
          if (sp_zi_feld.contains(pos)) {
            var button = zi_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.green)
          }
        }
      } else {
        for (pos <- 1 to 4) {
          if (sp_st_feld.contains(pos)) {
            var button = st_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.yellow)
          }
          if (sp_zi_feld.contains(pos)) {
            var button = zi_feld(pos - 1)
            button.text_=((pos).toString())
            button.background_=(java.awt.Color.yellow)
          }
        }
      }
    }
  }
}





