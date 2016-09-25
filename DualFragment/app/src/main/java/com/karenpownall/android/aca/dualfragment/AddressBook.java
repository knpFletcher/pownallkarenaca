package com.karenpownall.android.aca.dualfragment;

import java.util.ArrayList;

public class AddressBook {
    private static AddressBook ourInstance = new AddressBook();

    private ArrayList<NameAndAddress> mNamesAndAddresses;

    public static AddressBook getInstance() {
        return ourInstance;
    }

    private AddressBook() {
        mNamesAndAddresses = new ArrayList<NameAndAddress>();

        //some hardcoded dummy data

        //create a new entry
        NameAndAddress tempEntry = new NameAndAddress("B Obama",
                "The White House",
                "Washington",
                "DC1");

        //add it to the ArrayList
        mNamesAndAddresses.add(tempEntry);

        //create a new entry
        tempEntry = new NameAndAddress("E Windsor",
                "Buckingham Palace",
                "London",
                "SW1A 1AA");

        //add it to the ArrayList
        mNamesAndAddresses.add(tempEntry);

        //create a new entry
        tempEntry = new NameAndAddress("V Putin",
                "The Kremlin",
                "Moscow",
                "MS1");

        //add it to the ArrayList
        mNamesAndAddresses.add(tempEntry);
    }

    public ArrayList<NameAndAddress> getBook(){
        return mNamesAndAddresses;
    }
}
