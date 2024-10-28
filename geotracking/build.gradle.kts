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
        consumerProguardFiles ( "consumer-rules.pro")

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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }


    buildFeatures {
        buildConfig = true
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

    implementation(libs.androidx.preference)


}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.innov"
            artifactId = "geotracking"
            version = "1.0.5"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
/*afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.innov"
                artifactId = "geotracking"
                version = "1.0.5"

            }
        }
    }

}*/



