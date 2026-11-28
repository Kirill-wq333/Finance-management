package com.example.data.ui.feature.auth.dto.request

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val phone: String,
    val dateOfBirth: String
)