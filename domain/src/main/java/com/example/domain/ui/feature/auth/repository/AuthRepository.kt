package com.example.domain.ui.feature.auth.repository

import com.example.domain.ui.feature.auth.model.FingerprintSetup
import com.example.domain.ui.feature.auth.model.ForgotPassword
import com.example.domain.ui.feature.auth.model.User
import com.example.domain.ui.feature.auth.model.UserFingerprintVerify
import com.example.domain.ui.feature.auth.model.UserMe
import com.example.domain.ui.feature.auth.model.UserSocial
import com.example.domain.ui.feature.auth.model.VerifyPin

interface AuthRepository {
    suspend fun register(
        name: String,
        email: String,
        password: String,
        confirmPassword: String,
        dateOfBirth: String,
        username: String
        ): Result<User>

    suspend fun login(email: String, password: String): Result<User>

    suspend fun social(
        provider: String,
        providerId: String,
        name: String,
        email: String
    ): Result<UserSocial>

    suspend fun verifyPin(email: String, pin: String): Result<VerifyPin>

    suspend fun setPin(pin: String, confirmPin: String): Result<Any?>

    suspend fun updatePin(
        currentPin: String,
        newPin: String,
        confirmPin: String
    ): Result<Any>

    suspend fun fingerprintSetup(enabled: Boolean): Result<FingerprintSetup>

    suspend fun fingerprintVerify(email: String): Result<UserFingerprintVerify>

    suspend fun forgotPassword(email: String): Result<ForgotPassword?>

    suspend fun resetPassword(
        token: String,
        newPassword: String,
        confirmNewPassword: String
    ): Result<Any?>

    suspend fun me(): Result<UserMe>
}