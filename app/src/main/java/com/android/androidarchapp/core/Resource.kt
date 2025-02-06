package com.android.androidarchapp.core

import com.android.androidarchapp.util.ErrorResponse
import retrofit2.Response

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val errorResponse: ErrorResponse?= null
) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String?, errorResponse: ErrorResponse?) : Resource<T>(message = message, errorResponse = errorResponse)
    class Loading<T> : Resource<T>()
}

inline fun <reified T> Response<T>.toResource(): Resource<T>{
    return if (isSuccessful){
        Resource.Success(body())
    }else{
        Resource.Error("Error", errorResponse =  ErrorResponse(code(), message()))
    }
}

