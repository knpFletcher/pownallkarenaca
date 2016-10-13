package com.karenpownall.android.aca.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {

    private Button mLoginButton;
    private Button mSecondActivityButton;
    private EditText mUserName;

    private EventBus mBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginButton = (Button) findViewById(R.id.login_btn);
        mSecondActivityButton = (Button) findViewById(R.id.second_activity_btn);
        mUserName = (EditText) findViewById(R.id.user_name);

        //show fragmentA inside frame layout
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, new FragmentA())
                .commit();

        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //throw an error if user name is empty
                //else login user nad send logged userName to all subscribers
                if (mUserName.getText().toString().isEmpty()){
                    mUserName.setError("Please Enter Username, Punk!");
                } else{
                    //send event to all subscribers

                    //activities might not be ready to intercept it yet,
                    // but posting the sticky allows interception when it's ready

                    mBus.postSticky(new LoginEvent(mUserName.getText().toString()));
                }
            }
        });

        mSecondActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        mBus.unregister(this);
        super.onDestroy();
    }
}
