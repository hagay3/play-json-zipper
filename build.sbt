organization := "org.stanch"

name := "play-json-zipper"

version := "1.5"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.5.10",
  "org.specs2"        %% "specs2"    % "2.3.12" % "test",
  "junit"              % "junit"     % "4.8"    % "test"
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
