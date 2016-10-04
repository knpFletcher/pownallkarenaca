package com.karenpownall.android.aca.pong;

import android.graphics.RectF;

import java.util.Random;

public class Ball {
    private RectF mRect;
    private float mXVelocity;
    private float mYVelocity;
    private float mBallWidth;
    private float mBallHeight;

    public Ball(int screenX, int screenY){

        //make the mBall size relative to screen resolution
        mBallWidth = screenX / 100;
        mBallHeight = mBallWidth;

        /* start ball travelling straight up
        at one quarter of screen height per second
         */

        mYVelocity = screenY / 4;
        mXVelocity = mYVelocity;

        //initialize Rect that represents the mBall
        mRect = new RectF();
    }

    //give access to the Rect
    public RectF getRect(){
        return mRect;
    }

    //change positin each frame
    public void update(long fps){
        mRect.left = mRect.left + (mXVelocity / fps);
        mRect.top = mRect.top + (mYVelocity / fps);
        mRect.right = mRect.left + mBallWidth;
        mRect.bottom = mRect.right - mBallHeight;
    }

    //reverse vertical heading
    public void reverseYVelocity(){
        mYVelocity = -mYVelocity;
    }

    //reverse horizontal heading
    public void reverseXVelocity(){
        mXVelocity = -mXVelocity;
    }

    public void setRandomXVelocity(){
        Random generator = new Random();
        int answer = generator.nextInt(2);

        if (answer == 0){
            reverseXVelocity();
        }
    }

    // Speed up by 10%
    // A score of 25 is quite tough on this setting
    public void increaseVelocity(){
        mXVelocity = mXVelocity + mXVelocity / 10;
        mYVelocity = mYVelocity + mYVelocity / 10;
    }


    public void clearObstacleY(float y){
        mRect.bottom = y;
        mRect.top = y - mBallHeight;
    }

    public void clearObstacleX(float x){
        mRect.left = x;
        mRect.right = x + mBallWidth;
    }

    public void reset(int x, int y){
        mRect.left = x / 2;
        mRect.top = y - 20;
        mRect.right = x / 2 + mBallWidth;
        mRect.bottom = y - 20 - mBallHeight;
    }



}
