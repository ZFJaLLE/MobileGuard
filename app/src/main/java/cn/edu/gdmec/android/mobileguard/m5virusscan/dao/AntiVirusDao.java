package cn.edu.gdmec.android.mobileguard.m5virusscan.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 郭钦锋 on 2017/11/13.
 */

public class AntiVirusDao {
    /**
     * 检查某个md5的病毒
     *
     * @pacam md5
     * @return null 代表扫描安全
     */
    private static Context context;
    private static String dbname;

    public AntiVirusDao(Context context) {
        this.context = context;
        dbname = "data/data/" + context.getPackageName() + "/files/antivirus.db";
    }

    //使用apk文件的md5值匹配病毒数据库
    public String checkVirus(String md5) {
        String desc = null;
        //打开数据库
        SQLiteDatabase db = SQLiteDatabase.openDatabase(
                dbname, null, SQLiteDatabase.OPEN_READONLY);
        Cursor cursor = db.rawQuery("select desc form datable where msf=?", new
                String[]{md5});
        if (cursor.moveToNext()) {
            desc = cursor.getString(0);
        }

        cursor.close();
        db.close();
        return desc;
}
}
