name := "transfer-example-app"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs
)

libraryDependencies ++= Seq(
  "org.webjars" 		%% 	"webjars-play" 		% "2.3.0",
  "org.webjars" 		%	"bootstrap" 		% "3.1.1-1",
  "org.webjars" 		% 	"bootswatch-yeti" 	% "3.1.1",
  "org.webjars" 		% 	"html5shiv" 		% "3.7.0",
  "org.webjars" 		% 	"respond" 			% "1.4.2"
)

initialize := {
  val _ = initialize.value
  if (sys.props("java.specification.version") != "1.8")
    sys.error("Java 8 is required for this project.")
}


fork in run := true