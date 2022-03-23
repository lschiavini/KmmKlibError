import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
    id("dev.icerock.mobile.multiplatform-resources")
    id("kotlin-parcelize")
    id("org.jlleitschuh.gradle.ktlint")
    kotlin("plugin.serialization")
    id("com.chromaticnoise.multiplatform-swiftpackage") version "2.0.3"
}

version = "1.0"

kotlin {
    android()

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
//        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {}

    cocoapods {
        noPodspec()
        ios.deploymentTarget = "11"
        framework {
            summary = "Some description for the Shared Module"
            homepage = "Link to the Shared Module homepage"
            baseName = "shared_core"
            isStatic = false
            embedBitcode(org.jetbrains.kotlin.gradle.plugin.mpp.BitcodeEmbeddingMode.BITCODE)
        }
//        podfile = project.file("../../ios/Podfile")
        // set path to your ios project podfile, e.g. podfile = project.file("../iosApp/Podfile")
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.3.1")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
                implementation("co.touchlab:stately-isolate:1.1.4-a1")
                implementation("co.touchlab:stately-iso-collections:1.1.4-a1")

                api("dev.icerock.moko:resources:0.17.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:1.2.0")
                implementation("com.google.android.material:material:1.3.0")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
            }
        }
        val iosTest by getting
    }
}

multiplatformResources {
    multiplatformResourcesPackage = "com.example.shared_core"
    iosBaseLocalizationRegion = "pt"
    multiplatformResourcesSourceSet = "commonMain"
}

multiplatformSwiftPackage {
    packageName("SharedCorePackage")
    swiftToolsVersion("5.3")
    targetPlatforms {
        iOS { v("13") }
    }
}

android {
    compileSdkVersion(31)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(22)
        targetSdkVersion(31)
    }
}

// subprojects {     apply(plugin = "org.jlleitschuh.gradle.ktlint") // Version should be inherited from parent
// repositories {         mavenCentral()     }
//    configure<org.jlleitschuh.gradle.ktlint.KtlintExtension> {         debug.set(true)     }
