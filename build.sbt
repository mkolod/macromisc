organization := "io.malcolmgreaves"

name := "macromisc"

version := "0.0.1"

// use sbt-dev-settings to configure

import com.nitro.build._

import PublishHelpers._

// scala & java

CompileScalaJava.librarySettings()

javaOptions := JvmRuntime.settings()

// dependencies and their resolvers

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  
  // Testing
  "org.scalatest" %% "scalatest" % "2.2.4" % Test
)

// publishing settings

Publish.settings(
  repo = Repository.github("Nitro", name.toString),
  developers =
    Seq(
      Dev("mgreaves", "Malcolm Greaves")
    ),
  art = ArtifactInfo.sonatype,
  lic = License.apache20
)

// unit test configuration

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

testOptions in Test += Tests.Argument("-oF")

fork in Test := false

parallelExecution in Test := true

