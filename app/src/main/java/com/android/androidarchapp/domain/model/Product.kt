package com.android.androidarchapp.domain.model

import java.io.Serializable

class Product(
    val brand: String?,
    var category: String?,
    var description: String?,
    var discountPercentage: Double?,
    var id: Int? = null,
    var images: Array<String>?,
    var rating: Double?,
    var stock: Int?,
    var thumbnail: String?,
    var title: String? = null
) : Serializable