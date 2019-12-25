package com.carlos.cutils.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Carlos on 2019-12-16.
 */
public class CircleView extends View {

    Paint paint = new Paint();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);//        给画笔设置颜色
        // 绘制一个圆

        drawArcCircle1(canvas);

    }

    private void drawArcCircle1(Canvas canvas) {

        RectF oval = new RectF( 0, 0,getWidth() , getHeight() );
        canvas.drawArc(oval,20,140,false,paint);
    }

    private void drawArcCircle(Canvas canvas) {
        /**
          * 这是一个居中的圆
          */
        float x = (getWidth() - getHeight() / 2) / 2;
        float y = getHeight() / 4;

        RectF oval = new RectF( x, y,getWidth() - x, getHeight() - y);
        canvas.drawArc(oval,-90,120,false,paint);
    }
}
