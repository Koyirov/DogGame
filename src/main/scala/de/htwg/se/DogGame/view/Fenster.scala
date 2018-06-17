package main.scala.de.htwg.se.DogGame.view

import scala.swing._
import scala.swing.event._
import scala.swing.BorderPanel.Position._


class Fenster extends MainFrame with FensterInterface{

  title = "DogGame Anleitung"
  //size_=(new Dimension(1280, 720))

  var textHinweis = new swing.TextArea()
  textHinweis.lineWrap_=(true)
  textHinweis.wordWrap_=(true)
  textHinweis.background_=(java.awt.Color.green)
  textHinweis.text_=("bla")
  var scroll_pane = new ScrollPane() {
    contents = textHinweis
    verticalScrollBarPolicy_=(scala.swing.ScrollPane.BarPolicy.Always)
  }
  scroll_pane.preferredSize_=(new Dimension(1280, 620))
  //scroll_pane.peer.setVerticalScrollBar(javax.swing.JScrollBar)
  var button = new Button() {
    preferredSize = new Dimension(50, 25)
    border = Swing.EmptyBorder(0, 0, 0, 0)
    text = "Zum Spiel"
    background = java.awt.Color.lightGray
  }
  
  var window = new BorderPanel {
    add(scroll_pane, BorderPanel.Position.North)
    add(button, BorderPanel.Position.South)
    background = java.awt.Color.green
  }
  
  contents = window
  
  listenTo(button)
  
  reactions += {
    case e: ButtonClicked => {
      if (e.source.text == "Zum Spiel") {
          close()
        }
      }
  }
  
  override def zeig_anleitung(text: String) {
    textHinweis.text_=(text)
  }
  
}