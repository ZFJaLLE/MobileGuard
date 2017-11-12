package cn.edu.gdmec.android.mobileguard.m4appmanager.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.edu.gdmec.android.mobileguard.m4appmanager.entity.AppInfo;

/**
 * Created by 郭钦锋 on 2017/11/7.
 */

public class AppInfoParser {
    /**
     * 获取手机里的所有的应用程序
     * @pacam context 上下文
     * @return
     */
    public static List<AppInfo>getAppInfos(Context context){
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> packInfos= pm.getInstalledPackages(0);
        List<AppInfo>appinfos=new ArrayList<AppInfo>();
        for (PackageInfo packInfo:packInfos){
            AppInfo appinfo = new AppInfo();
            String  packname = packInfo.packageName;
            appinfo.packageName= packname;
            Drawable icon = packInfo.applicationInfo.loadIcon(pm);
            appinfo.icon = icon;
            String appname = packInfo.applicationInfo.loadLabel(pm).toString();
            appinfo.appName=appname;
            //应用程序apk包的的路径
            String apkpath = packInfo.applicationInfo.sourceDir;
            appinfo.apkPath= apkpath;
            File file =new File(apkpath);
            long appSize = file.length();
            appinfo.appSize=appSize;
            //应用程序安装的位置
            int flags = packInfo.applicationInfo.flags;//二进制映射，大bit-map
            if ((ApplicationInfo.FLAG_EXTERNAL_STORAGE & flags)!=0){
                //外部存储
                appinfo.isInRoom=false;

            }else {
                appinfo.isInRoom =true;
            }
            if((ApplicationInfo.FLAG_SYSTEM&flags)!=0){
                //系统应用
                appinfo.isUserApp=false;
            }else {
                appinfo.isUserApp=true;

            }
            appinfos.add(appinfo);
            appinfo=null;

        }
        return appinfos;
    }
}
