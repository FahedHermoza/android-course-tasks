package com.emedinaa.kotlinapp.data

import com.emedinaa.kotlinapp.data.storage.Mapper
import com.emedinaa.kotlinapp.data.storage.ProductDataSource
import com.emedinaa.kotlinapp.domain.ProductRepository
import com.emedinaa.kotlinapp.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteRepository (private val dataSource: ProductDataSource): ProductRepository{


    override suspend fun fetch(token: String): StorageResult<Product> = withContext(Dispatchers.IO) {
        when (val result = dataSource.products(token)) {
            is StorageResult.Success ->
                StorageResult.Success(result.data?.map {
                    Mapper.productDTOToProduct(it)
                })
            is StorageResult.Failure -> StorageResult.Failure(result.exception)
            else -> StorageResult.UnAuthorized(Exception())
        }
    }

}