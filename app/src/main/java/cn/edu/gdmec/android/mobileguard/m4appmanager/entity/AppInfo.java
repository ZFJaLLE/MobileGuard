package cn.edu.gdmec.android.mobileguard.m4appmanager.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by 郭钦锋 on 2017/11/7.
 */

public class AppInfo {
    /**应用程序包名*/
    public String packageName;
    /**应用程序图标*/
    public Drawable icon;
    /**应用程序名称*/
    public String appName;
    /**应用程序路径*/
    public String apkPath;
    /**应用程序大小*/
    public Long appSize;
    /**是否收集储存*/
    public boolean isInRoom;
    /**是否是用户应用*/
    public boolean isUserApp;
    /**是否选中，默认都为Flase*/
    public boolean isSelected=false;
    public String  getAppLocation(boolean isInRoom){
        if(isInRoom){
            return "手机内存";
        }else{
            return "外部存储";
        }
    }
}
