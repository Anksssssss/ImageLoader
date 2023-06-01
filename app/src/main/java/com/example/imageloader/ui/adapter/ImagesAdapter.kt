package com.example.imageloader.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageloader.databinding.ImageItemBinding
import com.example.imageloader.models.ImagesData

class ImagesAdapter(private val imageData : ArrayList<ImagesData>): RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ImageItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun getItemCount(): Int {
        return imageData.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load(imageData[position].url)
            .into(holder.binding.rvImageView)

        holder.binding.rvTextView.text = imageData[position].title
    }
}