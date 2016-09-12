package com.karenpownall.android.aca.accessscopethisandstatic;

import android.util.Log;

/**
 * Created by kkpwnall on 9/12/16.
 */
public class Fighter extends AlienShip{

    public Fighter(){
        super(400);
        //strong sields for a fighter
        Log.i("Location: ", "Fighter Constructor");
    }

    public void fireWeapon(){
        Log.i("Firing weapon: ", "lasers firing");
    }
}
