import net.minecrell.pluginyml.bukkit.BukkitPluginDescription

plugins {
    kotlin("jvm") version "1.8.20"
    id("io.papermc.paperweight.userdev") version "1.5.4"
    id("xyz.jpenilla.run-paper") version "2.0.1" // Adds runServer and runMojangMappedServer tasks for testing
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3" // Generates plugin.yml
}

group = "builders.volans"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    maven("https://papermc.io/repo/repository/maven-public/")
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.19.4-R0.1-SNAPSHOT")
    testImplementation(kotlin("test"))
    implementation("xyz.jpenilla", "reflection-remapper", "0.1.0-SNAPSHOT")
}

kotlin {
    jvmToolchain(17)
}

tasks {
    assemble {
        dependsOn("reobfJar")
    }
    test {
        useJUnitPlatform()
    }
}

bukkit {
    load = BukkitPluginDescription.PluginLoadOrder.STARTUP
    main = "builders.volans.playground.Playground"
    apiVersion = "1.19"
    authors = listOf("TheMeinerLP")
}