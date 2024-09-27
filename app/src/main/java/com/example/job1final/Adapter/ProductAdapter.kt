package com.example.job1final.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job1final.Product
import com.example.job1final.R

class ProductAdapter(private val products:List<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>()  {

    inner class ProductViewHolder(iteView: View):RecyclerView.ViewHolder(iteView) {

        val productId = iteView.findViewById<TextView>(R.id.Id)
        val productName = iteView.findViewById<TextView>(R.id.nameTxt)
        val productPrice = iteView.findViewById<TextView>(R.id.priceTxt)
        val productDesc = iteView.findViewById<TextView>(R.id.desId)
        val productImg = iteView.findViewById<ImageView>(R.id.productImage)



        fun bind(product: Product){
            productId.text= product.id.toString()
            productName.text = product.title
            productPrice.text = "$${product.price}"
            productDesc.text = product.description

            Glide.with(itemView).load(product.images[0])
                .into(productImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
}