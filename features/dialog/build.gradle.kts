plugins {
    id("commons.android-library")
    id("kotlin-kapt")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(build.Modules.Common.CORE))
    implementation(project(build.Modules.Common.UI))
    implementation(dependency.Libs.KOTLIN)
    implementation(dependency.Libs.CORE_KTX)
    implementation(dependency.Libs.APPCOMPAT)
    implementation(dependency.Libs.CONSTRAINT_LAYOUT)
    implementation(dependency.Libs.MATERIAL)
    implementation(dependency.Libs.DAGGER)
    implementation(dependency.Libs.DAGGER_ANDROID)
    implementation(dependency.Libs.NAVIGATION_FRAGMENT)
    implementation(dependency.Libs.NAVIGATION_UI)
    implementation(dependency.Libs.LIFECYCLE_LIVEDATA)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    kapt(dependency.AnnotationProcessorsDependencies.DAGGER_COMPILER)
    kapt(dependency.AnnotationProcessorsDependencies.DAGGER_ANDROID_COMPILER)
}
