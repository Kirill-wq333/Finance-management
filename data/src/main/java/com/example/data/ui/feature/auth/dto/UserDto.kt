package com.example.data.ui.feature.auth.dto

data class UserDto(
    val id: Int,
    val publicId: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val avatarUrl: String,
    val currency: String,
    val fingerprintEnabled: Boolean,
    val dateOfBirth: String,
    val createdAt: String
)

data class UserMeDto(
    val id: Int,
    val publicId: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val avatarUrl: String,
    val monthlyBudget: Int,
    val currency: String,
    val fingerprintEnabled: Boolean,
    val dateOfBirth: String,
    val hasPin: Boolean,
    val createdAt: String,
    val updatedAt: String
)

data class UserSocialDto(
    val id: Int,
    val name: String,
    val email: String,
    val avatarUrl: String,
    val fingerprintEnabled: Boolean
)

data class UserFingerprintVerifyDto(
    val id: Int,
    val name: String,
    val email: String
)
