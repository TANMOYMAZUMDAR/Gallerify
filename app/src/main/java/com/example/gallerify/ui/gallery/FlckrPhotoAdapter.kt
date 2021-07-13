package com.example.gallerify.ui.gallery

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.gallerify.R
import com.example.gallerify.data.FlckrPhotos
import com.example.gallerify.data.images
import com.example.gallerify.databinding.ItemFlckerPhotoBinding

class FlckrPhotoAdapter(private val listener: OnItemClickListener) :
    PagingDataAdapter<images, FlckrPhotoAdapter.PhotoViewHolder>(PHOTO_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
           ItemFlckerPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    inner class PhotoViewHolder(private val binding: ItemFlckerPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    if (item != null) {
                        listener.onItemClick(item)
                    }
                }
            }
        }

        fun bind(photo: images) {
            binding.apply {
                Glide.with(itemView)
                    .load(photo.url_s)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(imageView)

                textViewUserName.text = photo.owner
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(photo: images)
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<images>() {
            override fun areItemsTheSame(oldItem: images, newItem: images) =
                oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: images, newItem: images) =
                oldItem == newItem
        }
    }
}