package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View

class Practice8DrawArcView : View {
    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.style = Paint.Style.FILL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(200f, 100f, 800f, 500f, -110f, 100f, true, paint)
            canvas.drawArc(200f, 100f, 800f, 500f, 0f, 180f, false, paint)
            paint.style = Paint.Style.STROKE
            canvas.drawArc(200f, 100f, 800f, 500f, 180f, 270f, false, paint)
        }
    }
}