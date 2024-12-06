package com.example.androidlaba22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidlaba22.databinding.KitikMemeBinding

class KitikMemeAdapter(private val clickListener: OnClickListener): RecyclerView.Adapter<KitikMemeAdapter.KitikHolder>() {
    val memeList = ArrayList<KitikMeme>()
    interface OnClickListener {
        fun onLikeClick(position: Int)
    }

    class KitikHolder(private val clickListener: OnClickListener, item: View): RecyclerView.ViewHolder(item) {
        val binding = KitikMemeBinding.bind(item)
        fun bind(meme: KitikMeme) {
            binding.ktkMeme.setImageResource(meme.imageId)
            binding.btnLike.setOnClickListener {
                clickListener.onLikeClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kitik_meme, parent, false)
        return KitikHolder(clickListener, view)
    }

    override fun getItemCount(): Int {
        return memeList.size
    }

    override fun onBindViewHolder(holder: KitikHolder, position: Int) {
        holder.bind(memeList[position])
    }

    fun addMeme(meme: KitikMeme) {
        memeList.add(meme)
        notifyDataSetChanged()
    }
}