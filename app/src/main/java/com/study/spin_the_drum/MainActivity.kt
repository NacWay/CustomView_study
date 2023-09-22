package com.study.spin_the_drum


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val customView: MyCustomView = findViewById(R.id.customView)
        val animanimate = customView.animate()
            .rotation((100 + Math.random() * 4000).toFloat())
            .setDuration(1200)
            animanimate.start()

    }
}