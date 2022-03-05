package com.workleshuadailypreview.enitity;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * @author lqx
 * Deprecated: 图片预览接口
 */
public interface IThumbViewInfo extends Serializable {

    /****
     * 图片地址
     * @return String
     * ****/
    String getUrl();

    /**
     * 记录坐标
     * @return Rect
     ***/
    ArrayList<Integer> getBounds();


    /**
     * 获取视频链接
     * ***/
    @Nullable
     String getVideoUrl();


}
