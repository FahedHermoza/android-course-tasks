package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.UpdateProductUseCase

/**
 * @author Eduardo Medina
 */
class EditProductViewModelFactory(private val updateProductUseCase: UpdateProductUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditProductViewModel(updateProductUseCase) as T
    }
}