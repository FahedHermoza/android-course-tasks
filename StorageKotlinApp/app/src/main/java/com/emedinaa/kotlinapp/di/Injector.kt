package com.emedinaa.kotlinapp.di

import android.content.Context
import com.emedinaa.kotlinapp.data.ProductDatabaseRepository
import com.emedinaa.kotlinapp.data.storage.ProductDataSource
import com.emedinaa.kotlinapp.data.storage.db.ProductDatabase
import com.emedinaa.kotlinapp.data.storage.db.ProductDatabaseDataSource
import com.emedinaa.kotlinapp.dominio.ProductRepository

/**
 * @author Eduardo Medina
 */
object Injector {

    //Room
    private lateinit var productDataSource: ProductDataSource
    private lateinit var productRepository: ProductRepository

    fun setup(context:Context) {
        ProductDatabase.getInstance(context)?.let {
            productDataSource = ProductDatabaseDataSource(it)
            productRepository = ProductDatabaseRepository(productDataSource)
        }
    }

    fun provideProductRepository(): ProductRepository = productRepository

    fun destroy() {

    }
}