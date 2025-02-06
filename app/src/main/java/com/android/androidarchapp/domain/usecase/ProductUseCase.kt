package com.android.androidarchapp.domain.usecase

import com.android.androidarchapp.core.Resource
import com.android.androidarchapp.domain.model.ProductResponse
import com.android.androidarchapp.domain.remote.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun getProductList(): Resource<ProductResponse>?{
        return productRepository.getProductsList()
    }
}