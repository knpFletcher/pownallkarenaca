package com.karenpownall.android.aca.eventbus;

public class LoginEvent {
    
    public final String mUserName;

    public LoginEvent(String userName){
        this.mUserName = userName;
    }
}
