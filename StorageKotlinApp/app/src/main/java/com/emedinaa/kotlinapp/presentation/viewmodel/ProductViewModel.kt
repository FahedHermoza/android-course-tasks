package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.ClearProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.FetchProductUseCase
import kotlinx.coroutines.launch

class ProductViewModel(private val fetchProductUseCase: FetchProductUseCase,
                       private val clearProductUseCase: ClearProductUseCase
): ViewModel() {

    private val _products = MutableLiveData <LiveData<List<Product>>>()
    val onProducts = _products

    init{
        loadProducts()
    }

    fun loadProducts():LiveData<List<Product>> = fetchProductUseCase.invoke()

    fun deleteAllProducts() = viewModelScope.launch {
        clearProductUseCase.invoke()
    }
}