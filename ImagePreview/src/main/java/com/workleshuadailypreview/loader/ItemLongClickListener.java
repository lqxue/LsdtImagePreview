package com.workleshuadailypreview.loader;

import android.app.Activity;
import android.widget.ImageView;

/**
 * 图片长按 回调
 */
public interface ItemLongClickListener {
    void onLongClick(String imageUrl, ImageView imageView, Activity activity);
}