ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

val doobieVersion = "1.0.0-RC9"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.17",
  "dev.zio" %% "zio-http" % "3.2.0",
  "dev.zio" %% "zio-json" % "0.7.42",
  "org.tpolecat" %% "doobie-core"     % doobieVersion,
  "org.tpolecat" %% "doobie-postgres" % doobieVersion,
  "org.tpolecat" %% "doobie-hikari"   % doobieVersion,
  "dev.zio"      %% "zio-interop-cats" % "23.1.0.5"
)

lazy val root = (project in file("."))
  .settings(
    name := "friendlyink",
    idePackagePrefix := Some("dev.vanderloureiro")
  )