package com.qbw.settingitem;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author QBW
 * @date 2019/10/30
 */
public class HorizontalSettingItem extends FrameLayout {

    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvTitle;
    private TextView tvSubTitle;

    public HorizontalSettingItem(Context context) {
        super(context);
        init(context, null);
    }

    public HorizontalSettingItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public HorizontalSettingItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        LayoutInflater.from(context).inflate(R.layout.horizontal_settingitem_layout, this, true);
        ivLeft = findViewById(R.id.iv_left);
        ivRight = findViewById(R.id.iv_right);
        tvTitle = findViewById(R.id.tv_title);
        tvSubTitle = findViewById(R.id.tv_subtitle);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.HorizontalSettingItem);
        Drawable leftDrawable = array.getDrawable(R.styleable.HorizontalSettingItem_hsi_left_image);
        Drawable rightDrawable = array.getDrawable(R.styleable.HorizontalSettingItem_hsi_right_image);
        String title = array.getString(R.styleable.HorizontalSettingItem_hsi_title);
        String subtitle = array.getString(R.styleable.HorizontalSettingItem_hsi_subtitle);
        boolean showRightText = array.getBoolean(R.styleable.HorizontalSettingItem_hsi_show_right_text,
                                                 false);
        boolean showRightImage = array.getBoolean(R.styleable.HorizontalSettingItem_hsi_show_right_image,
                                                  false);

        ivRight.setVisibility(showRightImage ? View.VISIBLE : View.GONE);
        tvSubTitle.setVisibility(showRightText ? View.VISIBLE : View.GONE);
        ivLeft.setImageDrawable(leftDrawable);
        tvTitle.setText(title);
        tvSubTitle.setText(subtitle);
        ivRight.setImageDrawable(rightDrawable);


        array.recycle();
    }
}
