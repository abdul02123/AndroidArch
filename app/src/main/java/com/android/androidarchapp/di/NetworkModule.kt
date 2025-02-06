package com.android.androidarchapp.di

import com.android.androidarchapp.data.remote.ProductApi
import com.android.androidarchapp.data.repository.ProductRepoImplementation
import com.android.androidarchapp.domain.remote.ProductRepository
import com.android.androidarchapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
    }

    @Provides
    fun providesProductList(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }


    @Provides
    fun providesProductRepo(productApi: ProductApi): ProductRepository {
        return ProductRepoImplementation(productApi)
    }
}