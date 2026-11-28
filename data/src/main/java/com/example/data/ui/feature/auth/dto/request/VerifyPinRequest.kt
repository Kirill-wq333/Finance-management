package com.example.data.ui.feature.auth.dto.request

data class VerifyPinRequest(
    val email: String,
    val pin: String
)
