package com.android.androidarchapp.data.repository

import com.android.androidarchapp.core.Resource
import com.android.androidarchapp.core.toResource
import com.android.androidarchapp.data.remote.ProductApi
import com.android.androidarchapp.domain.model.ProductResponse
import com.android.androidarchapp.domain.remote.ProductRepository
import javax.inject.Inject

class ProductRepoImplementation @Inject constructor(private val productApi: ProductApi): ProductRepository{

    override suspend fun getProductsList(): Resource<ProductResponse>? {
        val response = productApi.getProducts()
        return response?.toResource()
    }
}