package com.diatomicsoft.culturalfoods.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Food(
    var id: Int,
    var rating: Float,
    var title: String,
    var image: Int,
    var details: String
) : Parcelable
