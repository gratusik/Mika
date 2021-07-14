package dependency

object Libs {
    object Versions {
        const val KOTLIN = "1.4.32"
        const val KOTLIN_VERSION = "1.5.10"
        const val CORE_KTX = "1.3.2"
        const val APPCOMPAT = "1.2.0"
        const val MATERIAL = "1.4.0-beta01"
        const val CONSTRAINT_LAYOUT = "2.0.4"
        const val NAVIGATION = "2.3.5"
        const val LIFECYCLE = "2.3.1"
        const val LIFECYCLE_EXTENSION = "2.2.0"
        const val COROUTINES = "1.4.3"
        const val DAGGER = "2.35"
        const val RXJAVA = "2.2.21"
        const val RXJAVA_ANDROID = "2.1.1"
    }

    // libs
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"

    // material
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"

    // constraint layout
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"

    // fragment - navigation host
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    // lifecycle
    const val LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_VIEWMODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_EXTENSIONS =
        "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_EXTENSION}"

    // dagger
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"
    const val RXJAVA = "io.reactivex.rxjava2:rxjava:${Versions.RXJAVA}"
    const val RXJAVA_ANDROID = "io.reactivex.rxjava2:rxandroid:${Versions.RXJAVA_ANDROID}"
}
