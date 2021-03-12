package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.product.UpdateProductUseCase
import com.emedinaa.kotlinapp.presentation.SingleLiveEvent
import kotlinx.coroutines.launch

class EditProductViewModel(private val updateProductUseCase: UpdateProductUseCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError: LiveData<String> = _onError

    val onSuccess = SingleLiveEvent<Product>()

    fun editProduct(title:String, cost: Double, product:Product) = viewModelScope.launch {
        val token = Injector.providePreferences().session()?:""
        product.name = title
        product.cost = cost
        when(val result = updateProductUseCase.invoke(token, product)){
            is StorageResult.Complete -> {
                result.data?.let {
                    onSuccess.value = it
                }
            }
            is StorageResult.Failure -> { _onError.value = result.exception?.message?:"Ocurrió un error" }
            else -> { _onError.value = "Error 401...unauthorized" }
        }
    }
}