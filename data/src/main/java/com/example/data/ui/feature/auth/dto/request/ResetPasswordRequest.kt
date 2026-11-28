package com.example.data.ui.feature.auth.dto.request

data class ResetPasswordRequest(
    val token: String,
    val newPassword: String,
    val confirmNewPassword: String
)
