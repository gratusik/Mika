import dependency.Libs


plugins {
    id("commons.android-library")
    id("kotlin-kapt")
}

dependencies {
    implementation(Libs.DAGGER)
    implementation(Libs.DAGGER_ANDROID)
    implementation(Libs.RXJAVA)
    implementation(Libs.RXJAVA_ANDROID)
}
