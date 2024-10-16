
plugins {
    alias(libs.plugins.android.application)



    id("androidx.navigation.safeargs")
    // apply plugin: "androidx.navigation.safeargs"

}

android {
    namespace = "com.example.lab_6"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.lab_6"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    //  implementation("androidx.navigation:navigation-fragment:2.8.2")

   // implementation("com.google.android.material:material:1.9.0")
    val nav_version="2.5.0"
    implementation("androidx.navigation:navigation-fragment:$nav_version")
implementation("androidx.navigation:navigation-ui:$nav_version")
}
