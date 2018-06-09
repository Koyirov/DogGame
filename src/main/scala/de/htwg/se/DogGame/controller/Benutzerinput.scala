package main.scala.de.htwg.se.DogGame.controller

import main.scala.de.htwg.se.DogGame.view.SwingGui
import scala.util.control.Breaks._
import main.scala.de.htwg.se.DogGame.model.Spielfigur

case class Benutzerinput(guiBoolean: Boolean, guiIns: SwingGui) {

  var spieler_farben = guiIns.spieler_farben

  def figur_waehlen(): Int = {
    guiIns.frame_comp.nutzerEingabe.editable_=(false)
    var check1 = false
    var fig = 0;
    var gui_prefix = ""
    while (!check1) {
      var figStr = ""
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=(gui_prefix + "Waehle eine Figur.")
        if (guiIns.feld_inhalt_lfb != "") {
          figStr = guiIns.feld_inhalt_lfb
          guiIns.feld_inhalt_lfb = ""
        }
      } else {
        println("Waehle eine Figur.")
        figStr = scala.io.StdIn.readLine()
      }
      var s = StrToIntK(figStr)

      if (s != None) {
        fig = s.get
        if (fig >= 1 && fig <= 4) {
          check1 = true;
        }
        if (!check1) {
          if (guiBoolean) {
            gui_prefix = "Diese Figur hast du nicht.\n"
          } else {
            println("Diese Figur hast du nicht.")
          }
        }
      }
    }
    return fig
  }

  def spFigur_waehlen(): String = {
    return scala.io.StdIn.readLine()
  }

  def spFigur_waehlen_gui(): String = {
    guiIns.frame_comp.nutzerEingabe.editable_=(false)

    var sp = ""
    if (guiIns.but_farbe == java.awt.Color.blue) {
      if (guiIns.tausch_figur != "") {
        sp = "B" + guiIns.tausch_figur
        guiIns.tausch_figur = ""
      }
    } else if (guiIns.but_farbe == spieler_farben(1)) {
      if (guiIns.tausch_figur != "") {
        sp = "R" + guiIns.tausch_figur
        guiIns.tausch_figur = ""
      }
    } else if (guiIns.but_farbe == spieler_farben(2)) {
      if (guiIns.tausch_figur != "") {
        sp = "G" + guiIns.tausch_figur
        guiIns.tausch_figur = ""
      }
    } else {
      if (guiIns.tausch_figur != "") {
        sp = "S" + guiIns.tausch_figur
        guiIns.tausch_figur = ""
      }
    }
    return sp

  }

  def opt_waehlen(ausg: String): Int = {
    guiIns.frame_comp.nutzerEingabe.editable_=(true)
    var opt = -1
    var check2 = false
    while (check2 == false) {
      var optStr = ""
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=(ausg + "Waehle eine Option aus!")
        if (guiIns.feld_inhalt_tab != "") {
          optStr = guiIns.feld_inhalt_tab
          guiIns.feld_inhalt_tab = ""
        }
        //guiIns.wert_verfuegbar_tab = false
      } else {
        println("Waehle eine Option aus!")
        optStr = scala.io.StdIn.readLine()
      }
      var s = StrToIntK(optStr)

      while (s == None) {

        var optStr = ""
        if (guiBoolean) {
          guiIns.frame_comp.textLabel.text_=(ausg + "Waehle eine Option aus!")
          if (guiIns.feld_inhalt_tab != "") {
            optStr = guiIns.feld_inhalt_tab
            guiIns.feld_inhalt_tab = ""
          }

        } else {
          println("Waehle eine Option aus!")
          optStr = scala.io.StdIn.readLine()
        }

        s = StrToIntK(optStr)

      }
      opt = s.get

      if (opt >= 0 && opt <= 15) {
        check2 = true;
      }
      if (!check2) {
        if (guiBoolean) {
          guiIns.frame_comp.textLabel.text_=("Diese Option hast du nicht.")
        } else {
          println("Diese Option hast du nicht.")
        }
      }
    }
    return opt
  }

  def anz_Spieler_waehlen(): Int = {
    guiIns.frame_comp.nutzerEingabe.editable_=(true)
    var s = StrToIntK("")

    while (s == None || s.get != 4) {
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=("Bitte eine Zahl eingeben. (4)")
        if (guiIns.feld_inhalt_tab != "") {
          s = StrToIntK(guiIns.feld_inhalt_tab)
          guiIns.feld_inhalt_tab = ""
        }
      } else {
        println("Bitte eine Zahl eingeben. (4)")
        s = StrToIntK(scala.io.StdIn.readLine())
      }
    }
    return s.get
  }

  def karte_waehlen(): Option[Int] = {
    guiIns.frame_comp.nutzerEingabe.editable_=(true)
    var spKart = ""
    if (guiBoolean) {
      if (guiIns.feld_inhalt_kb != "") {
        spKart = guiIns.feld_inhalt_kb
        guiIns.feld_inhalt_kb = ""
      }
      if (guiIns.feld_inhalt_tab != "") {
        spKart = guiIns.feld_inhalt_tab
        guiIns.feld_inhalt_tab = ""
      }
    } else {
      spKart = scala.io.StdIn.readLine()
    }
    var sK = StrToIntK(spKart)
    return sK
  }

  def waehle_Joker(): Int = {
    guiIns.frame_comp.nutzerEingabe.editable_=(true)
    var s = StrToIntK("")

    while (s == None) {
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=("Waehle eine Karte aus die der Joker sein soll.")
        if (guiIns.feld_inhalt_tab != "") {
          s = StrToIntK(guiIns.feld_inhalt_tab)
          guiIns.feld_inhalt_tab = ""
        }
      } else {
        println("Waehle eine Karte aus die der Joker sein soll.")
        s = StrToIntK(scala.io.StdIn.readLine())
      }
    }

    return s.get
  }

  def StrToIntK(s: String): Option[Int] = {
    try {
      if (s.equals("exit")) {
        System.exit(1)
      }
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }
}