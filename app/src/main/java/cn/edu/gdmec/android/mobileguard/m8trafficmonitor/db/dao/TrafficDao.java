package cn.edu.gdmec.android.mobileguard.m8trafficmonitor.db.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import android.text.TextUtils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import cn.edu.gdmec.android.mobileguard.m8trafficmonitor.db.TrafficOpenHelper;

/**
 * Created by 郭钦锋 on 2017/11/28.
 */

public class TrafficDao {
    private TrafficOpenHelper helper;
    public  TrafficDao(Context context){
        helper  = new TrafficOpenHelper(context);
    }
    /**
     * 设置某一天的流量
     *
     */
    public  long getMoblieGPRS(String dataString){
        SQLiteDatabase db = helper.getReadableDatabase();
        long gprs = 0;
        Cursor cursor  = db.rawQuery("select gprs form traffic where date=?",
               new String[]{"datetime("+dataString+")"} );
        if (cursor.moveToNext()){
            String gprsStr = cursor.getString(0);
            if (!TextUtils.isEmpty(gprsStr))
                gprs = Long.parseLong(gprsStr);
        }else{
            gprs= -1;
        }
        return gprs;
    }
    /**
     * 添加今天
     */
    public  void insertTodayGPRS( long gprs){
        SQLiteDatabase db = helper.getReadableDatabase();
        Date dNow = new Date();
        Calendar calendar =  Calendar.getInstance();
        calendar.setTime(dNow);
        SimpleDateFormat sdf =  new  SimpleDateFormat("yyyy-MM-dd");
        String dataString  = sdf.format(dNow);
        ContentValues values = new ContentValues();
        values.put("gprs", String.valueOf(gprs));
        values.put("data", "datatime("+dataString+")");
        db.insert("tarffic",null, values);

    }
    /**
     * 修改今天的
     */
    public void UpdateTodayGPRS(long gprs){
        SQLiteDatabase db =  helper.getWritableDatabase();
        Date date = new Date();
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyy-MM-dd");
        String dataString = sdf.format(date);
        ContentValues values = new ContentValues();
        values.put("gprs",String.valueOf(gprs));
        values.put("date", "datetime("+dataString+")");
        db.update("traffic", values,"date= ?",
                new String[]{ "datetime("+ dataString+")"});


    }
}