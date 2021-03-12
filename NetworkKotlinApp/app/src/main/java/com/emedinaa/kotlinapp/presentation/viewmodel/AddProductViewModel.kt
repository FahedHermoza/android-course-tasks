package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.di.Injector
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.product.AddProductUseCase
import com.emedinaa.kotlinapp.presentation.SingleLiveEvent
import kotlinx.coroutines.launch

class AddProductViewModel(private val addProductUseCase: AddProductUseCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError: LiveData<String> = _onError

    val onSuccess = SingleLiveEvent<Product>()

    fun addProduct(title:String, cost:Double) = viewModelScope.launch {
        val objectId = Injector.providePreferences().objectId()?:""
        val product = Product("", title, "", cost, "",objectId)
        val token = Injector.providePreferences().session()?:""
        when(val result = addProductUseCase.invoke(token, product)){
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