package com.example.yanvydra.cood;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class AccountSettings extends AppCompatActivity {


    private EditText mPassword;
    private EditText mName;
    private Button mSavebtn;

    Firebase reference1;


    //Firebase
    //private DatabaseReference mStatusDatabase;
    //private FirebaseUser mCurrentUser;


    //Progress
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings);

        Firebase.setAndroidContext(this);

        reference1 = new Firebase("https://fir-excood2.firebaseio.com/users/" + UserDetails.username );
        //Firebase

        final String password = getIntent().getStringExtra("password_value");

        mPassword = (EditText) findViewById(R.id.password_input);
        mName = (EditText) findViewById(R.id.name_input);
        mSavebtn = (Button) findViewById(R.id.save_btn);


        mSavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Progress
                mProgress = new ProgressDialog(AccountSettings.this);
                mProgress.setTitle("Saving Changes");
                mProgress.setMessage("Please wait while we save the changes");
                mProgress.show();

                String password = mPassword.getText().toString();
                String name = mName.getText().toString();


                reference1.child("password").setValue(password);
                reference1.child("fio").setValue(name);

                mProgress.dismiss();

                /*reference1.child("password").setValue(password).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful()){

                            mProgress.dismiss();

                        } else {

                            Toast.makeText(getApplicationContext(), "There was some error in saving Changes.", Toast.LENGTH_LONG).show();

                        }

                    }
                });*/

            }
        });



    }
}
