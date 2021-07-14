package com.example.gallerify.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class FlckrPhotos(
    val photos: FlckrPhoto,
    val stat   :String?
): Parcelable
