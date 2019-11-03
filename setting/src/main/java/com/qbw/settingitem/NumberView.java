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
    private int mNumber;
    private TextView mTvNumber;
    private Drawable mBgCircle;
    private Drawable mBgRect;

    private int mPadding;
    private int mPaddingH3;
    private int mPaddingV3;

    private boolean mShowPlusWhen3Dight;
    private boolean mChangeBgWhen3Dight;

    private float mTextSize;
    private float mTextSize2;
    private float mTextSize3;

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
        int textColor = context.getResources().getColor(android.R.color.black);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NumberView);
            mTextSize = typedArray.getDimension(R.styleable.NumberView_nv_textSize, 20);
            mTextSize2 = typedArray.getDimension(R.styleable.NumberView_nv_textSize_2dight, 20);
            mTextSize3 = typedArray.getDimension(R.styleable.NumberView_nv_textSize_3digit, 20);
            mBgCircle = typedArray.getDrawable(R.styleable.NumberView_nv_circleBg);
            mBgRect = typedArray.getDrawable(R.styleable.NumberView_nv_rectBg);
            mPadding = (int) typedArray.getDimension(R.styleable.NumberView_nv_paddding, 0);
            mPaddingH3 = (int) typedArray.getDimension(R.styleable.NumberView_nv_padding_3digit_horizontal,
                                                       0);
            mPaddingV3 = (int) typedArray.getDimension(R.styleable.NumberView_nv_padding_3digit_vertical,
                                                       0);
            mShowPlusWhen3Dight = typedArray.getBoolean(R.styleable.NumberView_nv_show_plus_when_3dight,
                                                        true);
            mChangeBgWhen3Dight = typedArray.getBoolean(R.styleable.NumberView_nv_change_bg_when_3dight,
                                                        false);
            textColor = typedArray.getColor(R.styleable.NumberView_nv_textColor, textColor);

            typedArray.recycle();
        }


        mTvNumber = new TextView(context);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                                                                       FrameLayout.LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER;
        mTvNumber.setGravity(Gravity.CENTER);
        mTvNumber.setLayoutParams(params);
        mTvNumber.setTextColor(textColor);
        mTvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        addView(mTvNumber);
    }

    public void setNumber(int number) {
        mNumber = number;
        setVisibility(number > 0 ? View.VISIBLE : View.GONE);
        String numberStr = String.valueOf(number);

        if (number < 100) {
            mTvNumber.setPadding(mPadding, mPadding, mPadding, mPadding);
            mTvNumber.setBackground(mBgCircle);
        } else {
            if (mShowPlusWhen3Dight) {
                numberStr = "99+";
            }
            mTvNumber.setPadding(mPaddingH3, mPaddingV3, mPaddingH3, mPaddingV3);
            if (mChangeBgWhen3Dight) {
                mTvNumber.setBackground(mBgRect);
            }
        }
        if (number < 10) {
            mTvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize);
        } else if (number < 100) {
            mTvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize2);
        } else {
            mTvNumber.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextSize3);
        }
        mTvNumber.setText(numberStr);
    }

    public void setmBgCircle(Drawable mBgCircle) {
        this.mBgCircle = mBgCircle;
    }

    public void setmBgRect(Drawable mBgRect) {
        this.mBgRect = mBgRect;
    }

    public void setPadding(int padding) {
        mPadding = padding;
    }

    public void setPaddingH3(int paddingH3) {
        mPaddingH3 = paddingH3;
    }

    public void setPaddingV3(int paddingV3) {
        mPaddingV3 = paddingV3;
    }

    public void setShowPlusWhen3Dight(boolean showPlusWhen3Dight) {
        mShowPlusWhen3Dight = showPlusWhen3Dight;
    }

    public void setChangeBgWhen3Dight(boolean changeBgWhen3Dight) {
        mChangeBgWhen3Dight = changeBgWhen3Dight;
    }

    public void setTextSize(float textSize) {
        mTextSize = textSize;
    }

    public void setTextSize2(float textSize2) {
        mTextSize2 = textSize2;
    }

    public void setTextSize3(float textSize3) {
        mTextSize3 = textSize3;
    }
    
    public void setTextColor(int color) {
        mTvNumber.setTextColor(color);
    }
}
