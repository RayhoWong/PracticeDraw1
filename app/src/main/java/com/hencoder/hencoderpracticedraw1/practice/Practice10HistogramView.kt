package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice10HistogramView(context: Context?, attributeSet: AttributeSet) : View(context, attributeSet) {

    private val paintTv: Paint
    private val paintRe: Paint
    private val paintLine: Paint
    private val linePoints: FloatArray


    init {
        paintTv = Paint(Paint.ANTI_ALIAS_FLAG)
        paintRe = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
        linePoints = floatArrayOf(120f,20f,120f,500f,120f,500f,1000f,500f)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //        综合练习
        //        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        //坐标系
        paintLine.style = Paint.Style.STROKE
        paintLine.strokeWidth = 2f
        paintLine.color = Color.WHITE
        canvas.drawLines(linePoints,paintLine)

        //矩形
        paintRe.style = Paint.Style.FILL
        paintRe.color = Color.GREEN
        canvas.drawRect(130f,490f,230f,500f,paintRe)
        canvas.drawRect(250f,450f,350f,500f,paintRe)
        canvas.drawRect(370f,450f,470f,500f,paintRe)
        canvas.drawRect(490f,250f,590f,500f,paintRe)
        canvas.drawRect(610f,125f,710f,500f,paintRe)
        canvas.drawRect(730f,75f,830f,500f,paintRe)
        canvas.drawRect(850f,225f,950f,500f,paintRe)

        //文字
        paintTv.textSize = 30f
        paintTv.color = Color.WHITE
        canvas.drawText("直方图",120f + (950f - 120f)/2,800f,paintTv)
        canvas.drawText("Froyo",180f,550f,paintTv)
        canvas.drawText("GB",300f,550f,paintTv)
        canvas.drawText("ICS",420f,550f,paintTv)
        canvas.drawText("JB",540f,550f,paintTv)
        canvas.drawText("KitKat",660f,550f,paintTv)
        canvas.drawText("L",780f,550f,paintTv)
        canvas.drawText("M",900f,550f,paintTv)
    }
}