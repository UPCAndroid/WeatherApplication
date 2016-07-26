package com.example.administrator.weatherapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

    private TextView welcomeName;
    private ImageView background;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomeName = (TextView)findViewById(R.id.name_welcome);
        background = (ImageView)findViewById(R.id.welcome_background);
        //在界面上显示一个提示框
//        Toast.makeText(WelcomeActivity.this, "更多精彩内容，请使用app", Toast.LENGTH_LONG).show();



        Animation anim = AnimationUtils.loadAnimation(this,R.anim.welcome_show);
        welcomeName.setAnimation(anim);
        Animation animBg = AnimationUtils.loadAnimation(this,R.anim.backgroung_anim);
        background.setAnimation(animBg);





        final Runnable callback=new Runnable() {
            //一段被运行的代码
            @Override
            public void run() {

                Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);


                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                finish();
            }
        };

        final Handler handler=new Handler();

        Thread thread=new Thread() {
            //当线程运行的时候，执行的操作
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                handler.post(callback);
            }
        };

        thread.start();
    }
}
