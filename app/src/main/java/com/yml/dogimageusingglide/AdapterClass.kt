package com.yml.dogimageusingglide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterClass(private val context: Context,
                   private val dogImageList: List<String>): RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogImage: ImageView = itemView.findViewById(R.id.iv_dog)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(dogImageList[position])
            .into(holder.dogImage)
    }

    override fun getItemCount(): Int = dogImageList.size
}