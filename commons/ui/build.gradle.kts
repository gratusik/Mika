plugins {
    id("commons.android-library")
}

dependencies {
    implementation(project(build.Modules.Common.CORE))
    implementation(dependency.Libs.APPCOMPAT)
    implementation(dependency.Libs.MATERIAL)
    implementation(dependency.Libs.NAVIGATION_FRAGMENT)
    implementation(dependency.Libs.CONSTRAINT_LAYOUT)
    implementation(dependency.Libs.LIFECYCLE_VIEWMODEL)
    implementation(dependency.Libs.LIFECYCLE_LIVEDATA)
    implementation(dependency.Libs.LIFECYCLE_EXTENSIONS)
    implementation(dependency.Libs.LIFECYCLE)
    implementation(dependency.Libs.NAVIGATION_UI)
    implementation(dependency.Libs.DAGGER)
    implementation(dependency.Libs.RXJAVA)
    implementation(dependency.Libs.RXJAVA_ANDROID)
    implementation(dependency.Libs.DAGGER_ANDROID)
    kapt(dependency.AnnotationProcessorsDependencies.DAGGER_COMPILER)
    kapt(dependency.AnnotationProcessorsDependencies.DAGGER_ANDROID_COMPILER)
}
