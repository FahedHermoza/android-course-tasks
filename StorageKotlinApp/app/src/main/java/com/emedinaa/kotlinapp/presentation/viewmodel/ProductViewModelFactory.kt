package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.dominio.usecase.AddProductUserCase
import com.emedinaa.kotlinapp.dominio.usecase.ClearProductUserCase
import com.emedinaa.kotlinapp.dominio.usecase.FetchProductUserCase

/**
 * @author Eduardo Medina
 */
class ProductViewModelFactory(private val fetchProductUserCase: FetchProductUserCase,
                              private val clearProductUserCase: ClearProductUserCase
): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(
            fetchProductUserCase,
            clearProductUserCase
        ) as T
    }
}