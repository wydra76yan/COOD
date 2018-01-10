package com.example.yanvydra.cood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.client.Firebase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class Friends extends AppCompatActivity {

    ListView friendsList;
    TextView noFriendsText;
    ArrayList<String> al = new ArrayList<>();
    int totalUsers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        friendsList = (ListView)findViewById(R.id.friendsList);
        noFriendsText = (TextView)findViewById(R.id.noFriendsText);

        Firebase.setAndroidContext(this);
        Firebase reference1 = new Firebase("https://fir-excood2.firebaseio.com/friends/" + UserDetails.username + "_" + UserDetails.friendWith);
        //Firebase reference2 = new Firebase("https://fir-excood2.firebaseio.com/messages/" + UserDetails.chatWith + "_" + UserDetails.username);

        String url = "https://fir-excood2.firebaseio.com/friends/"+UserDetails.username+".json";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>(){
            @Override
            public void onResponse(String s) {
                doOnSuccess(s);
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                System.out.println("" + volleyError);
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(Friends.this);
        rQueue.add(request);

        friendsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserDetails.chatWith = al.get(position);
                UserDetails.friendWith = al.get(position);
                startActivity(new Intent(Friends.this, Chat.class));
            }
        });


    }

    public void doOnSuccess(String s){
        try {
            JSONObject obj = new JSONObject(s);

            Iterator i = obj.keys();
            String key = "";

            while(i.hasNext()){
                key = i.next().toString();

                if(!key.equals(UserDetails.username)) {
                    al.add(key);
                }

                totalUsers++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(totalUsers <1){
            noFriendsText.setVisibility(View.VISIBLE);
            friendsList.setVisibility(View.GONE);
        }
        else{
            noFriendsText.setVisibility(View.GONE);
            friendsList.setVisibility(View.VISIBLE);
            friendsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al));
        }

    }
}