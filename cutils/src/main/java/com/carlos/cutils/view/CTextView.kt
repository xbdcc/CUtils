package com.carlos.cutils.view

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.carlos.cutils.R

/**
 * Github: https://github.com/xbdcc/.
 * Created by Carlos on 2020/2/26.
 */
open class CTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.CTextView, defStyleAttr, 0)
        val textViewLine = typedArray.getColor(R.styleable.CTextView_horizantal_line, Color.RED)
        typedArray.recycle()

        when (textViewLine) {
            0 -> paint.flags = Paint.STRIKE_THRU_TEXT_FLAG
            1 -> paint.flags = Paint.UNDERLINE_TEXT_FLAG
        }
        paint.isAntiAlias = true
    }


}

