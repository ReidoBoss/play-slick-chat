name := """template"""
organization := "com.vauldex"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "3.3.1"

val pekkoVersion = "1.0.3"

libraryDependencies ++= Seq(
    guice,
    "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
    "org.postgresql" % "postgresql" % "42.5.0",
	"org.playframework" %% "play-slick"            % "6.1.0",
    "org.apache.pekko" %% "pekko-actor"                 % "1.0.3",
    "org.apache.pekko" %% "pekko-actor-typed"           % "1.0.3",
    "org.apache.pekko" %% "pekko-stream"                % "1.0.3",
    "org.apache.pekko" %% "pekko-slf4j"                 % "1.0.3",
    "org.apache.pekko" %% "pekko-serialization-jackson" % "1.0.3",
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.vauldex.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.vauldex.binders._"
