name := "fory-scala-test"

scalaVersion := "2.13.16"
crossScalaVersions := Seq("2.12.20", "2.13.16", "3.3.6")

val foryVersion = "0.11.1"

//resolvers ++= Resolver.sonatypeOssRepos("snapshots")

libraryDependencies ++= Seq(
  "org.apache.fory" % "fory-core" % foryVersion,
  "org.scalatest" %% "scalatest" % "3.2.19",
  "org.slf4j" % "slf4j-simple" % "2.0.17" % Test
)

Test / unmanagedSourceDirectories ++= {
  if (scalaBinaryVersion.value.startsWith("2.12")) {
    Seq(
      (LocalRootProject / baseDirectory).value / "src" / "test" / "scala-2.12"
    )
  } else {
    Seq(
      (LocalRootProject / baseDirectory).value / "src" / "test" / "scala-2.13+"
    )
  }
}
