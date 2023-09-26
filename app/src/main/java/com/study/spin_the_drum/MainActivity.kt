package com.study.spin_the_drum

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat.animate
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {


    @SuppressLint("ResourceType", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image: ImageView = findViewById(R.id.imageView)
        val text: TextView = findViewById(R.id.sectorText)
        val resetBtn: Button = findViewById(R.id.reset)
        val customView: MyCustomView = findViewById(R.id.customView)
        //
        //
        //как тут подождать, пока выполнится анимация и выберется сектор? Только после этого продолжить
        //
        //
        if (customView.clickListener != null) {
            text.text = "null"
            //Кнопка reset
            resetBtn.setOnClickListener {
                image.setImageResource(Color.TRANSPARENT)
                text.text = ""
            }
        }
    }



    private fun downloadImage(URL: String, view: ImageView): String {
        Picasso.get()
            .load(URL)
            .placeholder(android.R.drawable.stat_notify_sync)
            .error(androidx.constraintlayout.widget.R.drawable.abc_btn_switch_to_on_mtrl_00012)
            .resize(300, 200)
            .centerCrop()
            .into(view)
        return ""
    }
}

// https://gratisography.com/wp-content/uploads/2023/09/gratisography-duck-doctor-free-stock-photo-1170x780.jpg
// https://gratisography.com/wp-content/uploads/2023/09/gratisography-parrot-pirate-free-stock-photo-1170x780.jpg
// https://gratisography.com/wp-content/uploads/2023/06/gratisography-flying-squirrel-free-stock-photo-1170x780.jpg
