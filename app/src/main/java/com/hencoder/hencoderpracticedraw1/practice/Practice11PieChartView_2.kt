package com.hencoder.hencoderpracticedraw1.practice

import android.content.Context
import android.graphics.*
import android.support.annotation.Nullable
import android.util.AttributeSet
import android.view.View
import java.util.*
import kotlin.math.cos
import kotlin.math.sin


class Practice11PieChartView_2 : View {

    private val names: List<String> //版本名
    private val precents: List<Int> //每个版本所占的角度（共360度）
    private val colors: List<Int>
    private val paintArc: Paint
    private val paintText: Paint
    private val paintLine: Paint

    private val commonRect: RectF //不移动的部分
    private val moveRect: RectF //移动的部分


    constructor(context: Context?) : super(context) {}

    constructor(context: Context?, @Nullable attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context?, @Nullable attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    init {
        names = arrayListOf("Froyo", "GingerBread", "lce Cream Sandwich", "Jelly Bean", "KitKat", "Lollipop", "Marshmallow")
        colors = arrayListOf(Color.parseColor("#FF9933"),Color.parseColor("#663399"),Color.parseColor("#663399"),Color.parseColor("#808080"),
                Color.parseColor("#009933"),Color.parseColor("#00CCFF"),Color.parseColor("#FF0000"))
        precents = arrayListOf(2,10,10,70,88,120,60)
        paintArc = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine = Paint(Paint.ANTI_ALIAS_FLAG)
        paintLine.color = Color.WHITE
        paintLine.strokeWidth = 5f
        paintText = Paint(Paint.ANTI_ALIAS_FLAG)
        paintText.textSize = 30f
        paintText.color = Color.LTGRAY

        commonRect = RectF(-300f,-300f,300f,300f)
        moveRect = RectF(-315f,-315f,285f,285f)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //把画布移动屏幕的中心
        canvas.translate((width/2).toFloat(), (height/2).toFloat())
        var startAngle = 0f
        for (i in names.indices){
            //画扇形
            paintArc.color = colors[i]
            if (i == 5){
                //绘制偏移扇形的部分
                canvas.translate(-15f,-15f)
                canvas.drawArc(moveRect,startAngle + 2, precents[i].toFloat() - 2,true,paintArc)
                canvas.translate(15f,15f)
            }else{
                canvas.drawArc(commonRect,startAngle + 2, precents[i].toFloat() - 2,true,paintArc)
            }
            //画斜线
            val textAngle = startAngle + 2 + (precents[i] -2 ) / 2 //获取每个弧度中点，中点画延长线
            //关于为什么使用sin和cos？ 参考https://www.jianshu.com/p/556075102198
            //注意：Math.toRadians(textAngle.toDouble()) 等同于 Math.PI*textAngle / 180
            val startX = (cos(Math.toRadians(textAngle.toDouble())) * 300).toFloat()
            val startY = (sin(Math.toRadians(textAngle.toDouble())) * 300).toFloat()
            val endX = (cos(Math.toRadians(textAngle.toDouble())) * 350).toFloat()
            val endY = (sin(Math.toRadians(textAngle.toDouble())) * 350).toFloat()
            if (i == 5){
                //绘制偏移扇形的部分
                canvas.translate(-30f,-30f)
                canvas.drawLine(startX,startY,endX,endY,paintLine)
                canvas.translate(30f,30f)
            }else{
                canvas.drawLine(startX,startY,endX,endY,paintLine)
            }
            //画直线和文字
            if (endX < 0){
                val textRect = getTextBounds(names[i],paintText)
                //endX小于0 表示点在三四象限，反之在一二象限
                if (i == 5){
                    //绘制偏移扇形的部分
                    canvas.translate(-30f,-30f)
                    canvas.drawLine(endX,endY,-380f,endY,paintLine)
                    canvas.drawText(names[i],-400f - textRect.width(),endY,paintText)
                    canvas.translate(30f,30f)
                }else{
                    canvas.drawLine(endX,endY,-380f,endY,paintLine)
                    canvas.drawText(names[i],-400f - textRect.width(),endY,paintText)
                }
            }else{
                canvas.drawLine(endX,endY,380f,endY,paintLine)
                canvas.drawText(names[i],380f,endY,paintText)
            }
            startAngle += precents[i]
        }
        canvas.drawText("饼图",-10f,350f,paintText)
    }

    //获取显示文字的宽高信息
    private fun getTextBounds(name: String,paint: Paint): Rect{
        val bounds = Rect()
        paint.getTextBounds(name,0,name.length,bounds)
        return bounds
    }


}