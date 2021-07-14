// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        maven(url = "https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${dependency.Libs.Versions.KOTLIN_VERSION}")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${dependency.Libs.Versions.NAVIGATION}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://maven.fabric.io/public") }
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register(name = "type", type = Delete::class) {
    delete(rootProject.buildDir)
}
