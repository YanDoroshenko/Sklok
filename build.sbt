name := "sKlok"

version := "0.0.1"

scalaVersion := "2.11.11"

enablePlugins(AndroidApp)

platformTarget := "android-25"

useProguard in Android := true

libraryDependencies ++=
  "org.scaloid" %% "scaloid" % "4.2" ::
    "net.ruippeixotog" %% "scala-scraper" % "2.0.0-RC2" ::
    Nil