package com.dl.txvideoloading;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by dalong  on 2017/9/27.
 */

public class LoadingView extends LinearLayout {
    private AnimationDrawable refreshAnimation;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        setGravity(Gravity.CENTER);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        imageView.setImageResource(R.drawable.bg_loading);
        refreshAnimation = (AnimationDrawable) imageView.getDrawable();
        addView(imageView);
    }

    public void startAnim() {
        if (refreshAnimation != null) refreshAnimation.start();
    }

    public void stopAnim() {
        if (refreshAnimation != null) refreshAnimation.stop();
    }
}
