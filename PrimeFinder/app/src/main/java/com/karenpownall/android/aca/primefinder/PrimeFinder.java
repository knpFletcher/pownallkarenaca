package com.karenpownall.android.aca.primefinder;

import android.widget.TextView;

/**
 * Created by kkpwnall on 9/2/16.
 */
public class PrimeFinder implements Runnable{

    public long target;
    public long prime;
    public boolean finished = false;
    private Thread runner;
    public TextView mPrimeFound;

    //need constructor
    PrimeFinder(long inTarget, TextView primeFound) {
        target = inTarget;
        //created variable for thread, need to initialize
        if (runner == null) {
            runner = new Thread(this); //new thread of this class
            runner.start(); //calls public void run()
        }
        mPrimeFound = primeFound;
    }

    @Override
    public void run() {
        long numPrimes = 0;
        long candidate = 2;

        while (numPrimes < target) {
            if (isPrime (candidate)) {
                numPrimes++;
                prime = candidate;
                //System.out.println("Prime Candidate: " + prime); //every prime found
                mPrimeFound.setText(String.valueOf(prime));
            }
            candidate++;

        }
        //System.out.println("Number of Primes: " + numPrimes); // amount of primes found
        finished = true; //stops thread
    }
    boolean isPrime(long checkNumber) {
        double root = Math.sqrt(checkNumber); //square root

        for (int i = 2; i <= root; i++) {
            if (checkNumber % i == 0) {//number passed in evenly divisible by i, returns boolean
                return false;
            }
        }
        return true; //return value outside of for loop

    }
}
