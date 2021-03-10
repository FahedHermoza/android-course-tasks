package com.emedinaa.kotlinapp.domain

import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.domain.model.Product

interface ProductRespository {

    suspend fun fetch(token:String): StorageResult<Product>
}