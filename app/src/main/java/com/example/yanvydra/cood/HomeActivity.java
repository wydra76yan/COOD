package com.example.yanvydra.cood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout linearLayoutTB;
    Animation fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        linearLayoutTB = (LinearLayout) findViewById(R.id.llTopToolBar);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.starthp_fromtop);
        linearLayoutTB.setAnimation(fromTop);
    }
}
