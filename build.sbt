ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

libraryDependencies += "dev.zio" %% "zio-http" % "3.2.0"

lazy val root = (project in file("."))
  .settings(
    name := "friendlyink",
    idePackagePrefix := Some("dev.vanderloureiro")
  )