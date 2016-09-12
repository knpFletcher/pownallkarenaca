package com.karenpownall.android.aca.accessscopethisandstatic;

import android.util.Log;

/**
 * Created by kkpwnall on 9/12/16.
 */
public abstract class AlienShip {

    private static int numShips;
    private int shieldStrength;
    public String shipName;

    /* public AlienShip() {
         * numShips++;

        /* can call private methods from here, part of class;
        "this" shows for sure setting correct shieldStrength;
        "this" makes code more clear


        this.setShieldStrength(100);
    }

    public static int getNumShips(){
        return numShips;
    }

    private void setShieldStrength(int shieldStrength){
        /*"this" distinguishes between
        member variable shieldStrength
        and local variable of same name

        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength(){
        return this.shieldStrength;
    }

    public void hitDetected(){
        shieldStrength -= 25;
        Log.i("Incomming: ", "BAM!");
        if (shieldStrength == 0){
            destroyShip();
        }
    }

    private void destroyShip(){
        numShips--;
        Log.i("Explosion: ", ""+this.shipName + "destroyed");
    }
    */
    public AlienShip(int shieldStrength) {  //constructor
        Log.i("Location: ", "AlienShip constructor");
        numShips++;
        setShieldStrength(shieldStrength);
    }

    public abstract void fireWeapon();
     //aah my body, where is it?

    public static int getNumShips(){
        return numShips;
    }

    private void setShieldStrength(int shieldStrength){
        this.shieldStrength = shieldStrength;
    }

    public int getShieldStrength(){
        return this.shieldStrength;
    }

    public void hitDetected(){
        shieldStrength -= 25;
        Log.i("Incoming: ", "BAM!");
        if (shieldStrength == 0){
            destroyShip();
        }
    }

    private void destroyShip(){
        numShips--;
        Log.i("Explosion: ", "" + this.shipName + "destroyed");
    }

} //end of the class
