package com.study.spin_the_drum

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat

@Suppress("UNREACHABLE_CODE")
class MyCustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paintRed = Paint()
    private val paintOrange = Paint()
    private val paintYellow = Paint()
    private val paintGreen = Paint()
    private val paintLightblue = Paint()
    private val paintBlue = Paint()
    private val paintPurple = Paint()

    @SuppressLint("ResourceAsColor", "DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

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



        // Рисуем Сектора
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 0f, 51f, true, paintRed)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 51f, 51f, true, paintOrange)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 102f, 51f, true, paintYellow)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 153f, 51f, true, paintGreen)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 204f, 51f, true, paintLightblue)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 255f, 51f, true, paintBlue)
        canvas.drawArc(RectF(10f, 10f, (width-10).toFloat(), (height-10).toFloat()), 306f, 54f, true, paintPurple)


    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {

            MotionEvent.ACTION_DOWN -> {
                animate()
                    .rotation((1500+Math.random()*3000).toFloat())
                    .setDuration(4000)
                    .start()


                return false
            }

            MotionEvent.ACTION_MOVE -> {
                // обработка перемещения пальца по экрану
                return true
            }

            MotionEvent.ACTION_UP -> {
                // обработка отпускания пальца от экрана
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}