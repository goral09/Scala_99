name := "Scala 99 problems"

version := "0.1"

scalaVersion := "2.11.1"

libraryDependencies ++= Seq (
	"org.scalatest" %% "scalatest" % "2.1.6" % "test",
	"org.scalautils" %% "scalautils" % "2.1.6"
)

javaOptions += "-Xmx2G"
