name          := "DogGame"
organization  := "de.htwg.se"
version       := "0.2.0"
scalaVersion  := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

libraryDependencies += "junit" % "junit" % "4.8" % "test"

//libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11+"

libraryDependencies += "org.scala-lang" % "scala-library" % scalaVersion.value

libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.10.0"

libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.10.0"

//*******************************************************************************//
//Libraries that we will use in later lectures compatible with this scala version
// uncomment to use!!

libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.12" % "2.0.1"

//libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

//libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

//libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.12" % "1.0.6"

//libraryDependencies += "com.typesafe.play" %% "play-json" % "2.6.6"