package com.example.data.ui.feature.auth.dto.request

data class UpdatePinRequest(
    val currentPin: String,
    val newPin: String,
    val confirmPin: String
)
