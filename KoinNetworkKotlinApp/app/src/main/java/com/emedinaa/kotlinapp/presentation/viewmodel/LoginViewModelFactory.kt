package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.user.AuthenticateUserUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.SaveSessionUseCase

/**
 * @author Eduardo Medina
 */
class LoginViewModelFactory(private val authenticationUserUseCase: AuthenticateUserUseCase,
                            private val saveSessionUseCase: SaveSessionUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(authenticationUserUseCase, saveSessionUseCase) as T
    }
}