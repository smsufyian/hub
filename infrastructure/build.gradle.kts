plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.jvm)
    application
}

version =  "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    implementation("com.pulumi:pulumi:0.9.8")
    implementation("com.pulumi:gcp:7.3.0")
    implementation("com.google.cloud:google-cloud-storage:2.22.5")

}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass.set("MainKt")
}
