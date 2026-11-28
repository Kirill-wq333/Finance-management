package com.example.data.ui.feature.auth.dto.response

import com.example.data.ui.feature.auth.dto.UserSocialDto

data class SocialResponse(
    val success: Boolean,
    val message: String,
    val data: Social
)

data class Social(
    val token: String,
    val user: UserSocialDto
)
