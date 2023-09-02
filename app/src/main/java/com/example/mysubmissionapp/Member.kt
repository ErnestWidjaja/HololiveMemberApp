package com.example.mysubmissionapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    val name: String,
    val description: String,
    val photo: Int,
    val nameJp: String,
    val debut: String,
    val height: String,
    val birthday: String,
    val unit: String
) : Parcelable
