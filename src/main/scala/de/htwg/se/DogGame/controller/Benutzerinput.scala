package main.scala.de.htwg.se.DogGame.controller

import main.scala.de.htwg.se.DogGame.view.SwingGui

case class Benutzerinput(guiBoolean: Boolean, guiIns: SwingGui) {

  def figur_waehlen(): Int = {
    guiIns.frame_comp.textLabel.editable_=(false)
    var check1 = false
    var fig = 0;
    var gui_prefix = ""
    while (check1 == false) {
      println("Waehle eine Figur.")
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=(gui_prefix + "Waehle eine Figur.")
      }
      var figStr = ""
      if (guiBoolean) {
        println("waiting!")
        var verlorene_zeit = 0
        while (!guiIns.wert_verfuegbar_lfb) {
          // warte
          verlorene_zeit += 1
          print(" ")
        }
        println("waiting nicht mehr! " + verlorene_zeit)
        figStr = guiIns.feld_inhalt_lfb
        guiIns.wert_verfuegbar_lfb = false
      } else {
        figStr = scala.io.StdIn.readLine()
      }
      var s = StrToIntK(figStr)

      while (s == None) {
        println("Waehle eine Figur.")
        if (guiBoolean) {
          guiIns.frame_comp.textLabel.text_=(gui_prefix + "Waehle eine Figur.")
        }
        var figStr = ""
        if (guiBoolean) {
          println("waiting!")
          var verlorene_zeit = 0
          while (!guiIns.wert_verfuegbar_lfb) {
            // warte
            verlorene_zeit += 1
            print(" ")
          }
          println("waiting nicht mehr! " + verlorene_zeit)
          figStr = guiIns.feld_inhalt_lfb
          guiIns.wert_verfuegbar_lfb = false
        } else {
          figStr = scala.io.StdIn.readLine()
        }
        s = StrToIntK(figStr)

      }
      fig = s.get
      if (fig >= 1 && fig <= 4) {
        check1 = true;
      }
      if (!check1) {
        println("Diese Figur hast du nicht.")
        if (guiBoolean) {
          gui_prefix = "Diese Figur hast du nicht.\n"
        }
      }

    }
    return fig
  }

  def spFigur_waehlen(): String = {
    guiIns.frame_comp.textLabel.editable_=(false)
    var figStr = ""
    if (guiBoolean) {
      println("waiting!")
      var verlorene_zeit = 0
      while (!guiIns.wert_verfuegbar_lfb) {
        // warte
        verlorene_zeit += 1
        print(" ")
      }
      println("waiting nicht mehr! " + verlorene_zeit)
      guiIns.wert_verfuegbar_lfb = false
      return guiIns.feld_inhalt_lfb
    } else {
      return scala.io.StdIn.readLine()
    }

  }

  def opt_waehlen(ausg: String): Int = {
    guiIns.frame_comp.textLabel.editable_=(true)
    var opt = -1
    var check2 = false
    while (check2 == false) {
      println("Waehlen Sie eine Option aus!")
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=(ausg + "\n" + "Waehlen Sie eine Option aus!")
      }
      var optStr = ""
      if (guiBoolean) {
        println("waiting!")
        var verlorene_zeit = 0
        while (!guiIns.wert_verfuegbar_tab) {
          // warte
          verlorene_zeit += 1
          print(" ")
        }
        println("waiting nicht mehr! " + verlorene_zeit)
        optStr = guiIns.feld_inhalt_tab
        guiIns.wert_verfuegbar_tab = false
      } else {
        optStr = scala.io.StdIn.readLine()
      }
      var s = StrToIntK(optStr)

      while (s == None) {
        println("Waehlen Sie eine Option aus!")
        if (guiBoolean) {
          guiIns.frame_comp.textLabel.text_=("Waehlen Sie eine Option aus!")
        }
        var optStr = ""
        if (guiBoolean) {
          println("waiting!")
          var verlorene_zeit = 0
          while (!guiIns.wert_verfuegbar_tab) {
            // warte
            verlorene_zeit += 1
            print(" ")
          }
          println("waiting nicht mehr! " + verlorene_zeit)
          optStr = guiIns.feld_inhalt_tab
          guiIns.wert_verfuegbar_tab = false
        } else {
          optStr = scala.io.StdIn.readLine()
        }

        s = StrToIntK(optStr)

      }
      opt = s.get

      if (opt >= 0 && opt <= 15) {
        check2 = true;
      }
      if (!check2) {
        println("Diese Option haben Sie nicht.")
        if (guiBoolean) {
          guiIns.frame_comp.textLabel.text_=("Diese Option haben Sie nicht.")
        }
      }

    }
    return opt
  }

  def anz_Spieler_waehlen(): Int = {
    guiIns.frame_comp.textLabel.editable_=(true)
    var s = StrToIntK("")
    if (guiBoolean) {
      println("waiting!")
      var verlorene_zeit = 0
      while (!guiIns.wert_verfuegbar_tab) {
        // warte
        verlorene_zeit += 1
        print(" ")
      }
      println("waiting nicht mehr! " + verlorene_zeit)
      s = StrToIntK(guiIns.feld_inhalt_tab)
      guiIns.wert_verfuegbar_tab = false
    } else {
      s = StrToIntK(scala.io.StdIn.readLine())
    }

    //while (guiBoolean && !wert_verfuegbar) {
    // warten
    //}
    //s = StrToIntK(feld_inhalt)
    //wert_verfuegbar = false

    while (s == None || s.get != 4) {
      println("Bitte eine Zahl eingeben. (4)")
      if (guiBoolean) {
        guiIns.frame_comp.textLabel.text_=("Bitte eine Zahl eingeben. (4)")
      }

      if (guiBoolean) {
        println("waiting!")
        var verlorene_zeit = 0
        while (!guiIns.wert_verfuegbar_tab) {
          // warte
          verlorene_zeit += 1
          print(" ")
        }
        println("waiting nicht mehr! " + verlorene_zeit)
        s = StrToIntK(guiIns.feld_inhalt_tab)
        guiIns.wert_verfuegbar_tab = false
      } else {
        s = StrToIntK(scala.io.StdIn.readLine())
      }
    }
    return s.get
  }

  def karte_waehlen(): Option[Int] = {
    guiIns.frame_comp.textLabel.editable_=(false)
    var spKart = ""
    if (guiBoolean) {
      println("waiting!")
      var verlorene_zeit = 0
      while (!guiIns.wert_verfuegbar_kb) {
        // warte
        verlorene_zeit += 1
        print(" ")
      }
      println("waiting nicht mehr! " + verlorene_zeit)
      spKart = guiIns.feld_inhalt_kb
      guiIns.wert_verfuegbar_kb = false
    } else {
      spKart = scala.io.StdIn.readLine()
    }
    var sK = StrToIntK(spKart)
    return sK
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