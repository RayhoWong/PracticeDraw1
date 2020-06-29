package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice6DrawLineView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawLine() 方法画直线
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 5f
        canvas.drawLine(200f,200f,500f,500f,paint)
    }
}