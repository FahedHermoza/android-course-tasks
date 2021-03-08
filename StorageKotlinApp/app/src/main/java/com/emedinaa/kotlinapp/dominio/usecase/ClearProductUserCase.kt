package com.emedinaa.kotlinapp.dominio.usecase

import com.emedinaa.kotlinapp.data.ProductDatabaseRepository
import com.emedinaa.kotlinapp.dominio.ProductRepository
import com.emedinaa.kotlinapp.dominio.model.Product

class ClearProductUserCase(private val productDatabaseRepository: ProductRepository) {

    suspend operator fun invoke() = run { productDatabaseRepository.deleteAllProduct()}
}