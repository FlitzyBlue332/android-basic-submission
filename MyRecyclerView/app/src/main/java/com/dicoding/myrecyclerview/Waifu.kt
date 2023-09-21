package com.dicoding.myrecyclerview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val name: String,
    val description: String,
    val photo: String,
    val birthday: String
) : Parcelable
