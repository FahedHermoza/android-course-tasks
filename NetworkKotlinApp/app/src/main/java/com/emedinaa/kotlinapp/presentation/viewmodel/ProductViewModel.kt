package com.emedinaa.kotlinapp.presentation.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.product.FetchProductUseCase
import com.emedinaa.kotlinapp.domain.usecase.user.AuthenticateUserUseCase
import kotlinx.coroutines.launch

class ProductViewModel(private val fetchProductUseCase: FetchProductUseCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError = _onError

    private val _products = MutableLiveData <List<Product>>()
    val onProducts = _products

    fun loadProducts() = viewModelScope.launch {
        val token = Injector.providePreferences().session()?:""
        when (val result = fetchProductUseCase.invoke(token)) {
            is StorageResult.Success -> {
                val notes = result.data ?: emptyList()
                onProducts.value = notes
            }
            is StorageResult.Failure -> {
                onError.value = result.exception?.message ?: "Ocurrió un error"
            }
        }
    }
}