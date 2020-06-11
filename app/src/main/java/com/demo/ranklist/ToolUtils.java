package com.demo.ranklist;

import android.content.Context;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class ToolUtils {

    /**
     * 对字符加星号处理
     *
     * @param content
     * @return
     */
    public static String getStarString(String content) {
        String str;
        if (content == null || content.isEmpty()) {
            str = "**";
        } else if (content.length() == 1) {
            str = content + "*";
        } else {
            str = content.substring(0, 1) + "**";
        }
        return str;
    }


    /**
     * 设置头像
     *
     * @param context  上下文对象
     * @param cimgView 承载控件
     * @param PhotoUrl 照片URL
     */
    public static void setImagePhoto(Context context, CircleImageView cimgView, String PhotoUrl) {
        if (cimgView == null) return;
        if (PhotoUrl != null && !PhotoUrl.isEmpty()) {
            Glide.with(context)
                    .load(PhotoUrl)
                    .placeholder(R.drawable.new_user)
                    .error(R.drawable.new_user)
                    .into(cimgView);
        } else {
            cimgView.setImageResource(R.drawable.new_user);
        }
    }

}
