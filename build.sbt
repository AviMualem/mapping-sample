name := "mapping"

version := "0.1"

scalaVersion := "2.12.10"

// https://mvnrepository.com/artifact/io.scalaland/chimney
libraryDependencies += "io.scalaland" %% "chimney" % "0.4.2"

libraryDependencies += "joda-time" % "joda-time" % "2.10.5"

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Xmax-classfile-name",
  "240",
  "-Ywarn-unused-import",
  "-Ywarn-unused",
  "-Ywarn-macros:after"
)