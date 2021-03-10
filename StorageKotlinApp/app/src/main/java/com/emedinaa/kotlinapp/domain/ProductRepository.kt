package com.emedinaa.kotlinapp.domain

import androidx.lifecycle.LiveData
import com.emedinaa.kotlinapp.domain.model.Product

interface ProductRepository {
    fun getAllProducts(): LiveData<List<Product>>
    suspend fun addProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    suspend fun deleteAllProduct()
}