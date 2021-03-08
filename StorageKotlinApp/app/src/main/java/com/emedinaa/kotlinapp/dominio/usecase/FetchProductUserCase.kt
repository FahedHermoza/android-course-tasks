package com.emedinaa.kotlinapp.dominio.usecase

import com.emedinaa.kotlinapp.dominio.ProductRepository

class FetchProductUserCase(private val productDatabaseRepository: ProductRepository) {

    operator fun invoke() = run { productDatabaseRepository.getAllProducts() }
}