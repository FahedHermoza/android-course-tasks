package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.AddProductUseCase

/**
 * @author Eduardo Medina
 */
class AddProductViewModelFactory(private val addProductUseCase: AddProductUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddProductViewModel(addProductUseCase) as T
    }
}