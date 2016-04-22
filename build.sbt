name          := "akka-http-example"

organization  := "com.example"

version       := "0.1"

scalaVersion  := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.4.4"
  val specsV = "2.3.11"
  Seq(
    "com.typesafe.akka"       %% "akka-http-core"             % akkaV,
    "com.typesafe.akka"       %% "akka-http-experimental"     % akkaV,
    "com.typesafe.akka"       %% "akka-http-xml-experimental" % akkaV,
    "org.scala-lang.modules"  %%  "scala-xml"                 % "1.0.5",
    "com.typesafe.akka"       %%  "akka-testkit"              % akkaV   % "test",
    "com.typesafe.akka"       %%  "akka-http-testkit"         % akkaV   % "test",
    "org.scalatest"           %% "scalatest"                  % "2.2.4"  % "test"
  )
}

Revolver.settings
