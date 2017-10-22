package cn.edu.gdmec.android.mobileguard;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;



public class App extends Application {
    public void onCreate(){
        super.onCreate();
        correctSIM();
    }
    public void correctSIM(){
        SharedPreferences sp = getSharedPreferences("config",Context.MODE_PRIVATE);
    boolean protecting =sp.getBoolean("protecting",true);
        if(protecting){
            String bindsim = sp.getString("sim","")  ;
            TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELECOM_SERVICE);
            String realsim = tm.getSimSerialNumber();
            realsim="999";
            if (bindsim.equals(realsim)){
                Log.i("","SIM卡未发生变化，还是你的手机");
            }else{
                Log.i("","SIM卡发生变化");
                String safenumber = sp.getString("safenumber","");
                if(!TextUtils.isEmpty(safenumber)){
                    SmsManager smsManager =SmsManager.getDefault();
                    smsManager.sendTextMessage(safenumber,null,"您的亲友手机号码已经换了",null,null);
                }
            }
        }
    }
}
