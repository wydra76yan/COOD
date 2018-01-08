package com.example.yanvydra.cood.NavigationBarFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yanvydra.cood.R;
import com.firebase.client.Firebase;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPageFragment extends Fragment {

    Firebase reference1,reference6;
    TextView mPassword;
    TextView mName;

    private static final int GALLERY_PICK=1;

    private StorageReference mImageStorage;


    ImageView avaImage;
    Button mStatusBtn;
    Button mImageBtn;


    public MyPageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_page, container, false);
    }

}
