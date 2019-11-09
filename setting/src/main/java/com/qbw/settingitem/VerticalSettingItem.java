package com.qbw.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author QBW
 * @date 2019/10/30
 */
public class VerticalSettingItem extends FrameLayout {

    private ImageView mIvTop;
    private TextView mTvTitle;
    private NumberView mNumberView;

    public VerticalSettingItem(Context context) {
        super(context);
        init(context, null);
    }

    public VerticalSettingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public VerticalSettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        LayoutInflater.from(context).inflate(R.layout.vertical_settingitem_layout, this, true);
        mIvTop = findViewById(R.id.iv_top);
        mTvTitle = findViewById(R.id.tv_title);
        mNumberView = findViewById(R.id.nv);

        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs,
                                                              R.styleable.VerticalSettingItem);
            Drawable topDrawable = array.getDrawable(R.styleable.VerticalSettingItem_vsi_top_image);
            String title = array.getString(R.styleable.VerticalSettingItem_vsi_title);
            int leftMargin = (int) array.getDimension(R.styleable.VerticalSettingItem_vsi_nv_margin_left,
                                                      0);
            int bottomMargin = (int) array.getDimension(R.styleable.VerticalSettingItem_vsi_nv_margin_bottom,
                                                        0);
            FrameLayout.LayoutParams params = (LayoutParams) mNumberView.getLayoutParams();
            params.leftMargin = leftMargin;
            params.bottomMargin = bottomMargin;
            mNumberView.setLayoutParams(params);

            mIvTop.setImageDrawable(topDrawable);
            int titleMarginTop = (int) array.getDimension(R.styleable.VerticalSettingItem_vsi_title_margin_top,
                                                          0);
            LinearLayout.LayoutParams titleParams = (LinearLayout.LayoutParams) mTvTitle.getLayoutParams();
            titleParams.topMargin = titleMarginTop;
            mTvTitle.setLayoutParams(titleParams);
            mTvTitle.setText(title);

            int titleColor = array.getColor(R.styleable.VerticalSettingItem_vsi_title_color,
                                            Color.parseColor("#212121"));
            mTvTitle.setTextColor(titleColor);
            int titleSize = (int) array.getDimension(R.styleable.VerticalSettingItem_vsi_title_size,
                                                     23);
            mTvTitle.setTextSize(TypedValue.COMPLEX_UNIT_PX, titleSize);
            int topImageSize = (int) array.getDimension(R.styleable.VerticalSettingItem_vsi_top_image_size,
                                                        -1);
            if (topImageSize >= 0) {
                FrameLayout.LayoutParams paramsImage = (LayoutParams) mIvTop.getLayoutParams();
                paramsImage.width = topImageSize;
                paramsImage.height = topImageSize;
                mIvTop.setLayoutParams(paramsImage);
            }

            array.recycle();
        }
    }

    public NumberView getNumberView() {
        return mNumberView;
    }
}
