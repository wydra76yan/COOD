package com.example.yanvydra.cood;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2400;
    ImageView imageView;
    TextView registerUser;
    LinearLayout linearLayoutSR;
    EditText etPass;
    Button loginButton;
    EditText etUsName;
    Animation toTop;
    Animation toBot;
    Animation toLeft;
    Animation toRight;
    String user,pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        imageView = (ImageView) findViewById(R.id.logoin);
        etPass = (EditText) findViewById(R.id.etPassword);
        etUsName = (EditText) findViewById(R.id.etUserName);
        linearLayoutSR = (LinearLayout) findViewById(R.id.llSignReg);
        loginButton = (Button)findViewById(R.id.loginButton);

        registerUser = (TextView)findViewById(R.id.register);

        registerUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, Register.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = etUsName.getText().toString();
                pass = etPass.getText().toString();

                if(user.equals("")){
                    etUsName.setError("can't be blank");
                }
                else if(pass.equals("")){
                    etPass.setError("can't be blank");
                }
                else{
                    String url = "https://fir-excood2.firebaseio.com/users.json";
                    final ProgressDialog pd = new ProgressDialog(LoginActivity.this);
                    pd.setMessage("Loading...");
                    pd.show();

                    StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
                        @Override
                        public void onResponse(String s) {
                            if(s.equals("null")){
                                Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                            }
                            else{
                                try {
                                    JSONObject obj = new JSONObject(s);

                                    if(!obj.has(user)){
                                        Toast.makeText(LoginActivity.this, "user not found", Toast.LENGTH_LONG).show();
                                    }
                                    else if(obj.getJSONObject(user).getString("password").equals(pass)){
                                        UserDetails.username = user;
                                        UserDetails.password = pass;
                                        startActivity(new Intent(LoginActivity.this, Users.class));
                                    }
                                    else {
                                        Toast.makeText(LoginActivity.this, "incorrect password", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            pd.dismiss();
                        }
                    },new Response.ErrorListener(){
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            System.out.println("" + volleyError);
                            pd.dismiss();
                        }
                    });

                    RequestQueue rQueue = Volley.newRequestQueue(LoginActivity.this);
                    rQueue.add(request);
                }

            }
        });
    }
}


/*    public void onSignUpClick(View view) {

        imageView.startAnimation(toTop);
        etUsName.startAnimation(toLeft);
        etPass.startAnimation(toRight);
        linearLayoutSR.startAnimation(toBot);

toTop = AnimationUtils.loadAnimation(this,R.anim.afterlogin_totop);
        toBot = AnimationUtils.loadAnimation(this,R.anim.afterlogin_tobot);
        toLeft = AnimationUtils.loadAnimation(this,R.anim.afterlogin_toleft);
        toRight = AnimationUtils.loadAnimation(this,R.anim.afterlogin_toright);
       /* new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),HomeActivity.class));
            }
        },SPLASH_TIME_OUT);

    }*/

