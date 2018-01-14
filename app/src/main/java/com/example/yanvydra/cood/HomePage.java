package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    Button mFriendsBtn, mAllUsersBtn,mMyPageBtn, mChatBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mFriendsBtn = (Button)findViewById(R.id.friends_button);
        mAllUsersBtn=(Button)findViewById(R.id.allUsers_button);
        mMyPageBtn=(Button)findViewById(R.id.myPage_button);
        mChatBtn=(Button)findViewById(R.id.chat_button);

        mFriendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent friends_intent = new Intent(HomePage.this,Friends.class);
                startActivity(friends_intent);
            }
        });
        mAllUsersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allUsers_intent = new Intent(HomePage.this,Users.class);
                startActivity(allUsers_intent);
            }
        });
        mMyPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myPage_intent = new Intent(HomePage.this,MyAccount.class);
                startActivity(myPage_intent);
            }
        });
        mChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent friends_intent = new Intent(HomePage.this,Chat.class);
                startActivity(friends_intent);
            }
        });
    }
}
