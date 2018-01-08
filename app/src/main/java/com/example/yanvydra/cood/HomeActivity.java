package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout linearLayoutTB;
    BottomNavigationView bottomNavigationView;
    Animation fromTop;
    Animation fromBot;
   // TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        linearLayoutTB = (LinearLayout) findViewById(R.id.llTopToolBar);
        //textView = (TextView) findViewById(R.id.textTest);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNav);
        fromTop = AnimationUtils.loadAnimation(this,R.anim.starthp_fromtop);
        fromBot = AnimationUtils.loadAnimation(this,R.anim.starthp_frombot);
        linearLayoutTB.setAnimation(fromTop);
        bottomNavigationView.setAnimation(fromBot);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.chat){
                 //   textView.setText("Place for Chat");
                }
                if(item.getItemId()==R.id.friends){
                   // textView.setText("Place for Contacts");
                }
                if(item.getItemId()==R.id.myPage){
                    //LoginActivity loginActivity = new LoginActivity();
                    startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                    /*MyPageFragment myPageFragment = new MyPageFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.for_fragments, myPageFragment, " FragmentName");
                    fragmentTransaction.commit();
                    return true;*/
                }

                return false;
            }
        });


    }


}
