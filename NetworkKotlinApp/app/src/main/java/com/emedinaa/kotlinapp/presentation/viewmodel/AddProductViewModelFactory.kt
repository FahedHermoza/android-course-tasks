package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.product.AddProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.GetObjectIdUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.GetSessionUseCase

/**
 * @author Eduardo Medina
 */
class AddProductViewModelFactory(private val addProductUseCase: AddProductUseCase,
                                 private val getSessionUseCase: GetSessionUseCase,
                                 private val getObjectIdUseCase: GetObjectIdUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddProductViewModel(addProductUseCase, getSessionUseCase, getObjectIdUseCase) as T
    }
}