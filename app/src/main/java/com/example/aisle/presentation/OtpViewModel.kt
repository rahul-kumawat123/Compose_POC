package com.example.aisle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisle.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun callOtpApi(phoneNumber:String,otp:String) {
        viewModelScope.launch {
            repository.callOtpApi(phoneNumber,otp).let {
                repository.callNotesApi(authToken = "32c7794d2e6a1f7316ef35aa1eb34541")
            }
        }
    }
}