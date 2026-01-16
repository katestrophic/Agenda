plugins {
    alias(libs.plugins.android.application)
}

dependencies {
    val roomVersion = "2.6.1"

    // LIBRARIES
    implementation(libs.appcompat)
    implementation(libs.material)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.4")

    // ROOM
    implementation("androidx.room:room-runtime:$roomVersion")
    annotationProcessor("androidx.room:room-compiler:$roomVersion")

    // JUNIT TEST
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)

    // ESPRESSO TEST
    androidTestImplementation(libs.espresso.core)
}

android {
    namespace = "katestrophic.agenda"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "katestrophic.agenda"
        minSdk = 25
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}
