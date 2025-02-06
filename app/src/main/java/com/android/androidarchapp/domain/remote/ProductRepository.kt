package com.android.androidarchapp.domain.remote

import com.android.androidarchapp.core.Resource
import com.android.androidarchapp.domain.model.ProductResponse

interface ProductRepository {

    suspend fun getProductsList(): Resource<ProductResponse>?
}