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


class MainActivity : AppCompatActivity() {


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val image: ImageView = findViewById(R.id.imageView)
         val text: TextView = findViewById(R.id.sectorText)
         val resetBtn: Button = findViewById(R.id.reset)
         val customView: MyCustomView = findViewById(R.id.customView)

        //Крутите барабан!
        customView.setOnClickListener {

            image.setImageResource(Color.TRANSPARENT)  //обнуляем при новом нажатии
            text.text=""                               //обнуляем при новом нажатии

            val rotationCount: Float = (500 + Math.random() * 3000).toFloat()  //рандомное число кручения барабана
            var sectorPosition: Int = 0                                        //позиция после кручения

            //Крутим барабан
            animate(customView)
                .rotation(-rotationCount)
                .setDuration(4000)
                .start()

            Handler(Looper.getMainLooper()).postDelayed(        //немного замедляем поток чтобы показать результат кручения барабана после анимации
                {
                    //расчет позиции
                    sectorPosition =
                ((rotationCount.toDouble() / 360).toString().substringAfterLast('.')
                    .substring(0, 4).toDouble() / 10000 * 360).toInt()
                //устанавливаем текст
                text.text = findSelectedSector(sectorPosition, image)
                },4010
            )
        }

        //Кнопка reset
        resetBtn.setOnClickListener {
            image.setImageResource(Color.TRANSPARENT)
            text.text=""
        }


    }

    //Подарки в студию!
    private fun findSelectedSector(sectorPositin: Int, view: ImageView): String{
        when {
            sectorPositin in 0..51 -> return "Приз: Стиральная машина"
            sectorPositin in 52..102 -> return downloadImage("https://gratisography.com/wp-content/uploads/2023/09/gratisography-duck-doctor-free-stock-photo-1170x780.jpg", view)
            sectorPositin in 103..153 -> return "Приз: Шапка из оленя"
            sectorPositin in 154..204 -> return downloadImage("https://gratisography.com/wp-content/uploads/2023/09/gratisography-parrot-pirate-free-stock-photo-1170x780.jpg", view)
            sectorPositin in 205..255 -> return "Приз: Ведро кортошки"
            sectorPositin in 256..306 -> return downloadImage("https://gratisography.com/wp-content/uploads/2023/06/gratisography-flying-squirrel-free-stock-photo-1170x780.jpg", view)
            sectorPositin in 307..360 -> return "Главный приз: Автомобиль"
        }
        return "Барабан улетел"
    }

    //грузим изображение
    private fun downloadImage(URL: String, view: ImageView): String{
        Picasso.get()
            .load(URL)
            .placeholder(android.R.drawable.stat_notify_sync)
            .error(androidx.constraintlayout.widget.R.drawable.abc_btn_switch_to_on_mtrl_00012)
            .resize(300,200)
            .centerCrop()
            .into(view)
        return ""
    }


}