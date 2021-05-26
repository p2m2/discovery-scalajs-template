scalaVersion := "2.13.4"
name := "discovery-scalajs-template-example"
version := "0.0.1"
organization := "com.github.p2m2"

scalaJSUseMainModuleInitializer := true

mainClass in Compile := Some("inrae.application.Main")

lazy val scalatagVersion = "0.9.4"
lazy val jqueryFacadeVersion = "2.0"
lazy val discoveryVersion ="v0.2.0"

libraryDependencies ++= Seq(
  "com.lihaoyi" %%% "scalatags" % scalatagVersion,
  "org.querki" %%% "jquery-facade" % jqueryFacadeVersion,
  "com.github.p2m2" %%% "discovery" % discoveryVersion
)

scalaJSLinkerConfig in (Compile, fastOptJS ) ~= {
  _.withOptimizer(false)
    .withPrettyPrint(true)
    .withSourceMap(true)
}

scalaJSLinkerConfig in (Compile, fullOptJS) ~= {
  _.withSourceMap(false)
    .withModuleKind(ModuleKind.CommonJSModule)
}

enablePlugins(ScalaJSBundlerPlugin)
webpackBundlingMode := BundlingMode.LibraryAndApplication()

npmDependencies in Compile ++= Seq("jquery" -> "3.5.1")

Global / onChangedBuildSource := ReloadOnSourceChanges

