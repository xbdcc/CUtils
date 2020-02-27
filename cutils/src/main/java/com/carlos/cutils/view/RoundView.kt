package com.carlos.cutils.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.carlos.cutils.R

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020/2/26.
 */
class RoundView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var color = Color.RED

    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.RoundView, defStyleAttr, 0)
        color = typedArray.getColor(R.styleable.RoundView_color, Color.RED)
        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = color
        canvas.drawCircle(width / 2f, height / 2f, height / 2f, paint)
    }

}

