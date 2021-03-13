package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinapp.domain.usecase.AddProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.ClearProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.FetchProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.UpdateProductUseCase

/**
 * @author Eduardo Medina
 */
class ProductViewModelFactory(private val fetchProductUseCase: FetchProductUseCase,
                              private val clearProductUseCase: ClearProductUseCase,
                              private val addProductUseCase: AddProductUseCase,
                              private val updateProductUseCase: UpdateProductUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductViewModel(
                fetchProductUseCase,
                clearProductUseCase,
                addProductUseCase,
                updateProductUseCase
        ) as T
    }
}