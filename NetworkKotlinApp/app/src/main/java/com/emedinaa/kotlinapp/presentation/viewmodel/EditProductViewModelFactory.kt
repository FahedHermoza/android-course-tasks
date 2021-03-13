package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.product.AddProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.product.UpdateProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.GetSessionUseCase

/**
 * @author Eduardo Medina
 */
class EditProductViewModelFactory(private val updateProductUseCase: UpdateProductUseCase,
                                  private val getSessionUseCase: GetSessionUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditProductViewModel(updateProductUseCase, getSessionUseCase) as T
    }
}