name := "fury-scala-test"

scalaVersion := "2.13.12"
crossScalaVersions := Seq("2.12.18", "2.13.12", "3.3.1")

val furyVersion = "0.2.1"

//resolvers ++= Resolver.sonatypeOssRepos("snapshots")

libraryDependencies ++= Seq(
  "org.furyio" % "fury-core" % furyVersion,
  "org.scalatest" %% "scalatest" % "3.2.17",
  "org.slf4j" % "slf4j-simple" % "2.0.9" % Test
)
