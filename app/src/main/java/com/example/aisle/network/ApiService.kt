package com.example.aisle.network

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL = "https://app.aisle.co/V1/"   //dev url
    }

    @POST("users/phone_number_login")
    suspend fun callPhoneNumberApi(@Query("number") number: String): ResponseBody
    @POST("users/verify_otp")
    suspend fun callOtpApi(@Query("number")phoneNumber: String,@Query("otp") otp: String):  ResponseBody
    @GET("users/test_profile_list")
    suspend fun callNotesApi(@Header("authorization") authorization:String) : ResponseBody
}
