package com.example.data.ui.feature.auth.dto.response

data class VerifyPinResponse(
    val success: Boolean,
    val message: String,
    val data: VerifyPin
)

data class VerifyPin(
    val token: String
)
