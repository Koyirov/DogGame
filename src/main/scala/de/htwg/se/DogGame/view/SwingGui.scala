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
import scala.collection.mutable.ArrayBuffer
import main.scala.de.htwg.se.DogGame.model.Spieler
import main.scala.de.htwg.se.DogGame.model.Spielfigur
import _root_.main.scala.de.htwg.se.DogGame.model.Lauffeld

object SwingGui extends SimpleSwingApplication {
  def top = new MainFrame {
    title = "DogGame"
    contents = ui

  }
 //val lf_buttons = new ArrayBuffer[Button]()
  var lf_buttons = collection.mutable.Map[Int, Button]()
  var sp_st_zi_fl = collection.mutable.Map[String, (ArrayBuffer[Button], ArrayBuffer[Button])]()
  
  val s = new Dimension(25, 25)

  var button96 = new Button()  {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button95 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button94 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button93 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button92 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button91 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button90 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button89 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button88 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button87 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button86 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button85 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button84 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button83 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button82 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button81 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button80 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button79 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button78 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button77 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button76 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button75 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button74 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button73 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button72 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button71 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button70 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button69 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button68 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button67 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button66 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button65 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button64 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button63 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button62 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button61 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button60 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button59 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button58 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button57 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button56 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button55 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button54 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button53 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button52 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button51 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button50 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button49 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button48 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button47 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button46 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button45 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button44 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button43 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button42 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button41 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button40 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button39 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button38 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button37 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button36 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button35 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button34 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button33 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button32 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button31 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button30 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button29 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button28 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button27 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button26 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button25 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button24 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button23 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button22 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button21 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button20 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button19 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button18 = new Button("*") {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button17 = new Button("*") {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button16 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button15 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button14 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button13 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button12 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button11 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button10 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button9 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button8 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button7 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button6 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button5 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  var button4 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button3 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button2 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }
  var button1 = new Button() {
    preferredSize = s
    border = Swing.EmptyBorder(0, 0, 0, 0)
  }

  //button5.setBorder(null);

  button1.text_=("*")
  button2.text_=("*")
  button3.text_=("*")
  button4.text_=("*")
  button5.text_=("*")
  button6.text_=("*")
  button7.text_=("*")
  button8.text_=("*")
  button9.text_=("*")
  
  button10.text_=("*")
  button11.text_=("*")
  button12.text_=("*")
  button13.text_=("*")
  button14.text_=("*")
  button15.text_=("*")
  button16.text_=("*")
  button17.text_=("*")
  button18.text_=("*")
  button19.text_=("*")
                   
  button20.text_=("*")
  button21.text_=("*")
  button22.text_=("*")
  button23.text_=("*")
  button24.text_=("*")
  button25.text_=("*")
  button26.text_=("*")
  button27.text_=("*")
  button28.text_=("*")
  button29.text_=("*")
                   
  button30.text_=("*")
  button31.text_=("*")
  button32.text_=("*")
  button33.text_=("*")
  button34.text_=("*")
  button35.text_=("*")
  button36.text_=("*")
  button37.text_=("*")
  button38.text_=("*")
  button39.text_=("*")
                   
  button40.text_=("*")
  button41.text_=("*")
  button42.text_=("*")
  button43.text_=("*")
  button44.text_=("*")
  button45.text_=("*")
  button46.text_=("*")
  button47.text_=("*")
  button48.text_=("*")
  button49.text_=("*")
                   
  button50.text_=("*")
  button51.text_=("*")
  button52.text_=("*")
  button53.text_=("*")
  button54.text_=("*")
  button55.text_=("*")
  button56.text_=("*")
  button57.text_=("*")
  button58.text_=("*")
  button59.text_=("*")
                   
  button60.text_=("*")
  button61.text_=("*")
  button62.text_=("*")
  button63.text_=("*")
  button64.text_=("*")
  button65.text_=("*")
  button66.text_=("*")
  button67.text_=("*")
  button68.text_=("*")
  button69.text_=("*")
                   
  button70.text_=("*")
  button71.text_=("*")
  button72.text_=("*")
  button73.text_=("*")
  button74.text_=("*")
  button75.text_=("*")
  button76.text_=("*")
  button77.text_=("*")
  button78.text_=("*")
  button79.text_=("*")
                   
  button80.text_=("*")
  button81.text_=("*")
  button82.text_=("*")
  button83.text_=("*")
  button84.text_=("*")
  button85.text_=("*")
  button86.text_=("*")
  button87.text_=("*")
  button88.text_=("*")
  button89.text_=("*")
                   
  button90.text_=("*")
  button91.text_=("*")
  button92.text_=("*")
  button93.text_=("*")
  button94.text_=("*")
  button95.text_=("*")
  button96.text_=("*")
  
  listenTo(button1)
  listenTo(button2)
  listenTo(button3)
  listenTo(button4)
  listenTo(button5)
  listenTo(button6)
  listenTo(button7)
  listenTo(button8)
  listenTo(button9)
  
  listenTo(button10)
  listenTo(button11)
  listenTo(button12)
  listenTo(button13)
  listenTo(button14)
  listenTo(button15)
  listenTo(button16)
  listenTo(button17)
  listenTo(button18)
  listenTo(button19)
  
  listenTo(button21)
  listenTo(button22)
  listenTo(button23)
  listenTo(button24)
  listenTo(button25)
  listenTo(button26)
  listenTo(button27)
  listenTo(button28)
  listenTo(button29)
  
  listenTo(button31)
  listenTo(button32)
  listenTo(button33)
  listenTo(button34)
  listenTo(button35)
  listenTo(button36)
  listenTo(button37)
  listenTo(button38)
  listenTo(button39)
  
  listenTo(button41)
  listenTo(button42)
  listenTo(button43)
  listenTo(button44)
  listenTo(button45)
  listenTo(button46)
  listenTo(button47)
  listenTo(button48)
  listenTo(button49)
  
  listenTo(button51)
  listenTo(button52)
  listenTo(button53)
  listenTo(button54)
  listenTo(button55)
  listenTo(button56)
  listenTo(button57)
  listenTo(button58)
  listenTo(button59)
  
  listenTo(button61)
  listenTo(button62)
  listenTo(button63)
  listenTo(button64)
  listenTo(button65)
  listenTo(button66)
  listenTo(button67)
  listenTo(button68)
  listenTo(button69)
  
  listenTo(button71)
  listenTo(button72)
  listenTo(button73)
  listenTo(button74)
  listenTo(button75)
  listenTo(button76)
  listenTo(button77)
  listenTo(button78)
  listenTo(button79)
  
  listenTo(button81)
  listenTo(button82)
  listenTo(button83)
  listenTo(button84)
  listenTo(button85)
  listenTo(button86)
  listenTo(button87)
  listenTo(button88)
  listenTo(button89)
  
  listenTo(button91)
  listenTo(button92)
  listenTo(button93)
  listenTo(button94)
  listenTo(button95)
  listenTo(button96)
  
  var panel20 = new FlowPanel(FlowPanel.Alignment.Left)(button93, button94, button95, button96) //4
  var s_ziel  = new ArrayBuffer[Button]()
  s_ziel += button93 += button94 += button95 += button96
  var panel19 = new GridPanel(4, 1) //4
  panel19.contents += button89 += button90 += button91 += button92
  var g_ziel  = new ArrayBuffer[Button]()
  g_ziel += button89 += button90 += button91 += button92
  var panel18 = new FlowPanel(FlowPanel.Alignment.Right)(button85, button86, button87, button88) //4
  var r_ziel  = new ArrayBuffer[Button]()
  r_ziel += button85 += button86 += button87 += button88
  var panel17 = new GridPanel(4, 1) //4
  panel17.contents += button81 += button82 += button83 += button84
  var b_ziel  = new ArrayBuffer[Button]()
  b_ziel += button81 += button82 += button83 += button84
  
  var panelXX = new FlowPanel() //1
  var panelYY = new FlowPanel() //1
  var panelZZ = new FlowPanel() //1
  
  var panelR2 = new GridPanel(4, 1)
  panelR2.contents += panelXX += panelYY += panelZZ
  panelR2.contents += panel19
  
  var panelL2 = new FlowPanel(panel17)
  
  var panel16 = new GridPanel(15, 1) //15
  panel16.contents += button62 += button63 += button64 += button65
  panel16.contents += button66 += button67 += button68 += button69
  panel16.contents += button70 += button71 += button72 += button73
  panel16.contents += button74 += button75 += button76
  panel16.border_=(Swing.EmptyBorder(1,1,1,1))
  lf_buttons += (49 -> button62) += (50 -> button63) += (51 -> button64) += (52 -> button65)
  lf_buttons += (53 -> button66) += (54 -> button67) += (55 -> button68) += (56 -> button69)
  lf_buttons += (57 -> button70) += (58 -> button71) += (59 -> button72) += (60 -> button73)
  lf_buttons += (61 -> button74) += (62 -> button75) += (63 -> button76) 
  var panel15 = new GridPanel(1, 15)
  panel15.contents += button47 += button48 += button49 += button50
  panel15.contents += button51 += button52 += button53 += button54
  panel15.contents += button55 += button56 += button57 += button58
  panel15.contents += button59 += button60 += button61 //15
  panel15.border_=(Swing.EmptyBorder(2,2,2,2))
  lf_buttons += (33 -> button47) += (34 -> button48) += (35 -> button49) += (36 -> button50)
  lf_buttons += (37 -> button51) += (38 -> button52) += (39 -> button53) += (40 -> button54)
  lf_buttons += (41 -> button55) += (42 -> button56) += (43 -> button57) += (44 -> button58)
  lf_buttons += (45 -> button59) += (46 -> button60) += (47 -> button61) 


  var panel14 = new GridPanel(15, 1) //15
  panel14.contents += button32 += button33 += button34 += button35
  panel14.contents += button36 += button37 += button38 += button39
  panel14.contents += button40 += button41 += button42 += button43
  panel14.contents += button44 += button45 += button46
  lf_buttons += (17 -> button32) += (18 -> button33) += (19 -> button34) += (20 -> button35)
  lf_buttons += (21 -> button36) += (22 -> button37) += (23 -> button38) += (24 -> button39)
  lf_buttons += (25 -> button40) += (26 -> button41) += (27 -> button42) += (28 -> button43)
  lf_buttons += (29 -> button44) += (30 -> button45) += (31 -> button46) 

  var panel13 = new GridPanel(1, 15)
  panel13.contents += button17 += button18 += button19 += button20
  panel13.contents += button21 += button22 += button23 += button24
  panel13.contents += button25 += button26 += button27 += button28
  panel13.contents += button29 += button30 += button31 //15
  panel13.border_=(Swing.EmptyBorder(3,3,3,3))
  lf_buttons += (1 -> button17) += (2 -> button18) += (3 -> button19) += (4 -> button20)
  lf_buttons += (5 -> button21) += (6 -> button22) += (7 -> button23) += (8 -> button24)
  lf_buttons += (9 -> button25) += (10 -> button26) += (11 -> button27) += (12 -> button28)
  lf_buttons += (13 -> button29) += (14 -> button30) += (15 -> button31) 

  var panel12 = new FlowPanel(button80) //1
  var panel11 = new FlowPanel(button79) //1
  var panel10 = new FlowPanel(button78) //1
  var panel9 = new FlowPanel(button77) //1
  lf_buttons += (0 -> button77)
  lf_buttons += (16 -> button78)
  lf_buttons += (32 -> button79)
  lf_buttons += (48 -> button80)

  var panel8 = new GridPanel(4, 1) //4
  panel8.contents += button1 += button2 += button3 += button4
  var b_start  = new ArrayBuffer[Button]()
  b_start += button1 += button2 += button3 += button4

  var panel7 = new FlowPanel(FlowPanel.Alignment.Left)(button13, button14, button15, button16) //4
  //panel7.contents += button13 += button14 += button15 += button16
  var s_start  = new ArrayBuffer[Button]()
  s_start += button13 += button14 += button15 += button16
  
  var panel6 = new GridPanel(4, 1) //4
  panel6.contents += button9 += button10 += button11 += button12
  var g_start  = new ArrayBuffer[Button]()
  g_start += button9 += button10 += button11 += button12

  var panelX = new FlowPanel() //1
  var panelY = new FlowPanel() //1
  var panelZ = new FlowPanel() //1
  var panelV = new FlowPanel() //1
  
  var panelR1 = new GridPanel(5, 1)
  panelR1.contents += panelX += panelY += panelZ += panelV
  panelR1.contents += panel6
  
  var panelL1 = new FlowPanel(panel8)

  var panel5 = new FlowPanel(FlowPanel.Alignment.Right)(button5, button6, button7, button8) //4
  //panel5.contents += button5 += button6 += button7 += button8
  var r_start  = new ArrayBuffer[Button]()
  r_start += button5 += button6 += button7 += button8
  
  sp_st_zi_fl += ("B" -> (b_start, b_ziel)) += ("R" -> (r_start, r_ziel))
  sp_st_zi_fl += ("G" -> (g_start, g_ziel)) += ("S" -> (s_start, s_ziel))

  var panel4 = new FlowPanel() //0
  var panel3 = new FlowPanel() //0
  var panel2 = new FlowPanel() //0
  var panel1 = new FlowPanel() //0

  //Panel Oben2
  var panelN2 = new FlowPanel(panel9, panel13, panel10)

  //Panel Unten2
  var panelS2 = new FlowPanel(panel12, panel15, panel11)

  //Panel 2xMitte
  var panelMM = new BorderPanel()
  panelMM.layout(panelL2) = West
  //panelMM.layout(panelMM) = Center
  panelMM.layout(panel18) = North
  panelMM.layout(panelR2) = East
  panelMM.layout(panel20) = South

  //Panel Mitte
  var panelM = new BorderPanel()
  panelM.layout(panel16) = West
  panelM.layout(panelMM) = Center
  panelM.layout(panelN2) = North
  panelM.layout(panel14) = East
  panelM.layout(panelS2) = South

  //Panel Oben
  var panelN1 = new GridPanel(1, 1)
  panelN1.contents += panel5

  //Panel Unten
  var panelS1 = new GridPanel(1, 1)
  panelS1.contents += panel7

  var panelGround = new BorderPanel()
  panelGround.layout(panelL1) = West
  panelGround.layout(panelM) = Center
  panelGround.layout(panelN1) = North
  panelGround.layout(panelR1) = East
  panelGround.layout(panelS1) = South

  lazy val ui = new FlowPanel(panelGround)
  
  reactions += {
    case e: ButtonClicked => {
      println(e.hashCode())
      println(e.source.background)
    }
  }
  
  def update_Spiel_Brett(lF: Lauffeld, p: ArrayBuffer[Spieler]){
    var l = lF.getFeld().map(_.swap)
    for(pos <- 0 to 63){
      if(l.contains(pos)){
        var fig_name = l.get(pos).get.getFigur()
        var button = lf_buttons.get(pos).get
        button.name = fig_name
        if(fig_name.startsWith("B")){
          button.background = java.awt.Color.blue
        }else if(fig_name.startsWith("R")){
          button.background = java.awt.Color.red
        }else if(fig_name.startsWith("G")){
          button.background = java.awt.Color.green
        }else{
          button.background = java.awt.Color.black
        }
      }
    }
    
    for(sp <- p){
      var sp_name = sp.getName()
      var sp_st_feld = sp.getStart().map(_.swap)
      var sp_zi_feld = sp.getZiel().map(_.swap)
      var st_feld = sp_st_zi_fl.get(sp_name).get._1
      var zi_feld = sp_st_zi_fl.get(sp_name).get._2
      if(sp_name == "B"){
        for(pos <- 1 to 4){
          if(sp_st_feld.contains(pos)){
            var button = st_feld(pos - 1)
            button.name = (pos - 1).toString()
            button.background = java.awt.Color.blue
          }  
        }
      }else if(sp_name == "R"){
        for(pos <- 1 to 4){
          if(sp_st_feld.contains(pos)){
            var button = st_feld(pos - 1)
            button.name = (pos - 1).toString()
            button.background = java.awt.Color.red
          }  
        }
      }else if(sp_name == "G"){
        for(pos <- 1 to 4){
          if(sp_st_feld.contains(pos)){
            var button = st_feld(pos - 1)
            button.name = (pos - 1).toString()
            button.background = java.awt.Color.green
          }  
        }
      }else{
        for(pos <- 1 to 4){
          if(sp_st_feld.contains(pos)){
            var button = st_feld(pos - 1)
            button.name = (pos - 1).toString()
            button.background = java.awt.Color.black
          }  
        }
      }
    }
  }
}





