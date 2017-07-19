package com.floatwindowspremess;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class TextImage extends ImageView {

    private Paint paint;

    private boolean text2_show;
    private String text1;
    private String text2;
    private int text1color;
    private int text2color;
    private boolean text1_show;

    public TextImage(Context context) {
        super(context);
    }

    public TextImage(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextImage);
        text1_show = typedArray.getBoolean(R.styleable.TextImage_text1, false);
        text2_show = typedArray.getBoolean(R.styleable.TextImage_text2, false);
        text1 = typedArray.getString(R.styleable.TextImage_settext1);
        text2 = typedArray.getString(R.styleable.TextImage_settext2);
        text1color = typedArray.getColor(R.styleable.TextImage_settext1color, Color.BLACK);
        text2color = typedArray.getColor(R.styleable.TextImage_settxtx2color, Color.BLACK);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public TextImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthsize = MeasureSpec.getSize(widthMeasureSpec);
        int hightsize = MeasureSpec.getSize(heightMeasureSpec);
        int width = getWidth();
        int height = getHeight();
        Log.e("控件高宽","width:"+width+"  widthsize:"+widthsize+"  height:"+height+"  hightsize:"+hightsize);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        paint.setTextSize(50);
        if (text1_show){
            paint.setColor(text1color);
            canvas.drawText(text1,(width-text1.length()*50)/2,(height-50)/2-50,paint);
        }
        if (text2_show){
            paint.setColor(text2color);
            canvas.drawText(text2,(width-text1.length()*50)/2,(height-50)/2,paint);
        }



    }
}
