package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice2DrawCircleView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawCircle() 方法画圆
        //        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        val paint1 = Paint(Paint.ANTI_ALIAS_FLAG)
        paint1.color = Color.BLACK
        paint1.style = Paint.Style.FILL
        canvas.drawCircle(300f,300f,200f,paint1)

        val paint2 = Paint(Paint.ANTI_ALIAS_FLAG)
        paint2.color = Color.BLACK
        paint2.style = Paint.Style.STROKE
        canvas.drawCircle(750f,300f,200f,paint2)

        val paint3 = Paint(Paint.ANTI_ALIAS_FLAG)
        paint3.color = Color.BLUE
        paint3.style = Paint.Style.FILL
        canvas.drawCircle(300f,750f,200f,paint3)

        val paint4 = Paint(Paint.ANTI_ALIAS_FLAG)
        paint4.color = Color.BLACK
        paint4.style = Paint.Style.STROKE
        paint4.strokeWidth = 20f
        canvas.drawCircle(750f,750f,200f,paint4)

    }
}