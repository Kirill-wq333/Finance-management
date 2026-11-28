package com.example.data.ui.feature.auth.dto.response

import com.example.data.ui.feature.auth.dto.UserDto

data class AuthResponse(
    val success: Boolean,
    val message: String,
    val data: Register
)

data class Register(
    val token: String,
    val user: UserDto
)