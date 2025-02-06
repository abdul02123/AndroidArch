package com.android.androidarchapp.domain.model

import java.io.Serializable

class ProductResponse(
    val limit: Int?,
    val products: ArrayList<Product>,
    val skip: Int?,
    val total: Int?
) : Serializable