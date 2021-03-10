package com.emedinaa.kotlinapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.emedinaa.kotlinapp.data.storage.ProductDataSource
import com.emedinaa.kotlinapp.domain.ProductRepository
import com.emedinaa.kotlinapp.domain.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductDatabaseRepository(private val productDataSource: ProductDataSource): ProductRepository {

    override fun getAllProducts(): LiveData<List<Product>> {
        return Transformations.map(productDataSource.notes()){
            Mapper.mapDBProductListToProductList(it)
        }
    }

    override suspend fun addProduct(product: Product) = withContext(Dispatchers.IO) {
        productDataSource.addNote(Mapper.productToDbProduct(product))
    }

    override suspend fun updateProduct(product: Product) = withContext(Dispatchers.IO){
        productDataSource.updateNote(Mapper.productToDbProduct(product))
    }

    override suspend fun deleteProduct(product: Product) = withContext(Dispatchers.IO){
        productDataSource.deleteNote(Mapper.productToDbProduct(product))
    }

    override suspend fun deleteAllProduct() = withContext(Dispatchers.IO){
        productDataSource.deleteAll()
    }
}