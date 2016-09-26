package com.karenpownall.android.aca.fragmentslider;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    //holds the fragment id passed in when created
    public static final String MESSAGE = "";

    //newInstance method which is called to make new Fragment
    public static SimpleFragment newInstance(String message)
    {
        //create the fragment
        SimpleFragment fragment = new SimpleFragment();

        //create a bundle for our message/id
        Bundle bundle = new Bundle(1);
        //load up the bundle
        bundle.putString(MESSAGE, message);

        //call setArguments ready for when onCreate is called
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //get id from the Bundle
        String message = getArguments().getString(MESSAGE);

        //infalte the view as normal
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        //get a reference to the textView
        TextView messageTextView = (TextView)view.findViewById(R.id.textView);

        //display the id with the TextView
        messageTextView.setText(message);

        //handle UI of any complexity

        return view;
    }
}
