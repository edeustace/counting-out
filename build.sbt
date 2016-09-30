name := "counting-out"

organization := "com.ee"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "3.8.5" % "test"
)

scalacOptions in Test ++= Seq("-Yrangepos")

mainClass in (Compile, packageBin) := Some("com.ee.countingOut.Main")

mainClass in (Compile, run) := Some("com.ee.countingOut.Main")
