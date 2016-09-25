package com.karenpownall.android.aca.dualfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PortraitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);

        //get a fragment manager
        FragmentManager fManager = getFragmentManager();

        //create a new fragment using the manager
        //passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.detailFragmentHolder);

        //pass the Bundle onto the Fragment
        int position = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            position = extras.getInt("Position");
        }

        //check the fragment has not already been initialized
        if (frag == null){
            frag = AddressDetailFragment.newInstance(position);
            fManager.beginTransaction()
                    .add(R.id.detailFragmentHolder, frag)
                    .commit();
        }

    } //end onCreate
} //end PortraitDetailActivity
