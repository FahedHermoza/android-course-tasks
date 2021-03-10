package com.emedinaa.kotlinapp.data.storage

import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.data.remote.ProductDTO

interface ProductDataSource {

    suspend fun products(token:String?): StorageResult<ProductDTO>
}