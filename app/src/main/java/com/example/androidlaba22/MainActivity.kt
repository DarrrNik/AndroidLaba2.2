package com.example.androidlaba22

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidlaba22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), KitikMemeAdapter.OnClickListener {
    lateinit var binding: ActivityMainBinding
    private var adapter = KitikMemeAdapter(this)
    private val imageIdList = listOf(
        R.drawable.kitik_meme_1,
        R.drawable.kitik_meme_2,
        R.drawable.kitik_meme_3,
        R.drawable.kitik_meme_4,
        R.drawable.kitik_meme_5,
        R.drawable.kitik_meme_6,
        R.drawable.kitik_meme_7,
        R.drawable.kitik_meme_8,
        R.drawable.kitik_meme_9,
        R.drawable.kitik_meme_10
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = adapter
        for (i in 0 until imageIdList.size){
            val meme = KitikMeme(imageIdList[i])
            adapter.addMeme(meme)
        }
    }

    private var isGray = true
    override fun onLikeClick(position: Int) {
        val likeButton =
            binding.recView.findViewHolderForAdapterPosition(position)?.itemView?.findViewById<Button>(
                R.id.btnLike
            )
        if (likeButton != null && isGray)
            likeButton.setBackgroundColor(Color.RED)
        else if (likeButton != null)
            likeButton.setBackgroundColor(Color.GRAY)
        isGray = !isGray
    }
}