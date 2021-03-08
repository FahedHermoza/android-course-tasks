package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.dominio.usecase.AddProductUserCase

/**
 * @author Eduardo Medina
 */
class AddProductViewModelFactory(private val addProductUserCase: AddProductUserCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddProductViewModel(addProductUserCase) as T
    }
}