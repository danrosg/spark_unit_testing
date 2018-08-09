name := "spark_unit_testing"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.2.0" % "provided" ,
  "org.apache.spark" %% "spark-sql" % "2.2.0" % "provided",
  "org.apache.spark" %% "spark-hive" % "2.2.0" % "provided",
  "com.github.scopt" %% "scopt" % "3.3.0",
  "org.scalatest" % "scalatest_2.11" % "3.0.5" % "test"
)

