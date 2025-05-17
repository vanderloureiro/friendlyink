ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.5"

val doobieVersion = "1.0.0-RC8"
val configVersion = "4.0.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.1.18",
  "dev.zio" %% "zio-http" % "3.2.0",
  "dev.zio" %% "zio-json" % "0.7.43",
  "dev.zio"      %% "zio-streams"     % "2.1.18",
  "dev.zio"      %% "zio-interop-cats" % "23.1.0.5",

  // config
  "dev.zio" %% "zio-config" % configVersion,
  "dev.zio" %% "zio-config-typesafe" % configVersion,
  "dev.zio" %% "zio-config-magnolia" % configVersion,

  "org.tpolecat" %% "doobie-core"     % doobieVersion,
  "org.tpolecat" %% "doobie-postgres"  % doobieVersion,
  "org.tpolecat" %% "doobie-hikari"   % doobieVersion,
  // tranzactIO
  // TranzactIO
  "io.github.gaelrenoux" %% "tranzactio-doobie" % "5.3.0",

  // PostgreSQL driver
  "org.postgresql" % "postgresql" % "42.7.5"
)

lazy val root = (project in file("."))
  .settings(
    name := "friendlyink",
    idePackagePrefix := Some("dev.vanderloureiro")
  )