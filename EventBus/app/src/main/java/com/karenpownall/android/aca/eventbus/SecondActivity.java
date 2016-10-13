package com.karenpownall.android.aca.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondActivity extends AppCompatActivity {

    TextView mUserStatus;
    private EventBus mBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mUserStatus = (TextView) findViewById(R.id.user_status);
    }

    /**
     * Receiving login event when it happens
     * Using sticky - true telling the activity to go
     * and get the last LoginEvent
     */

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLoginevent(LoginEvent event){
        mUserStatus.setText("User Status: Logged In, userName: " + event.mUserName);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBus.register(this);
    }

    @Override
    protected void onStop() {
        mBus.unregister(this);
        super.onStop();
    }
}
