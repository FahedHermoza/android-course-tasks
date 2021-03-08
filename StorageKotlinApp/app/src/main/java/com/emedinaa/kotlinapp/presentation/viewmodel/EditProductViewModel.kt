package com.emedinaa.kotlinapp.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emedinaa.kotlinapp.R
import com.emedinaa.kotlinapp.dominio.model.Product
import com.emedinaa.kotlinapp.dominio.usecase.AddProductUserCase
import com.emedinaa.kotlinapp.dominio.usecase.UpdateProductUserCase
import com.emedinaa.kotlinapp.presentation.SingleLiveEvent
import kotlinx.coroutines.launch

class EditProductViewModel(private val updateProductUserCase: UpdateProductUserCase): ViewModel() {
    val _onError = MutableLiveData<String>()
    val onError = _onError

    val onSuccess = SingleLiveEvent<Boolean>()

    fun editProduct(title:String, cost: Double, product:Product)= viewModelScope.launch {
            product.name = title
            product.cost = cost
            updateProductUserCase.invoke(product)
    }
}