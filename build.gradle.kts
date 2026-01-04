// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    kotlin("jvm") version "1.9.22" apply false
    kotlin("android") version "1.9.22" apply false
    kotlin("plugin.serialization") version "1.9.22" apply false
    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.compose") version "1.5.11" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

// Version management
object Versions {
    const val KOTLIN = "1.9.22"
    const val ANDROID_SDK_COMPILE = 34
    const val ANDROID_SDK_MIN = 24
    const val ANDROID_SDK_TARGET = 34
    
    // AndroidX
    const val ANDROIDX_CORE = "1.12.0"
    const val ANDROIDX_APPCOMPAT = "1.6.1"
    const val ANDROIDX_LIFECYCLE = "2.6.2"
    const val ANDROIDX_ACTIVITY = "1.8.0"
    const val ANDROIDX_COMPOSE = "1.5.4"
    const val ANDROIDX_COMPOSE_MATERIAL3 = "1.1.2"
    const val ANDROIDX_COMPOSE_COMPILER = "1.5.8"
    
    // Testing
    const val JUNIT = "4.13.2"
    const val JUNIT5 = "5.9.3"
    const val MOCKK = "1.13.8"
    const val KOTEST = "5.7.2"
    const val ANDROIDX_TEST = "1.5.2"
    const val ANDROIDX_ESPRESSO = "3.5.1"
    
    // Networking & Serialization
    const val OKHTTP = "4.11.0"
    const val RETROFIT = "2.9.0"
    const val KOTLINX_SERIALIZATION = "1.6.0"
    const val MOSHI = "1.15.0"
    
    // DI & Architecture
    const val HILT = "2.48"
    const val HILT_COMPOSE_NAV = "1.1.0"
    
    // Database
    const val ROOM = "2.6.1"
    const val SQLCIPHER = "4.5.4"
    
    // Jetpack Compose Navigation
    const val COMPOSE_NAV = "2.7.5"
    
    // Logging
    const val TIMBER = "5.0.1"
    const val LOGBACK = "1.3.11"
    
    // Coroutines
    const val COROUTINES = "1.7.3"
    
    // Other utilities
    const val COIL = "2.5.0"
    const val DATASTORE = "1.0.0"
}

// Project dependencies configuration
object Dependencies {
    object Kotlin {
        const val STDLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLINX_SERIALIZATION}"
    }
    
    object AndroidX {
        const val CORE = "androidx.core:core-ktx:${Versions.ANDROIDX_CORE}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.ANDROIDX_APPCOMPAT}"
        const val ACTIVITY = "androidx.activity:activity-compose:${Versions.ANDROIDX_ACTIVITY}"
        const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.ANDROIDX_LIFECYCLE}"
        const val LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ANDROIDX_LIFECYCLE}"
        const val DATASTORE = "androidx.datastore:datastore-preferences:${Versions.DATASTORE}"
        
        object Compose {
            const val BOM = "androidx.compose:compose-bom:${Versions.ANDROIDX_COMPOSE}"
            const val UI = "androidx.compose.ui:ui"
            const val MATERIAL3 = "androidx.compose.material3:material3:${Versions.ANDROIDX_COMPOSE_MATERIAL3}"
            const val PREVIEW = "androidx.compose.ui:ui-tooling-preview"
            const val TOOLING = "androidx.compose.ui:ui-tooling"
            const val NAV = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAV}"
        }
        
        object Room {
            const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
            const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
            const val KTX = "androidx.room:room-ktx:${Versions.ROOM}"
        }
        
        object Test {
            const val JUNIT = "androidx.test.ext:junit:${Versions.ANDROIDX_TEST}"
            const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ANDROIDX_ESPRESSO}"
            const val COMPOSE = "androidx.compose.ui:ui-test-junit4"
            const val MANIFEST = "androidx.compose.ui:ui-test-manifest"
        }
    }
    
    object Network {
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val OKHTTP_LOGGING = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val RETROFIT_JSON = "com.squareup.retrofit2:converter-kotlinx-serialization:${Versions.RETROFIT}"
        const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
        const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"
    }
    
    object DI {
        const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT}"
        const val HILT_COMPOSE = "androidx.hilt:hilt-navigation-compose:${Versions.HILT_COMPOSE_NAV}"
    }
    
    object Testing {
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val JUNIT5 = "org.junit.jupiter:junit-jupiter:${Versions.JUNIT5}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val KOTEST = "io.kotest:kotest-runner-junit5:${Versions.KOTEST}"
        const val KOTEST_ASSERTIONS = "io.kotest:kotest-assertions-core:${Versions.KOTEST}"
    }
    
    object Logging {
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
        const val LOGBACK = "ch.qos.logback:logback-android:${Versions.LOGBACK}"
    }
    
    object Image {
        const val COIL = "io.coil-kt:coil-compose:${Versions.COIL}"
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// Common configuration for all subprojects
subprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://androidx.dev/snapshots/builds/11041576/artifacts/repository")
    }
}
