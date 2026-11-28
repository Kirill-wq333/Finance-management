package com.example.domain.ui.feature.auth.model

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@OptIn(InternalSerializationApi::class)
@Serializable
data class User(
    val id: Int,
    @SerialName("public_id")val publicId: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    @SerialName("avatar_url") val avatarUrl: String,
    val currency: String,
    @SerialName("fingerprint_enabled") val fingerprintEnabled: Boolean,
    @SerialName("date_of_birth") val dateOfBirth: String,
    val createdAt: String
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class UserMe(
    val id: Int,
    @SerialName("public_id")val publicId: String,
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("monthly_budget")val monthlyBudget: Int,
    val currency: String,
    @SerialName("fingerprint_enabled") val fingerprintEnabled: Boolean,
    @SerialName("date_of_birth") val dateOfBirth: String,
    @SerialName("has_pin")val hasPin: Boolean,
    @SerialName("created_at")val createdAt: String,
    @SerialName("updated_at") val updatedAt: String
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class UserSocial(
    val id: Int,
    val name: String,
    val email: String,
    @SerialName("avatar_url") val avatarUrl: String,
    @SerialName("fingerprint_enabled") val fingerprintEnabled: Boolean,
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class UserFingerprintVerify(
    val id: Int,
    val name: String,
    val email: String
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class VerifyPin(
    val token: String
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class FingerprintSetup(
    @SerialName("fingerprint_enabled") val fingerprintEnabled: String
){}

@OptIn(InternalSerializationApi::class)
@Serializable
data class ForgotPassword(
    val resetToken: String,
    val message: String
){}