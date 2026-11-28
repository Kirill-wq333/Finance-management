package com.example.data.ui.feature.auth.dto.response

import com.example.data.ui.feature.auth.dto.UserFingerprintVerifyDto

data class FingerprintVerifyResponse(
    val success: Boolean,
    val message: String,
    val data: FingerprintVerify
)

data class FingerprintVerify(
    val token: String,
    val user: UserFingerprintVerifyDto
)
