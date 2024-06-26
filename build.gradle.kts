val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
  application
  kotlin("jvm") version "1.9.23"
  kotlin("plugin.serialization").version("1.9.23")
  id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.jvmlab"
version = "0.0.1"
application {
  mainClass.set("com.jvmlab.mikro.ApplicationKt")
}

repositories {
  mavenCentral()
  maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") }
}

dependencies {
  implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
  implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
  implementation("ch.qos.logback:logback-classic:$logback_version")

  implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
  implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")

  testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
  testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
  testImplementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
  testImplementation(group = "org.junit.jupiter", name = "junit-jupiter", version = "5.+")
}