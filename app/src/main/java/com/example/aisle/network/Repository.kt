package com.example.aisle.network

import javax.inject.Inject

open class Repository @Inject constructor(private val apiService: ApiService) {
    suspend fun callPhoneNumberApi(phoneNumber: String) = apiService.callPhoneNumberApi(phoneNumber)
    suspend fun callOtpApi(phoneNumber: String, otp: String) = apiService.callOtpApi(phoneNumber,otp)
    suspend fun callNotesApi(authToken:String) = apiService.callNotesApi(authToken)
//    suspend fun getSignIn(model: LoginWithOtpDataModel) = apiService.sinIn(model)
//    suspend fun getSignInWithPassword(model: LoginDataModel) = apiService.sinInWithPassword(model)
}