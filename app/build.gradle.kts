plugins {
    alias(libs.plugins.gradle.application.plugin)
    alias(libs.plugins.gradle.kotlin.plugin)
    alias(libs.plugins.gradle.java.plugin)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "dev.jason.Main"
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}

tasks.register<JavaExec>("cricket") {
    mainClass = "dev.jason.cricket.CricketMain"
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlin.standard.library)
}