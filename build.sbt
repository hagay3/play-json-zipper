organization := "alex1712"

name := "play-json-zipper"

version := "2.0"
publishArtifact := true

bintrayOrganization := Some("alex1712")
bintrayRepository := "maven"
bintrayPackage := "play-json-zipper"

scalaVersion := "2.12.2"


libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json"    % "2.6.2",
  "org.specs2"        %% "specs2-core"  % "3.9.1"  % "test",
  "org.specs2"        %% "specs2-junit" % "3.9.1"  % "test",
  "junit"              % "junit"        % "4.8"    % "test"
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
