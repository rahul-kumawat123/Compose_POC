package com.example.aisle.common


import android.util.Log

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?
) {
    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, "Success")
        }

        fun <T> error(msg: String, data: T?): Resource<T> {
            Log.d("error ",">"+data.hashCode()+" == "+data)

            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING, null, "")
        }
        fun <T> idle(): Resource<T> {
            return Resource(Status.IDLE, null, "")
        }

    }

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING,
        IDLE
    }
}