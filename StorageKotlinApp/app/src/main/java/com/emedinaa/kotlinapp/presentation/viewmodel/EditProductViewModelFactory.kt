package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.dominio.usecase.AddProductUserCase
import com.emedinaa.kotlinapp.dominio.usecase.UpdateProductUserCase

/**
 * @author Eduardo Medina
 */
class EditProductViewModelFactory(private val updateProductUserCase: UpdateProductUserCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return EditProductViewModel(updateProductUserCase) as T
    }
}