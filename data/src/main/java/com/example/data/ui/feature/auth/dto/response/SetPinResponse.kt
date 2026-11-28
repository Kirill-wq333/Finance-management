package com.example.data.ui.feature.auth.dto.response

data class SetPinResponse(
    val success: Boolean,
    val message: String,
    val data: Any? = null
)
