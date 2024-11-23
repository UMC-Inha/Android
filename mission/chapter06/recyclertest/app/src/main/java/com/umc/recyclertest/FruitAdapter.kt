package com.umc.recyclertest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DecimalFormat

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {
    inner class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fruitImage : ImageView = itemView.findViewById(R.id.fruitImage)
        val fruitName : TextView = itemView.findViewById(R.id.fruitName)
        val fruitPrice: TextView = itemView.findViewById(R.id.fruitPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(itemView)
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageRes)
        holder.fruitName.text = fruit.name
        holder.fruitPrice.text = DecimalFormat("#,###").format(fruit.price) + "원"
    }
}