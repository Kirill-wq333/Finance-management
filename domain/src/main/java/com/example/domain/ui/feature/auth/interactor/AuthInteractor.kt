package com.example.domain.ui.feature.auth.interactor

import com.example.domain.ui.feature.auth.repository.AuthRepository
import javax.inject.Inject

class AuthInteractor @Inject constructor(
    private val authRepository: AuthRepository
) {

}