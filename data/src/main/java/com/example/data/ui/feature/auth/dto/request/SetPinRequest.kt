package com.example.data.ui.feature.auth.dto.request

data class SetPinRequest(
    val pin: String,
    val confirmPin: String
)
