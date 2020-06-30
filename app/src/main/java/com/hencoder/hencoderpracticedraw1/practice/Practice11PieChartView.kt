package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.cos
import kotlin.math.sin


class Practice11PieChartView : View {

    private val deviceNames: List<String> //名字

    private val colorInteger: List<Int> //颜色

    private val precentInteger: List<Int> //百分比

    private val paintPie: Paint //画饼

    private val paintText: Paint //画字体

    private val paintLine: Paint //画线

    private val rectfCommon: RectF //不移动的部分

    private val rectfMove: RectF //移动的部分

    constructor(context: Context?) : super(context) {}

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        deviceNames = arrayListOf("Froyo", "GB", "ICS", "JB", "KitKat", "L", "M")
        colorInteger = arrayListOf(Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.LTGRAY, Color.YELLOW)
        precentInteger = arrayListOf(2, 8, 10, 50, 80, 160, 50)

        paintPie = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine.strokeWidth = 5f
        paintLine.color = Color.LTGRAY

        paintText = Paint(Paint.ANTI_ALIAS_FLAG)
        paintText.textSize = 30f
        paintText.color = Color.LTGRAY
        rectfCommon = RectF(-300f, -300f, 300f, 300f)
        rectfMove = RectF(-350f, -350f, 250f, 250f)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width
        val height = height
        canvas.translate(width / 2.toFloat(), height / 2.toFloat())
        var startAngle = 0f
        var sweepAngle = 0f
        for (i in deviceNames.indices) { //画饼图
            paintPie.strokeWidth = 10f
            paintPie.color = colorInteger[i]

            sweepAngle = precentInteger[i].toFloat()
            val deviceName = deviceNames[i]
            val textAngle = startAngle + precentInteger[i] / 2 //获取每个弧度中点，中点话延长线
            // 第6个饼会离开一段距离
            if (i == 5) {
                canvas.drawArc(rectfMove, startAngle + 1, sweepAngle - 1, true, paintPie)
            } else {
                canvas.drawArc(rectfCommon, startAngle + 1, sweepAngle - 1, true, paintPie)
            }
            //画斜线
            val startX = (cos(textAngle * Math.PI / 180) * 300.0).toFloat()
            val startY = (sin(textAngle * Math.PI / 180) * 300.0).toFloat()
            val endX = (cos(textAngle * Math.PI / 180) * 350.0).toFloat()
            val endY = (sin(textAngle * Math.PI / 180) * 350.0).toFloat()
            if (i == 5) {
                canvas.translate(-50f, -50f)
                canvas.drawLine(startX, startY, endX, endY, paintLine)
                canvas.translate(50f, 50f)
            } else {
                canvas.drawLine(startX, startY, endX, endY, paintLine)
            }
            //画直线
            if (endX < 0) {
                val textRect = getTextRect(deviceName, paintText)
                if (i == 5) {
                    canvas.translate(-50f, -50f)
                    canvas.drawLine(endX, endY, -400f, endY, paintLine)
                    canvas.drawText(deviceName, -420f - textRect.width(), endY, paintText)
                    canvas.translate(50f, 50f)
                } else {
                    canvas.drawLine(endX, endY, -400f, endY, paintLine)
                    canvas.drawText(deviceName, -420f - textRect.width(), endY, paintText)
                }
            } else {
                canvas.drawLine(endX, endY, 400f, endY, paintLine)
                canvas.drawText(deviceName, 400f, endY, paintText)
            }
            //            初始化每个饼的起始角度
            startAngle += sweepAngle
        }
    }

    //获取文字的宽高信息
    private fun getTextRect(deviceName: String, paint: Paint?): Rect {
        val mBound = Rect()
        paint?.getTextBounds(deviceName, 0, deviceName.length, mBound)
        return mBound
    }
}