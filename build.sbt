name := "sspLadder"

version := "1.0"

lazy val `sspladder` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq( jdbc , cache , ws   , specs2 % Test )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

compileOrder in Compile := CompileOrder.Mixed

transitiveClassifiers := Seq("sources")

libraryDependencies += "io.netty" % "netty" % "3.10.6.Final"

libraryDependencies += "com.typesafe.play" %% "anorm" % "2.5.2"

libraryDependencies += "com.typesafe.play" % "play_2.11" % "2.4.8"

libraryDependencies += "org.bouncycastle" % "bcprov-jdk16" % "1.46"

libraryDependencies += "com.aliyun.oss" % "aliyun-sdk-oss" % "2.3.0"

//scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8", "-Yno-adapted-args")
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

//retrieveManaged := true

libraryDependencies ++= {
  val akkaV = "2.3.15"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%   "spray-routing" % sprayV,
    "io.spray"            %%   "spray-caching" % sprayV,
    "io.spray"            %%   "spray-can" % sprayV,
    "io.spray"            %%   "spray-client" % sprayV,
    "io.spray"            %%   "spray-http" % sprayV,
    "io.spray"            %%   "spray-httpx" % sprayV,
    "io.spray"            %%   "spray-io" % sprayV,
    //"io.spray"            %%   "spray-testkit" % sprayV,
    "io.spray"            %%   "spray-util" % sprayV,
    "io.spray"            %%   "spray-json" % "1.3.2-j",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-slf4j"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV
  )
}

libraryDependencies += "org.apache.httpcomponents" % "httpcore" % "4.3.2"

libraryDependencies += "com.rabbitmq" % "amqp-client" % "3.6.0"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.2.3"

libraryDependencies += "commons-io" % "commons-io" % "2.4"