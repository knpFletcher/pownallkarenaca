package com.karenpownall.android.aca.accessscopethisandstatic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* AlienShip girlShip = new AlienShip();
        AlienShip boyShip = new AlienShip();

        //look no objects but using static method
        Log.i("numShips: ", "" + AlienShip.getNumShips());

        //this works because shipName is public
        girlShip.shipName = "Corinne Yu";
        boyShip.shipName = "Andre LaMothe";

        /*this won't work because shieldStrength is private
        girlship.shieldStrength = 999;
        boyship.setShieldStrength(1000000);

        //but have public getter
        Log.i("girlShip shieldStrngt: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());
        //have to abbreviate above for log, can't have more than 23 characters

        //let's shoot some ships
        girlShip.hitDetected();
        Log.i("girlShip shieldStrngt: ", "" + girlShip.getShieldStrength());

        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        boyShip.hitDetected();
        boyShip.hitDetected();
        boyShip.hitDetected();

        Log.i("girlShip shieldStrngt: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        boyShip.hitDetected(); //aah

        Log.i("girlShip shieldStrngt: ", "" + girlShip.getShieldStrength());
        Log.i("boyShip shieldStrngth: ", "" + boyShip.getShieldStrength());

        Log.i("numShips: ", "" + AlienShip.getNumShips());
    } */

        Fighter aFighter = new Fighter();
        Bomber aBomber = new Bomber();

        //Can't do in AlienShip abstract:
        //AlienShip alienShip = new AlienShip(500);

        //But objects of subclasses can do everything AlienShip is meant to do

        aBomber.shipName = "Newell Bomber";
        aFighter.shipName = "Meier Fighter";

        //overridden constructor calls super constructor, have unique properties

        Log.i("aFighter shield: ", "" + aFighter.getShieldStrength());
        Log.i("aBomber shield: ", "" + aBomber.getShieldStrength());

        //as well as certain things in certain ways that are unique to subclasses
        aBomber.fireWeapon();
        aFighter.fireWeapon();

        //take down those alien ships
        //focus on bomber, has weaker shield
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();
        aBomber.hitDetected();

    }
}
