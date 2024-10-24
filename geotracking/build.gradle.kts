plugins {
    id("com.android.library")
    id("maven-publish")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    id("realm-android")

}

//group = "com.gitlab.KhurseedAnsari"

android {
    namespace = "com.innov.geotracking"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        aarMetadata {
            minCompileSdk = 24
        }
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

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        buildConfig = true
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }


}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.glide)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //koin
    implementation(libs.koin.core)
    implementation(libs.koin.android)
    implementation(libs.kotlin.bom)
    implementation(libs.koin.test)
    implementation(libs.koin.test.junit4)


    implementation(libs.multidex)
    implementation(libs.branch)

    implementation(libs.picasso)
    implementation(libs.glide)
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)
    implementation(libs.play.services.location)
    implementation(libs.realm)
    implementation(libs.play.services.maps)
    implementation(libs.krealmextensions)
    implementation(libs.androidx.recyclerview)


}
afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.innov"
                artifactId = "geotracking"
                version = "1.0.2"

            }
        }
    }

}



