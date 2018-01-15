package com.example.yanvydra.cood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myimageloader.IMGldr;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class UsersAccount extends AppCompatActivity {


    Firebase reference1,reference2,reference3,reference4;
    TextView mPassword;
    TextView mName;
    ImageView avaImage;
    String user, pass, fios;

    Button mReqBtn;

    String mCurr_state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_account);

        mPassword = (TextView) findViewById(R.id.settings_status);
        mName = (TextView) findViewById(R.id.settings_name);
        avaImage = (ImageView) findViewById(R.id.settings_image);

        Firebase.setAndroidContext(this);

        mCurr_state="nat fien";
        reference2 = new Firebase("https://fir-excood2.firebaseio.com/friends/"+UserDetails.username).child(UserDetails.friendWith);
        reference4 = new Firebase("https://fir-excood2.firebaseio.com/friends/"+UserDetails.friendWith).child(UserDetails.username);

        mReqBtn = (Button) findViewById(R.id.sent_req_but);



        reference1 = new Firebase("https://fir-excood2.firebaseio.com/users/" + UserDetails.chatWith);//под другого юзера
        reference3 = new Firebase("https://fir-excood2.firebaseio.com/users/" + UserDetails.username);// под себя



        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name =  dataSnapshot.child("fio").getValue().toString();
                String password =  dataSnapshot.child("password").getValue().toString();
                String avatar =  dataSnapshot.child("profileImage").getValue().toString();

                mName.setText(name);
                mPassword.setText(password);
                IMGldr.INSTANCE.load(avatar).into(avaImage);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mReqBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurr_state.equals("nat fien")) {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("user", UserDetails.username);
                    reference2.push().setValue(map);
                    reference4.push().setValue(map);


                }
            }
        });

    }
}
