package cn.edu.gdmec.android.mobileguard.m2theftguard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import cn.edu.gdmec.android.mobileguard.R;

public class Setup4Activity extends BasicSetUpActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_4);

        ((RadioButton) findViewById(R.id.rb_four)).setChecked(true);
    }

    @Override
    public void showNext(){
        Toast.makeText(this, "当前页面已经是最后一页", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPre(){
        startActivityAndFinishSelf(Setup3Activity.class);
    }
}
