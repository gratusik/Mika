package com.gratus.dialog.domain.local

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
// data class custom to transfer data between dialogs and fragments
data class DialogData(
    var choice: String,
) : Parcelable
