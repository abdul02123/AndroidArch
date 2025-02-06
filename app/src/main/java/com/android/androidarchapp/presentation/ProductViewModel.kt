package com.android.androidarchapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.androidarchapp.core.Resource
import com.android.androidarchapp.domain.model.ProductResponse
import com.android.androidarchapp.domain.usecase.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productUseCase: ProductUseCase): ViewModel() {

    val result = MutableLiveData<Resource<ProductResponse>?>()

    fun getAllProductList(){
        viewModelScope.launch {
            result.value = Resource.Loading()
            val data = productUseCase.getProductList()
            result.value = data
        }
    }

}