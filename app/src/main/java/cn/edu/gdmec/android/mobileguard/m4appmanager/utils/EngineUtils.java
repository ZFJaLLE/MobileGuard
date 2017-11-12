package cn.edu.gdmec.android.mobileguard.m4appmanager.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.App;
import cn.edu.gdmec.android.mobileguard.m4appmanager.entity.AppInfo;

/**
 * Created by 郭钦锋 on 2017/11/7.
 */

public class EngineUtils {
    /**
     * 分享应用
     */
    public  static  void shareApplication(Context context, AppInfo appInfo){
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,"推荐你使用一款软件，名称叫"+ appInfo.appName
        + "下载路径：https://play.google.com/store/apps/details?id="
        + appInfo.packageName);
        context.startActivity(intent);
    }
    /**
     * 开启应用程序
     */
    public static void startApplication(Context context,AppInfo appInfo){
        PackageManager pm = context.getPackageManager();
        Intent intent =pm.getLaunchIntentForPackage(appInfo.packageName);
        if (intent!=null){
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"该应用没有启动界面",Toast.LENGTH_SHORT).show();
        }
    }
    /**
     * 开启时设置页面
     * @param context
     * @parcam appInfo
     */
    public  static void SettingAppDetail(Context context , AppInfo appInfo){
        Intent intent =new Intent();
        intent.setAction("android.settings.APPLICATINON_DETAILS_SETTINGS");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:"+appInfo.packageName));
        context.startActivity(intent);
    }
    /**卸载应用*/
    public  static  void unistallApplication(Context context,AppInfo appInfo){
        if (appInfo.isUserApp){
            Intent intent= new Intent();
            intent.setAction(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package"+appInfo.packageName));
            context.startActivity(intent);
        }else{
            Toast.makeText(context,"系统无法卸载",Toast.LENGTH_SHORT).show();
        }
    }
}
