package com.emedinaa.kotlinapp.data.storage.remote

import com.emedinaa.kotlinapp.data.StorageResult
import com.emedinaa.kotlinapp.data.remote.ProductApiClient
import com.emedinaa.kotlinapp.data.remote.ProductConstant
import com.emedinaa.kotlinapp.data.remote.ProductDTO
import com.emedinaa.kotlinapp.data.remote.ProductRaw
import com.emedinaa.kotlinapp.data.storage.ProductDataSource

class ProductRemoteDataSource(apiClient: ProductApiClient): ProductDataSource {

    private val serviceApi by lazy {
        apiClient.build()
    }

    override suspend fun products(token: String?): StorageResult<ProductDTO> {
        val map:MutableMap<String,String> = mutableMapOf()
        token?.let {
            map["user-token"] =it
        }
        return try {
            val response = serviceApi?.products(ProductConstant.APPLICATION_ID,ProductConstant.REST_API_KEY,map)
            response?.let {
                if (it.isSuccessful && it.body() != null) {
                    val data = it.body()
                    StorageResult.Success(data)
                } else {
                    StorageResult.Failure(Exception("Ocurrió un error"))
                }
            } ?: run {
                StorageResult.Failure(Exception("Ocurrió un error"))
            }
        } catch (e: Exception) {
            StorageResult.Failure(e)
        }
    }

    override suspend fun save(token: String?, product: ProductDTO): StorageResult<ProductDTO> {
        val map: MutableMap<String, String> = mutableMapOf()
        token?.let {
            map["user-token"] = it
        }
        return try {
            val raw = ProductRaw(product.name, product.description, product.cost, product.logo, product.code)
            val response = serviceApi?.addProduct(
                    ProductConstant.APPLICATION_ID, ProductConstant.REST_API_KEY, map, raw)

            response?.let {
                if (it.isSuccessful && it.body() != null) {
                    val data = it.body()
                    StorageResult.Complete(ProductDTO(data?.objectId, data?.name, data?.description,
                            data?.cost, data?.logo, data?.code))
                } else {
                    StorageResult.Failure(Exception(it.errorBody()?.string()))
                }
            } ?: run {
                StorageResult.Failure(Exception("Ocurrió un error"))
            }
        } catch (e: Exception) {
            StorageResult.Failure(e)
        }
    }

    override suspend fun update(token: String?, product: ProductDTO): StorageResult<ProductDTO> {
        val map:MutableMap<String,String> = mutableMapOf()
        token?.let {
            map["user-token"] =it
        }
        return try {
            val raw = ProductRaw(product.name, product.description, product.cost, product.logo, product.code)
            val response = serviceApi?.updateProduct(ProductConstant.APPLICATION_ID,
                    ProductConstant.REST_API_KEY,map,product.objectId,raw)

            response?.let {
                if (it.isSuccessful && it.body() != null) {
                    val data = it.body()
                    StorageResult.Complete(ProductDTO(data?.objectId, data?.name, data?.description,
                            data?.cost, data?.logo, data?.code)
                    )
                } else {
                    StorageResult.Failure(Exception(it.errorBody()?.string()))
                }
            } ?: run {
                StorageResult.Failure(Exception("Ocurrió un error"))
            }
        } catch (e: Exception) {
            StorageResult.Failure(e)
        }
    }

    override suspend fun delete(token: String?, product: ProductDTO): StorageResult<ProductDTO> {
        TODO("Not yet implemented")
    }
}