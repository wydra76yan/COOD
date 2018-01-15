package com.example.yanvydra.cood;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
//import com.squareup.picasso.Picasso;
import com.example.myimageloader.IMGldr;

public class MyAccount extends AppCompatActivity {



    Firebase reference1,reference6;
    TextView mPassword;
    TextView mName;

    private static final int GALLERY_PICK=1;

    private StorageReference mImageStorage;


    ImageView avaImage;
    Button mStatusBtn;
    Button mImageBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        mPassword = (TextView) findViewById(R.id.password);
        mName = (TextView) findViewById(R.id.profile_name);
        avaImage = (ImageView) findViewById(R.id.profile_image);

        mStatusBtn = (Button) findViewById(R.id.account_btn);
        mImageBtn = (Button) findViewById(R.id.image_btn);

        FirebaseApp.initializeApp(this);
        Firebase.setAndroidContext(this);

        mImageStorage = FirebaseStorage.getInstance().getReference(); //= new Firebase("gs://fir-excood2.appspot.com/");
        //reference1 = new Firebase("https://fir-excood2.firebaseio.com/users/" + UserDetails.chatWith);//под другого юзера
        reference1 = new Firebase("https://fir-excood2.firebaseio.com/users/" + UserDetails.username);// под себя
        reference6 = new Firebase("https://fir-excood2.firebaseio.com/users/"+UserDetails.username+"/profileImage"/* + UserDetails.username + UserDetails.profileImage*/); // под себя



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

        mImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gallery_intent = new Intent();
                gallery_intent.setType("image/*");
                gallery_intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery_intent,"SELECT IMAGE"),GALLERY_PICK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == GALLERY_PICK && resultCode == RESULT_OK){

            Uri imageUri=data.getData();

//            CropImage.activity(imageUri)
//                    .setAspectRatio(1,1)
//                    .setMinCropWindowSize(700,700)
//                    .start(this);





      /*  if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {*/
            //String result = imageUri;

                //Uri  = data.getUri();
                StorageReference filePath = mImageStorage.child("profile_images").child(UserDetails.username + ".jpg");

                filePath.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if (task.isSuccessful()) {
                            //Toast.makeText(AccountSettings.this,"worki", Toast.LENGTH_LONG).show();
                            String download_url = task.getResult().getDownloadUrl().toString();//"https://firebasestorage.googleapis.com/v0/b/fir-excood2.appspot.com/o/profile_images%2Ftest04.jpg?alt=media&token=1118ff23-8727-4b80-8b44-48f164e35da5";
                            reference6.setValue(download_url);
                            //Intent image_intent = new Intent(AccountSettings.this, SettingsChange.class);
                            //CropImage.putExtra("image_value", download_url);
                            //startActivity(status_intent);


                        } else {
                            Toast.makeText(MyAccount.this, "errrr", Toast.LENGTH_LONG).show();
                        }
                    }
                });

            } else if (resultCode == RESULT_OK) {
                //Exception error = result.getError();
            }
        }


    /*public String getRealPathFromURI(Uri contentUri) {

        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri, proj, // Which columns to return
                null,       // WHERE clause; which rows to return (all rows)
                null,       // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();



        return cursor.getString(column_index);
    }*/
}

