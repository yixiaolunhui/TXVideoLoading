package com.dl.txvideoloading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;

/**
 * 腾讯视频下拉刷新
 * Created by dalong  on 2017/9/27.
 */

public class TxVideoLoadingHeader extends LinearLayout implements RefreshHeader {

    private AnimationDrawable refreshAnimation;

    private SpinnerStyle mSpinnerStyle;

    public TxVideoLoadingHeader(Context context) {
        this(context, null);
    }

    public TxVideoLoadingHeader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TxVideoLoadingHeader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    private void init(Context context) {
        setMinimumHeight(DensityUtil.dp2px(50));
        setGravity(Gravity.CENTER);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.bg_loading);
        refreshAnimation = (AnimationDrawable) imageView.getDrawable();
        addView(imageView);
    }

    @Override
    public void onPullingDown(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @Override
    public void onReleasing(float percent, int offset, int headerHeight, int extendHeight) {

    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public SpinnerStyle getSpinnerStyle() {
        return mSpinnerStyle;
    }

    @Override
    public void setPrimaryColors(int... colors) {

    }

    @Override
    public void onInitialized(RefreshKernel kernel, int height, int extendHeight) {

    }

    @Override
    public void onHorizontalDrag(float percentX, int offsetX, int offsetMax) {

    }

    @Override
    public void onStartAnimator(RefreshLayout layout, int height, int extendHeight) {
        if (refreshAnimation != null)
            refreshAnimation.start();
    }

    @Override
    public int onFinish(RefreshLayout layout, boolean success) {
        if (refreshAnimation != null)
            refreshAnimation.stop();
        return 0;
    }

    @Override
    public boolean isSupportHorizontalDrag() {
        return false;
    }

    @Override
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {

    }

    public TxVideoLoadingHeader setSpinnerStyle(SpinnerStyle style) {
        this.mSpinnerStyle = style;
        return this;
    }
}
