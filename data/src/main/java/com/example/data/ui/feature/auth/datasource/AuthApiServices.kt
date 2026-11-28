package com.example.data.ui.feature.auth.datasource

import com.example.data.ui.feature.auth.dto.request.FingerprintSetupRequest
import com.example.data.ui.feature.auth.dto.request.FingerprintVerifyRequest
import com.example.data.ui.feature.auth.dto.request.ForgotPasswordRequest
import com.example.data.ui.feature.auth.dto.request.LoginRequest
import com.example.data.ui.feature.auth.dto.request.RegisterRequest
import com.example.data.ui.feature.auth.dto.request.ResetPasswordRequest
import com.example.data.ui.feature.auth.dto.request.SetPinRequest
import com.example.data.ui.feature.auth.dto.request.SocialRequest
import com.example.data.ui.feature.auth.dto.request.UpdatePinRequest
import com.example.data.ui.feature.auth.dto.request.VerifyPinRequest
import com.example.data.ui.feature.auth.dto.response.AuthResponse
import com.example.data.ui.feature.auth.dto.response.FingerprintSetupResponse
import com.example.data.ui.feature.auth.dto.response.FingerprintVerifyResponse
import com.example.data.ui.feature.auth.dto.response.ForgotPasswordResponse
import com.example.data.ui.feature.auth.dto.response.MeResponse
import com.example.data.ui.feature.auth.dto.response.ResetPasswordResponse
import com.example.data.ui.feature.auth.dto.response.SetPinResponse
import com.example.data.ui.feature.auth.dto.response.SocialResponse
import com.example.data.ui.feature.auth.dto.response.VerifyPinResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthApiServices {

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): AuthResponse

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): AuthResponse

    @POST("auth/social")
    suspend fun social(@Body request: SocialRequest): SocialResponse

    @POST("auth/verify-pin")
    suspend fun verifyPin(@Body request: VerifyPinRequest): VerifyPinResponse

    @POST("auth/fingerprint/verify")
    suspend fun fingerprintVerify(@Body request: FingerprintVerifyRequest): FingerprintVerifyResponse

    @POST("auth/forgot-password")
    suspend fun forgotPassword(@Body request: ForgotPasswordRequest): ForgotPasswordResponse

    @POST("auth/reset-password")
    suspend fun resetPassword(@Body request: ResetPasswordRequest): ResetPasswordResponse

    @POST("auth/set-pin")
    suspend fun setPin(@Body request: SetPinRequest): SetPinResponse

    @PUT("auth/update-pin")
    suspend fun updatePin(@Body request: UpdatePinRequest): SetPinResponse

    @POST("auth/fingerprint/setup")
    suspend fun fingerprintSetup(@Body request: FingerprintSetupRequest): FingerprintSetupResponse

    @GET("auth/me")
    suspend fun me(): MeResponse

}