import xerial.sbt.Sonatype._
resolvers += "Typesafe Releases" at "https://repo.typesafe.com/typesafe/releases/"
organization := "io.github.hagay3"

name := "play-json-zipper"

version := "2.0.1"


val scala12Version = "2.12.2"
val scala13Version = "2.13.10"

val currentScalaVersion = scala13Version

ThisBuild / scalaVersion := currentScalaVersion

val supportedScalaVersion = Seq(scala12Version, scala13Version)
ThisBuild / crossScalaVersions := supportedScalaVersion

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json"    % "2.9.2",
  "org.specs2"        %% "specs2-core"  % "4.6.0"  % "test",
  "org.specs2"        %% "specs2-junit" % "4.6.0"  % "test",
  "junit"              % "junit"        % "4.8"    % "test"
)

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

sonatypeCredentialHost := Sonatype.sonatype01
sonatypeProjectHosting := Some(GitHubHosting("hagay3", "play-json-zipper", "hagay3@gmail.com"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/hagay3/play-json-zipper"),
    "scm:git@github.com:hagay3/play-json-zipper.git"
  )

inThisBuild(List(
  githubWorkflowBuildMatrixFailFast := Some(false),
  githubWorkflowScalaVersions := supportedScalaVersion,
  githubWorkflowPublishTargetBranches := Seq(RefPredicate.StartsWith(Ref.Tag("v"))),
  githubWorkflowTargetTags ++= Seq("v*"),
  githubWorkflowBuild := Seq(WorkflowStep.Sbt(List("test"))),
  githubWorkflowPublish := Seq(
    WorkflowStep.Sbt(
      List("ci-release"),
      env = Map(
        "PGP_PASSPHRASE" -> "${{ secrets.PGP_PASSPHRASE }}",
        "PGP_SECRET" -> "${{ secrets.PGP_SECRET }}",
        "SONATYPE_PASSWORD" -> "${{ secrets.SONATYPE_PASSWORD }}",
        "SONATYPE_USERNAME" -> "${{ secrets.SONATYPE_USERNAME }}")))))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/hagay3/play-json-zipper"),
    "scm:git@github.com:hagay3/play-json-zipper.git"
  ))