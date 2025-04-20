ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.17",
  "dev.zio" %% "zio-http" % "3.2.0",
  "dev.zio" %% "zio-json" % "0.7.42"
)

lazy val root = (project in file("."))
  .settings(
    name := "friendlyink",
    idePackagePrefix := Some("dev.vanderloureiro")
  )