package com.emedinaa.kotlinapp.dominio

import androidx.lifecycle.LiveData
import com.emedinaa.kotlinapp.data.storage.StorageResult
import com.emedinaa.kotlinapp.dominio.model.Product

interface ProductRepository {
    fun getAllProducts(): LiveData<List<Product>>
    suspend fun addProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    suspend fun deleteAllProduct()
}