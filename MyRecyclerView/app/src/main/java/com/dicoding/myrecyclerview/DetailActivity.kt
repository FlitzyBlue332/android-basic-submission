package com.dicoding.myrecyclerview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_WAIFU = "extra_waifu"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        val waifu = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Waifu>(EXTRA_WAIFU, Waifu::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Waifu>(EXTRA_WAIFU)
        }

        if (waifu != null) {
            val tvObjectName:TextView = findViewById(R.id.tv_object_received_name)
            val tvObjectDescription:TextView = findViewById(R.id.tv_object_received_description)
            val tvObjectBirthday:TextView = findViewById(R.id.tv_object_received_birthday)
            val ivObject:ImageView = findViewById(R.id.imageView3)

            tvObjectName.text = waifu.name
            tvObjectDescription.text = waifu.description
            tvObjectBirthday.text = waifu.birthday
            Glide.with(this).load(waifu.photo).into(ivObject)
        }

    }
}