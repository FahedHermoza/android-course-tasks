package com.emedinaa.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import com.emedinaa.kotlinapp.model.Product

/**
 * @author Eduardo Medina
 */
class MainActivity : AppCompatActivity(),OnProductListener {

    private lateinit var productsFragment: ProductsFragment
    private lateinit var productDetailFragment: ProductDetailFragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentManager = supportFragmentManager
        productDetailFragment = fragmentManager.findFragmentById(R.id.fragmentProductDetail) as ProductDetailFragment
        productsFragment = fragmentManager.findFragmentById(R.id.fragmentProducts) as ProductsFragment
    }

    override fun selectedItemProduct(product: Product) {
        productDetailFragment.renderProduct(product)
    }

    override fun renderFirst(product: Product?) {
        product?.let { selectedItemProduct(it) }
    }
}