package com.android.androidarchapp.data.remote

import com.android.androidarchapp.domain.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductApi {

    @GET("productss")
    suspend fun getProducts(): Response<ProductResponse>?
}