package com.example.data.ui.feature.auth.dto.response

data class ForgotPasswordResponse(
    val success: Boolean,
    val message: String,
    val data: ForgotPassword?
)

data class ForgotPassword(
    val resetToken: String,
    val message: String
)