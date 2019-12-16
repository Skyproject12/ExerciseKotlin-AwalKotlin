package com.example.awalkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.awalkotlin.RecyclerViewAdapter.ViewHolder
import com.squareup.picasso.Picasso

// mendefinisikan variable dibutuhkan
class RecyclerViewAdapter(
    private val context: Context,
    private val item: List<Item>,
    private val listener: (Item) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>() {
    // mendefinisikan holder dari suatu recylerview
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val name = view.findViewById<TextView>(R.id.name);
        private val image = view.findViewById<ImageView>(R.id.image);
        // mendefinisikan onclick
        fun bindItem(items: Item, listener:(Item)->Unit) {
            name.text = items.name
            items.image?.let { Picasso.get().load(it).fit().into(image) }
            // setOnclick recyclerview
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

    // mendefinisikan layout item dalam recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))


    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(item[position], listener)
    }

}