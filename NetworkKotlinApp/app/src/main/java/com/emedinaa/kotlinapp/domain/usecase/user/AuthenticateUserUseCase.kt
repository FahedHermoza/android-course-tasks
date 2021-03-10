package com.emedinaa.kotlinapp.domain.usecase

import com.emedinaa.kotlinapp.domain.AuthenticationRepository

class AuthenticateUseCase(private val authenticationRepository: AuthenticationRepository) {

    suspend operator fun invoke(username: String?, password: String?) = run{
        authenticationRepository.login(username, password)
    }
}