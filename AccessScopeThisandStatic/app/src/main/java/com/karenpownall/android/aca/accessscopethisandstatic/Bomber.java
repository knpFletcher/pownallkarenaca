package com.karenpownall.android.aca.accessscopethisandstatic;

import android.util.Log;

/**
 * Created by kkpwnall on 9/12/16.
 */
public class Bomber extends AlienShip{

    public Bomber(){
        super(100);
        //Weak shields for a bomber...
        Log.i("Location: ", "Bomber Constructor");
    }

    public void fireWeapon(){
        Log.i("Firing weapon: ", "bomb's away!");
    }

}
