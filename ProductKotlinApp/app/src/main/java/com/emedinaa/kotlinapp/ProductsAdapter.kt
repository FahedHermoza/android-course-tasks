package com.emedinaa.kotlinapp

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.emedinaa.kotlinapp.model.Product
import com.emedinaa.kotlinapp.utils.inflate
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter(private var products:List<Product>,
                      val itemAction: (item: Product) -> Unit)
    :RecyclerView.Adapter<ProductsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            parent.inflate(R.layout.item_product)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //render
        holder.bind(products[position])
    }

    override fun getItemCount(): Int {
        return products.size
    }

    fun update(data:List<Product>){
        products = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view){

        private val textViewName:TextView = view.tvName
        private val imageView:ImageView = view.ivLogo
        private val textViewCost:TextView = view.tvCost

        fun bind(product: Product){
            textViewName.text = product.name
            textViewCost.text = "S./ ${product.cost}"
            imageView.setImageResource(product.logo)

            view.setOnClickListener {
                itemAction(product)
            }
        }
    }
}