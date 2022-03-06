package com.workleshuadailypreview.enitity

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.workleshuadailypreview.R
import com.workleshuadailypreview.loader.IZoomMediaLoader
import com.workleshuadailypreview.loader.MySimpleTarget

/**
 * Created by lqx on 2022/1/22.
 * 图片预览相关
 */
class TestImageLoader : IZoomMediaLoader {
    override fun displayImage(
        context: Fragment,
        path: String,
        imageView: ImageView,
        simpleTarget: MySimpleTarget
    ) {
        Glide.with(context)
            .asBitmap()
            .error(R.drawable.image_preview_glide_defult_ic)
            .load(path)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onLoadFailed(null)
                    return false
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onResourceReady()
                    return false
                }
            }).into(imageView)
    }

    override fun displayGifImage(
        context: Fragment,
        path: String,
        imageView: ImageView,
        simpleTarget: MySimpleTarget
    ) {
        Glide.with(context)
            .asGif()
            .error(R.drawable.image_preview_glide_defult_ic)
            .load(path)
            .dontAnimate() //去掉显示动画
            .listener(object : RequestListener<GifDrawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onLoadFailed(null)
                    return false
                }

                override fun onResourceReady(
                    resource: GifDrawable?,
                    model: Any?,
                    target: Target<GifDrawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    simpleTarget.onResourceReady()
                    return false
                }
            }).into(imageView)
    }

    override fun onStop(context: Fragment) {
        Glide.with(context).onStop()
    }

    override fun clearMemory(c: Context) {
        Glide.get(c).clearMemory()
    }
}