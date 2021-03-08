package com.emedinaa.kotlinapp.dominio.usecase

import com.emedinaa.kotlinapp.data.ProductDatabaseRepository
import com.emedinaa.kotlinapp.dominio.ProductRepository
import com.emedinaa.kotlinapp.dominio.model.Product

class DeleteProductUserCase(private val productDatabaseRepository: ProductRepository) {

    suspend operator fun invoke(product: Product) = run { productDatabaseRepository.deleteProduct(product)}

}