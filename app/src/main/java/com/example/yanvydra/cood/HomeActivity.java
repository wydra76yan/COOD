package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    LinearLayout linearLayoutTB;
   // BottomNavigationView bottomNavigationView;
    Animation fromTop;
    Animation fromBot;

    Button friends, chat, users, mypage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        friends=(Button) findViewById(R.id.friends);
        chat=(Button) findViewById(R.id.chat);
        users=(Button) findViewById(R.id.allusers);
        mypage=(Button) findViewById(R.id.mPage);



        mStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String password_value = mPassword.getText().toString();
                String name_value = mName.getText().toString();

                Intent status_intent = new Intent(MyAccount.this, AccountSettings.class);
                status_intent.putExtra("password_value", password_value);
                status_intent.putExtra("name_value", name_value);
                startActivity(status_intent);
            }
        });

    }

}
     /*radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
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
                    startActivity(new Intent(HomeActivity.this, Users.class));

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
                    return true;
                }

                return false;
            }
        });
*/