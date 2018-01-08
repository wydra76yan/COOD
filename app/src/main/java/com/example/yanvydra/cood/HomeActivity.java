package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class HomeActivity extends AppCompatActivity {

    LinearLayout linearLayoutTB;
    BottomNavigationView bottomNavigationView;
    Animation fromTop;
    Animation fromBot;

    RadioGroup radioGroup1;
    RadioButton matching;
   // TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        matching = (RadioButton)findViewById(R.id.matching);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Intent in;
                Log.i("matching", "matching inside1 bro" + checkedId);
                switch (checkedId)
                {
                    case R.id.matching:
                        Log.i("matching", "matching inside1 matching" +  checkedId);
                        in=new Intent(getBaseContext(),Users.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.watchList:
                        Log.i("matching", "matching inside1 watchlistAdapter" + checkedId);
                        in = new Intent(getBaseContext(), Friends.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.rates:
                        Log.i("matching", "matching inside1 rate" + checkedId);
                        in = new Intent(getBaseContext(),MyAccount.class);
                        startActivity(in);
                        overridePendingTransition(0, 0);
                        break;

                    default:
                        break;
                }
            }
        });
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

    }


}
