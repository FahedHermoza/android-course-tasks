package com.emedinaa.kotlinapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.emedinaa.kotlinapp.model.Data
import com.emedinaa.kotlinapp.model.Product
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment : Fragment() {
    private var listener: OnProductListener? = null
    private lateinit var adapter: ProductsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter.update(Data.getProduct())
        var firstProduct = Data.getProduct()[0]
        listener?.renderFirst(firstProduct)

    }
    private fun setupView() {
        adapter = ProductsAdapter(emptyList(), onItemAction())
        rvProducts.adapter = adapter

    }

    private fun onItemAction(): (item: Product) -> Unit {
        return {
            //goToDetailView(it)
            listener?.selectedItemProduct(it)
        }
    }
/*
    private fun goToDetailView(item: Product) {
        val bundle = Bundle().apply {
            putString("name_category", item.name)
        }
        val intent = Intent(context, ProductDetailActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }*/

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnProductListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnProductListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}