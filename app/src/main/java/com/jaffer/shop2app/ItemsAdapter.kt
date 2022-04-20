package com.jaffer.shop2app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*

class ItemsAdapter (var items : ArrayList<Product>, val context: Context) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    class ItemViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each animal to
        val itemImage = view.image_view;
        val itemText = view.title;
        val itemDescription = view.description;

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.itemText?.text = items.get(position).product_type;
        holder.itemDescription?.text = items.get(position).title;

        Picasso.get().load(items.get(position).image.src).into(holder.itemImage)
    }


}