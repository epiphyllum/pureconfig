name := "pureconfig-enumeratum"

organization := "com.github.melrief"

homepage := Some(url("https://github.com/melrief/pureconfig"))

licenses := Seq("Mozilla Public License, version 2.0" -> url("https://www.mozilla.org/MPL/2.0/"))

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "com.beachape" %% "enumeratum" % "1.5.6",
  Dependencies.scalaMacrosParadise,
  Dependencies.scalaTest
)

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomExtra :=
  <scm>
    <url>git@github.com:melrief/pureconfig.git</url>
    <connection>scm:git:git@github.com:melrief/pureconfig.git</connection>
  </scm>
  <developers>
    <developer>
      <id>aeons</id>
      <name>Bjørn Madsen</name>
      <url>https://github.com/aeons</url>
    </developer>
  </developers>

osgiSettings

OsgiKeys.exportPackage := Seq("pureconfig.module.enumeratum.*")

OsgiKeys.privatePackage := Seq()

OsgiKeys.importPackage := Seq(s"""scala.*;version="[${scalaBinaryVersion.value}.0,${scalaBinaryVersion.value}.50)"""", "*")
