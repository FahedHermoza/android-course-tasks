package com.emedinaa.kotlinapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emedinaa.kotlinapp.model.Product
import kotlinx.android.synthetic.main.fragment_product_detail.*

class ProductDetailFragment : Fragment() {
    private var listener: OnProductListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    fun renderProduct(product: Product) {

        tvName.text = product.name
        tvCost.text = "S./ ${product.cost.toString()}"
        tvDescription.text = product.description
        ivLogo.setImageResource(product.logo)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnProductListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnContactListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}