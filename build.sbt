name := "sspLadder"

version := "1.0"

lazy val `sspladder` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq( jdbc , cache , ws , specs2 % Test )

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

compileOrder in Compile := CompileOrder.Mixed

transitiveClassifiers := Seq("sources")

unmanagedSourceDirectories in Compile += baseDirectory.value / "akkaInAction" / "src"
unmanagedSourceDirectories in Test += baseDirectory.value / "akkaInAction" / "test"
unmanagedResourceDirectories in Assets += baseDirectory.value / "akkaInAction" / "public"

unmanagedSourceDirectories in Compile += baseDirectory.value / "example" / "src"
unmanagedSourceDirectories in Test += baseDirectory.value / "example" / "test"
unmanagedResourceDirectories in Assets += baseDirectory.value / "example" / "public"

//unmanagedSourceDirectories in Compile += baseDirectory.value / "jedisInScala" / "src"
//unmanagedSourceDirectories in Test += baseDirectory.value / "jedisInScala" / "test"
//unmanagedResourceDirectories in Assets += baseDirectory.value / "jedisInScala" / "public"

libraryDependencies += "io.netty" % "netty" % "3.10.6.Final"

libraryDependencies += "com.typesafe.play" %% "anorm" % "2.5.2"

libraryDependencies += "com.typesafe.play" % "play_2.11" % "2.4.8"

libraryDependencies += "org.bouncycastle" % "bcprov-jdk16" % "1.46"

libraryDependencies += "com.aliyun.oss" % "aliyun-sdk-oss" % "2.3.0"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV = "2.4.12"
  val sprayV = "1.3.3"
  Seq(
    "io.spray"            %%   "spray-routing" % sprayV,
    "io.spray"            %%   "spray-caching" % sprayV,
    "io.spray"            %%   "spray-can" % sprayV,
    "io.spray"            %%   "spray-client" % sprayV,
    "io.spray"            %%   "spray-http" % sprayV,
    "io.spray"            %%   "spray-httpx" % sprayV,
    "io.spray"            %%   "spray-io" % sprayV,
    "io.spray"            %%   "spray-util" % sprayV,
    "io.spray"            %%   "spray-json" % "1.3.2-j",
    "com.typesafe.akka"   %%   "akka-actor" % akkaV,
    "com.typesafe.akka"   %%   "akka-agent" % akkaV,
    "com.typesafe.akka"   %%   "akka-camel" % akkaV,
    "com.typesafe.akka"   %%   "akka-cluster" % akkaV,
    "com.typesafe.akka"   %%   "akka-cluster-metrics" % akkaV,
    "com.typesafe.akka"   %%   "akka-cluster-sharding" % akkaV,
    "com.typesafe.akka"   %%   "akka-cluster-tools" % akkaV,
    "com.typesafe.akka"   %%   "akka-contrib" % akkaV,
    "com.typesafe.akka"   %%   "akka-multi-node-testkit" % akkaV,
    "com.typesafe.akka"   %%   "akka-osgi" % akkaV,
    "com.typesafe.akka"   %%   "akka-persistence" % akkaV,
    "com.typesafe.akka"   %%   "akka-persistence-tck" % akkaV,
    "com.typesafe.akka"   %%   "akka-remote" % akkaV,
    "com.typesafe.akka"   %%   "akka-slf4j" % akkaV,
    "com.typesafe.akka"   %%   "akka-stream" % akkaV,
    "com.typesafe.akka"   %%   "akka-stream-testkit" % akkaV,
    "com.typesafe.akka"   %%   "akka-testkit" % akkaV,
    "com.typesafe.akka"   %%   "akka-distributed-data-experimental" % akkaV,
    "com.typesafe.akka"   %%   "akka-typed-experimental" % akkaV,
    "com.typesafe.akka"   %%  "akka-persistence-query-experimental" % akkaV
  )
}
libraryDependencies += "io.netty" % "netty" % "3.10.6.Final"

libraryDependencies += "com.typesafe.play" %% "anorm" % "2.5.2"

libraryDependencies += "com.typesafe.play" % "play_2.11" % "2.4.8"

libraryDependencies += "com.typesafe.play.modules" %% "play-modules-redis" % "2.4.1"

libraryDependencies += "org.bouncycastle" % "bcprov-jdk16" % "1.46"

libraryDependencies += "com.aliyun.oss" % "aliyun-sdk-oss" % "2.3.0"

libraryDependencies += "org.apache.httpcomponents" % "httpcore" % "4.3.2"

libraryDependencies += "com.rabbitmq" % "amqp-client" % "3.6.0"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.35"

libraryDependencies += "org.quartz-scheduler" % "quartz" % "2.2.3"

libraryDependencies += "org.apache.commons" % "commons-compress" % "1.12"

libraryDependencies += "commons-io" % "commons-io" % "2.5"

libraryDependencies += "org.apache.commons" % "commons-lang3" % "3.1"

libraryDependencies += "net.sf.sevenzipjbinding" % "sevenzipjbinding-all-windows" % "9.20-2.00beta"

libraryDependencies += "com.rabbitmq" % "amqp-client" % "4.0.0"

libraryDependencies += "org.specs2" % "specs2-core_2.11" % "3.6"

libraryDependencies += "org.scala-lang.modules" % "scala-async_2.11" % "0.9.6"

libraryDependencies += "redis.clients" % "jedis" % "2.9.0"

libraryDependencies += "com.google.inject" % "guice" % "4.0"
