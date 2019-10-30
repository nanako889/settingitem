package com.qbw.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author QBW
 * @date 2019/10/30
 */
public class NumberView extends FrameLayout {
    private int number;
    private TextView tvNumber;
    private Drawable bgCircle;
    private Drawable bgRect;

    private int mPadding;
    private int mPaddingH3;
    private int mPaddingV3;

    public NumberView(Context context) {
        super(context);
        init(context, null);
    }

    public NumberView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public NumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberView);
        float textSize = typedArray.getDimension(R.styleable.NumberView_nv_textSize, 0);
        bgCircle = typedArray.getDrawable(R.styleable.NumberView_nv_circleBg);
        bgRect = typedArray.getDrawable(R.styleable.NumberView_nv_rectBg);
        mPadding = (int) typedArray.getDimension(R.styleable.NumberView_nv_paddding, 0);
        mPaddingH3 = (int) typedArray.getDimension(R.styleable.NumberView_nv_padding_3digit_horizontal,
                                                   0);
        mPaddingV3 = (int) typedArray.getDimension(R.styleable.NumberView_nv_padding_3digit_vertical,
                                                   0);
        typedArray.recycle();


        tvNumber = new TextView(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                                                                       FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        tvNumber.setGravity(Gravity.CENTER);
        tvNumber.setLayoutParams(params);
        tvNumber.setTextColor(context.getResources().getColor(android.R.color.white));
        tvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        addView(tvNumber);
    }

    public void setNumber(int number) {
        this.number = number;
        setVisibility(number > 0 ? View.VISIBLE : View.GONE);
        tvNumber.setText(String.valueOf(number));
        if (number <= 99) {
            tvNumber.setPadding(mPadding, mPadding, mPadding, mPadding);
            tvNumber.setBackground(bgRect);
        } else {
            tvNumber.setPadding(mPaddingH3, mPaddingV3, mPaddingH3, mPaddingV3);
            tvNumber.setBackground(bgRect);
        }
    }
}
