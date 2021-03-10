package com.emedinaa.kotlinapp.data.storage

import com.emedinaa.kotlinapp.data.remote.ProductDTO
import com.emedinaa.kotlinapp.data.remote.UserDTO
import com.emedinaa.kotlinapp.domain.model.Product
import com.emedinaa.kotlinapp.domain.model.User

/**
 * @author Eduardo Medina
 * https://kotlinlang.org/docs/reference/collection-transformations.html
 * http://modelmapper.org/
 */
object Mapper {

    //TODO convertir entidad a DTO y DTO a entidad
    fun userDTOToUser(userDTO: UserDTO): User =
        User(userDTO.token ?: "", userDTO.email ?: "", userDTO.objectId ?: "")

    fun productDTOToProduct(productDTO: ProductDTO): Product = Product(
        productDTO.objectId?:"", productDTO.name?:"", productDTO.description?:"",
        productDTO.cost?:0.0, productDTO.logo?:"", productDTO.code?:""
    )
    /*
    fun dbProductToProduct(dbProduct: DBProduct):Product = Product(dbProduct.id?:0,dbProduct.name?:"",
        dbProduct.cost?:0.0, dbProduct.description?: "", dbProduct.logo?:0
    )

    fun productToDbProduct(product: Product):DBProduct = DBProduct(product.id,product.name,
         product.description,product.cost, product.logo)

    fun mapDBProductListToProductList(dbProductList:List<DBProduct>):List<Product>{
        return  dbProductList.map {
            Product(it.id?:0,it.name?:"",it.cost?:0.0,
                it.description?:"", it.logo?:0)
        }
    }*/

}