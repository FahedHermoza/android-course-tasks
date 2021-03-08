package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.dominio.model.Product
import com.emedinaa.kotlinapp.dominio.usecase.ClearProductUserCase
import com.emedinaa.kotlinapp.dominio.usecase.FetchProductUserCase
import kotlinx.coroutines.launch

class ProductViewModel(private val fetchProductUserCase: FetchProductUserCase,
                       private val clearProductUserCase: ClearProductUserCase
): ViewModel() {

    private val _products = MutableLiveData <LiveData<List<Product>>>()
    val onProducts = _products

    init{
        loadProducts()
    }

    fun loadProducts():LiveData<List<Product>> = fetchProductUserCase.invoke()

    fun deleteAllProducts() = viewModelScope.launch {
        clearProductUserCase.invoke()
    }
}