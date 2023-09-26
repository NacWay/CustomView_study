package com.study.spin_the_drum

import android.animation.Animator
import android.content.Context

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat


class MyCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paintRed = Paint()
    private val paintOrange = Paint()
    private val paintYellow = Paint()
    private val paintGreen = Paint()
    private val paintLightblue = Paint()
    private val paintBlue = Paint()
    private val paintPurple = Paint()
    private var resultListener: ((String)-> Unit)? = null

    init {
        // Устанавливаем цвет и стиль для Секторов
        //RED
        paintRed.color = Color.RED
        paintRed.style = Paint.Style.FILL
        //ORANGE
        paintOrange.color = ContextCompat.getColor(context, R.color.orange)
        paintOrange.style = Paint.Style.FILL
        //YELLOW
        paintYellow.color = Color.YELLOW
        paintYellow.style = Paint.Style.FILL
        //GREEN
        paintGreen.color = Color.GREEN
        paintGreen.style = Paint.Style.FILL
        //LightBlue
        paintLightblue.color = ContextCompat.getColor(context, R.color.lightBlue)
        paintLightblue.style = Paint.Style.FILL
        //BLUE
        paintBlue.color = Color.BLUE
        paintBlue.style = Paint.Style.FILL
        //PURPLE
        paintPurple.color = ContextCompat.getColor(context, R.color.purple)
        paintPurple.style = Paint.Style.FILL


            setOnClickListener {

                val rotationCount: Float =
                    (500 + Math.random() * 3000).toFloat()  //рандомное число кручения барабана
                var sectorPosition: Int =
                    0                                        //позиция после кручения

                //Крутим барабан
                val anim = it.animate().setListener(object : Animator.AnimatorListener
                   {
                    override fun onAnimationStart(animation: Animator) {
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        sectorPosition =
                            ((rotationCount.toDouble() / 360).toString().substringAfterLast('.')
                                .substring(0, 4).toDouble() / 10000 * 360).toInt()

                        resultListener?.invoke(findSelectedSector(sectorPosition))

                    }

                    override fun onAnimationCancel(animation: Animator) {
                    }

                    override fun onAnimationRepeat(animation: Animator) {
                    }
                })
                    .rotation(-rotationCount)
                    .setDuration(4000)
                    .start()
            }
    }



    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Рисуем Сектора
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            0f,
            51f,
            true,
            paintRed
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            51f,
            51f,
            true,
            paintOrange
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            102f,
            51f,
            true,
            paintYellow
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            153f,
            51f,
            true,
            paintGreen
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            204f,
            51f,
            true,
            paintLightblue
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            255f,
            51f,
            true,
            paintBlue
        )
        canvas.drawArc(
            RectF(10f, 10f, (width - 10).toFloat(), (height - 10).toFloat()),
            306f,
            54f,
            true,
            paintPurple
        )
    }

    //находим выповший сектор по позиции
    private fun findSelectedSector(sectorPositin: Int): String{
        when {
            sectorPositin in 0..51 -> return "Приз: Стиральная машина"
            sectorPositin in 52..102 -> return "ORANGE"
            sectorPositin in 103..153 -> return "Приз: Шапка из оленя"
            sectorPositin in 154..204 -> return "GREEN"
            sectorPositin in 205..255 -> return "Приз: Ведро кортошки"
            sectorPositin in 256..306 -> return "BLUE"
            sectorPositin in 307..360 -> return "Главный приз: Автомобиль"
        }
        return "Барабан улетел"
    }
    fun setResultListener(listener: (String) -> Unit)
    {
        resultListener =listener
    }
}