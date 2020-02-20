name := """iotapp"""
organization := "org.imbruced"

version := "0.1.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test


libraryDependencies += "org.apache.kafka" %% "kafka" % "2.4.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.0-preview2"
libraryDependencies += "postgresql" % "postgresql" % "9.1-901-1.jdbc4"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "org.imbruced.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "org.imbruced.binders._"
