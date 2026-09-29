plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeCompiler)
}

android {
    namespace = "com.ricven.richinsights"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.ricven.richinsights"
        minSdk = 23
        targetSdk = 37
        versionCode = 1
        versionName = "0.1.0"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidxComposeBom))
    androidTestImplementation(platform(libs.androidxComposeBom))

    implementation(libs.androidxActivityCompose)
    implementation(libs.androidxComposeMaterial3)
    implementation(libs.androidxComposeUiToolingPreview)

    debugImplementation(libs.androidxComposeUiTooling)
}
