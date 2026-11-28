package com.example.data.ui.feature.auth.dto.request

data class SocialRequest(
    val provider: String,
    val providerId: String,
    val name: String,
    val email: String
)
