package com.karenpownall.android.aca.simplefragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a fragment manager
        FragmentManager fManager = getFragmentManager();

        //create a new fragment using the manager
        //passing in the id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.fragmentHolder);

        //check the fragment has not already been intialized
        if (frag == null){

            //initialize the fragment based on our SimpleFragment
            frag = new SimpleFragment();
            fManager.beginTransaction()
                    .add(R.id.fragmentHolder, frag)
                    .commit();
        }
    }
}
