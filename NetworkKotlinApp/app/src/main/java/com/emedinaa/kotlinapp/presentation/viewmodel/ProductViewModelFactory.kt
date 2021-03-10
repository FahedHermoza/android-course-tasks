package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.product.FetchProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.AuthenticateUserUseCase

/**
 * @author Eduardo Medina
 */
class ProductViewModelFactory(private val fetchProductUseCase: FetchProductUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(fetchProductUseCase) as T
    }
}