package com.jayguy.globalnews.utils

/**
 * Created by Leo on 2022/11/8.
 */

sealed class ApiResponseType<out T> {
    object Loading: ApiResponseType<Nothing>()
    data class Success<out T>(val data: T?): ApiResponseType<T>()
    data class Failure(val e: Exception?): ApiResponseType<Nothing>()
}