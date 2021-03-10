package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.AddProductUseCase
import com.emedinaa.kotlinapp.presentation.SingleLiveEvent
import kotlinx.coroutines.launch

class AddProductViewModel(private val addProductUseCase: AddProductUseCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError = _onError

    val onSuccess = SingleLiveEvent<Boolean>()


    fun addNewProduct(title:String, cost: Double, description: String) = viewModelScope.launch {
        var product = Product(0, title, cost, description, R.mipmap.ic_funko)
        addProductUseCase.invoke(product)
    }
}