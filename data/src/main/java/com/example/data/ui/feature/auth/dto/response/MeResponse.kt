package com.example.data.ui.feature.auth.dto.response

import com.example.data.ui.feature.auth.dto.UserMeDto

data class MeResponse(
    val success: Boolean,
    val message: String,
    val data: UserMeDto
)