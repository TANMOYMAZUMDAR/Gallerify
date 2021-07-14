package com.example.gallerify.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FlckrPhoto (
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<images>
) :Parcelable