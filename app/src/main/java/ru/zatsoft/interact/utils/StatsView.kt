package ru.zatsoft.interact.utils

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import ru.zatsoft.interact.R

class StatsView @JvmOverloads constructor(context: Context,
                                          attrs: AttributeSet? = null) : View(context,attrs) {

    private var center = PointF(0F, 0F)
    private var radius = 0F
    private var linedWidth = 0

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
     }

    private var circleR = RectF(0F, 0F, 0F, 0F)
    private var circleL = RectF(0F, 0F, 0F, 0F)

    init {
        context.withStyledAttributes(attrs, R.styleable.StatsView) {
            paint.strokeWidth = 2F
            paint.setColor(Color.WHITE)
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        center = PointF(w / 2F, h / 2F)
//        radius = min(w, h) / 2F - linedWidth / 2F
        radius = w/ 2F - linedWidth / 2F
        circleR = RectF(
            center.x - radius,
            center.y - radius*2,
            (center.x + radius),
            center.y + radius*2
        )

        circleL = RectF(
            center.x -radius,
            center.y - radius*2,
            center.x + radius ,
            center.y + radius*2
        )
    }

    override fun onDraw(canvas: Canvas) {
        val startAngle1 = -45F
        val sweepAngle = 90F
        val startAngle2 = 135F
        canvas.drawArc(circleR, startAngle1, sweepAngle, false, paint)
        canvas.drawArc(circleL, startAngle2,sweepAngle, false, paint)
    }
}