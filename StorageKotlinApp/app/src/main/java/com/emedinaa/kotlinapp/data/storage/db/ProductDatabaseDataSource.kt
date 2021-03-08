package com.emedinaa.kotlinapp.data.storage.db

import androidx.lifecycle.LiveData
import com.emedinaa.kotlinapp.data.storage.ProductDataSource


class ProductDatabaseDataSource(private val database: ProductDatabase): ProductDataSource {

    private val productDao = database.productDao()

    override fun notes(): LiveData<List<DBProduct>> = productDao.products()

    override suspend fun addNote(product: DBProduct) {
        productDao.addProduct(product)
    }

    override suspend fun updateNote(product: DBProduct){
        productDao.updateProduct(product)
    }

    override suspend fun deleteNote(product: DBProduct){
        productDao.deleteProduct(product)
    }

    override suspend fun deleteAll() {
        productDao.deleteAll()
    }
}
