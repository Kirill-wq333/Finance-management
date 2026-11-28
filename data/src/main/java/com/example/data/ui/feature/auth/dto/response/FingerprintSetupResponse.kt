package com.example.data.ui.feature.auth.dto.response

data class FingerprintSetupResponse(
    val success: Boolean,
    val message: String,
    val data: FingerprintSetup
)

data class FingerprintSetup(
    val fingerprintEnabled: Boolean
)
