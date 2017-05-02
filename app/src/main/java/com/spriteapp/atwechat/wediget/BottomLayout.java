package com.spriteapp.atwechat.wediget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.spriteapp.atwechat.R;

/**
 * Created by kuangxiaoguo on 2017/5/2.
 */

public class BottomLayout extends LinearLayout {

    private ImageView mImageView;
    private TextView mTextView;

    public BottomLayout(Context context) {
        this(context, null);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomLayout, defStyleAttr, 0);
        int iconId = typedArray.getResourceId(R.styleable.BottomLayout_top_icon, R.drawable.chat_selector);
        String text = typedArray.getString(R.styleable.BottomLayout_text);
        typedArray.recycle();
        mImageView.setImageResource(iconId);
        mTextView.setText(text);
    }

    private void initView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.bottom_layout, null);
        mImageView = (ImageView) view.findViewById(R.id.image_view);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        addView(view);
    }

    public void setSelectState() {
        mImageView.setSelected(true);
        mTextView.setSelected(true);
    }

    public void setUnSelectState() {
        mImageView.setSelected(false);
        mTextView.setSelected(false);
    }
}
