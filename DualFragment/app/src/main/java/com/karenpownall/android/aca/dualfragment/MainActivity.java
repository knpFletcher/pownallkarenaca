package com.karenpownall.android.aca.dualfragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ActivityComs {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_dualfragment);

        //get a fragment manager
        FragmentManager fManager = getFragmentManager();

        //create a new fragment using the manager
        //passing in teh id of the layout to hold it
        Fragment frag = fManager.findFragmentById(R.id.listFragmentHolder);

        //check that fragment has not already been initialized
        if (frag == null);
        frag = new AddressListFragment(); //adds in list view itself
        fManager.beginTransaction()
                .add(R.id.listFragmentHolder, frag)
                .commit();
    } //end onCreate

    @Override
    public void onListItemSelected(int position) {
        //is there a layout with an id that matches the detail container?
        if (findViewById(R.id.detailFragmentHolder)==null){
            //if not we need to start a new activity
            Intent i = new Intent(this, PortraitDetailActivity.class);
            //we can't pass an object into an intent
            //neither do we want to
            //so we pass its position in the array 1st
            i.putExtra("Position", position);
            startActivity(i);
        } else {
            //fragment already exists
            FragmentManager fManager = getFragmentManager();
            FragmentTransaction fTransaction = fManager.beginTransaction();

            Fragment fragOld = fManager.findFragmentById(R.id.detailFragmentHolder);
            Fragment fragNew = AddressDetailFragment.newInstance(position);

            if (fragOld != null) {
                fTransaction.remove(fragOld);
            }

            fTransaction.add(R.id.detailFragmentHolder, fragNew);
            fTransaction.commit();
        }
    }
} //end MainActivity
