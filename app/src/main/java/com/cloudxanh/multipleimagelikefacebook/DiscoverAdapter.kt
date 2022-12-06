package com.cloudxanh.multipleimagelikefacebook

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.cloudxanh.multipleimagelikefacebook.model.NewFeed
import com.cloudxanh.multipleimagelikefacebook.utils.Utility.formatNumberAsNumberFormat
import com.cloudxanh.multipleimagelikefacebook.utils.gone
import com.cloudxanh.multipleimagelikefacebook.utils.loadImage
import com.cloudxanh.multipleimagelikefacebook.utils.visible
import com.cloudxanh.multipleimagelikefacebook.databinding.ItemNewFeedBinding

/**
 * Created by sonpxp on 4/17/2022.
 * Email: sonmob202@gmail.com
 */

class DiscoverAdapter(private val listener: OnItemClickListener) :
    ListAdapter<NewFeed, DiscoverAdapter.ViewHolder>(DiffCallback) {

    interface OnItemClickListener {
        fun onReactItemClick()
        fun onCommentItemClick()
        fun onSharedItemClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ItemNewFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ClickableViewAccessibility")
        fun bind(newFeed: NewFeed) = with(binding) {

            val options: RequestOptions = RequestOptions()
                .centerCrop()
                .placeholder(R.drawable.ic_laugh)
                .error(R.drawable.ic_laugh)

            newFeed.apply {
                imgAvatar.loadImage(avatar) { options }
                tvName.text = userName
                tvTime.text = timeTemp
                tvStatus.text = postDesc
                tvReactCount.text = formatNumberAsNumberFormat(reactCount)
                tvCommentCount.text = formatNumberAsNumberFormat(commentCount)

                if (verifiedBadge) ivTick.visible() else ivTick.gone()

               /* likeButtonTwo.setOnClickListener {
                    listener.onReactItemClick()
                }*/

                likeButtonTwo.setOnClickListener {
                }

                layoutComment.setOnClickListener {
                    listener.onCommentItemClick()
                }
                layoutShared.setOnClickListener {
                    listener.onSharedItemClick()
                }

               /* val adapter = MediaPreviewAdapter()
                adapter.submitList(media)
                // mediaGridView.layoutManager = LinearLayoutManager(binding.root.context)
                mediaGridView.adapter = adapter*/
            }
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<NewFeed>() {

            override fun areItemsTheSame(oldItem: NewFeed, newItem: NewFeed): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(
                oldItem: NewFeed,
                newItem: NewFeed
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


}
