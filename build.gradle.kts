
plugins {
    alias(libs.plugins.android.application) apply false
}

buildscript {
    repositories {
        google()
    }
    dependencies {
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.0")
    }


}

