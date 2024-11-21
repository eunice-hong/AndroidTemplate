import java.io.FileInputStream
import java.util.Properties

val propertiesFile = rootProject.file("local.properties")
val properties = Properties()
properties.load(FileInputStream(propertiesFile))

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    kotlin("plugin.serialization") version libs.versions.kotlin
    alias(libs.plugins.kotlin.android.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.eunicehong.template.core.remote"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            buildConfigField("String", "supabase_url", properties["debug_supabase_url"].toString())
            buildConfigField("String", "supabase_key", properties["debug_supabase_key"].toString())
        }

        release {
            buildConfigField("String", "supabase_url", properties["release_supabase_url"].toString())
            buildConfigField("String", "supabase_key", properties["release_supabase_key"].toString())

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(projects.core.model)

    implementation(libs.androidx.core.ktx)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(platform(libs.jan.tennert.supabase.bom))
    implementation(libs.jan.tennert.supabase.postgrest)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.utils)
    implementation(libs.ktor.client.android)
}
