package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class LoginActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2400;
    ImageView imageView;
    LinearLayout linearLayoutSR;
    EditText etPass;
    EditText etUsName;
    Animation toTop;
    Animation toBot;
    Animation toLeft;
    Animation toRight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageView = (ImageView) findViewById(R.id.logoin);
        etPass = (EditText) findViewById(R.id.etPassword);
        etUsName = (EditText) findViewById(R.id.etUserName);
        linearLayoutSR = (LinearLayout) findViewById(R.id.llSignReg);
        toTop = AnimationUtils.loadAnimation(this,R.anim.afterlogin_totop);
        toBot = AnimationUtils.loadAnimation(this,R.anim.afterlogin_tobot);
        toLeft = AnimationUtils.loadAnimation(this,R.anim.afterlogin_toleft);
        toRight = AnimationUtils.loadAnimation(this,R.anim.afterlogin_toright);

    }

    public void onSignUpClick(View view) {

        imageView.startAnimation(toTop);
        etUsName.startAnimation(toLeft);
        etPass.startAnimation(toRight);
        linearLayoutSR.startAnimation(toBot);


        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        },SPLASH_TIME_OUT);

    }
}
