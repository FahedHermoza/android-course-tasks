package com.emedinaa.kotlinapp

import com.emedinaa.kotlinapp.model.Product

/**
 * @author Eduardo Medina
 */
interface OnProductListener {

    fun selectedItemProduct(product: Product)
    fun renderFirst(product: Product?)
}