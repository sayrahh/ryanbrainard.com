import com.typesafe.startscript.StartScriptPlugin

organization := "com.ryanbrainard"

name := "ryanbrainard.com"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.2"

seq(webSettings :_*)

classpathTypes ~= (_ + "orbit")

libraryDependencies ++= Seq(
  "org.scalatra" % "scalatra" % "2.1.1",
  "org.scalatra" % "scalatra-scalate" % "2.1.1",
  "org.scalatra" % "scalatra-specs2" % "2.1.1" % "test",
  "org.fusesource.scalamd" % "scalamd" % "1.5" % "runtime",
  "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
  "org.eclipse.jetty" % "jetty-server" % "8.1.7.v20120910" % "container;compile",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.7.v20120910" % "container;compile",
  "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
)

port in container.Configuration := sys.env.get("PORT").map(_.toInt).getOrElse(8080)

seq(StartScriptPlugin.startScriptForClassesSettings: _*)
