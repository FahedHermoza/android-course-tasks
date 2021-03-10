package com.emedinaa.kotlinapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.usecase.UpdateProductUseCase
import com.emedinaa.kotlinapp.presentation.SingleLiveEvent
import kotlinx.coroutines.launch

class EditProductViewModel(private val updateProductUseCase: UpdateProductUseCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError = _onError

    val onSuccess = SingleLiveEvent<Boolean>()

    fun editProduct(title:String, cost: Double, product:Product)= viewModelScope.launch {
            product.name = title
            product.cost = cost
            updateProductUseCase.invoke(product)
    }
}