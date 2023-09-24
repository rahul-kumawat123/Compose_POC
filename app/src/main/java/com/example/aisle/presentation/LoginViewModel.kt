package com.example.aisle.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisle.network.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    fun callPhoneApi(phoneNumber:String) {
        viewModelScope.launch {
            repository.callPhoneNumberApi(phoneNumber).let {

            }
        }
    }
}