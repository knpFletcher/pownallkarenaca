package com.karenpownall.android.aca.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {

    //this is the actual database
    private SQLiteDatabase db;

    /* Next we have public static final string
    for each row/table that we need to refer to
    both inside and outside this class
     */

    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_NAME = "name";
    public static final String TABLE_ROW_AGE = "age";

    /* Next we have private static final string for
    each row/table that we need to refer to just inside
    this class
     */

    private static final String DB_NAME = "address_book_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_N_AND_A = "names_and_addresses";

    public DataManager (Context context){
        //create an instance of our internal CustomSQLiteOpenHelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);

        //grab a writable database
        db = helper.getWritableDatabase();
    }

    //here are all our helper methods

    //insert a record
    public void insert(String name, String age){

        //add all details to table
        String query = "INSERT INTO " + TABLE_N_AND_A + " (" +
                TABLE_ROW_NAME + ", " +
                TABLE_ROW_AGE + ") " +
                "VALUES (" +
                "'" + name + "'" + ", " +
                "'" + age + "'" +
                ");";

        Log.i("insert() = ", query);
        db.execSQL(query);
    }

    //delete a record
    public void delete(String name){

        //delete the details from the table if it already exists
        String query = "DELETE FROM " + TABLE_N_AND_A +
                " WHERE " + TABLE_ROW_NAME + " = '" +
                name + "';";

        Log.i("delete() = ", query);
        db.execSQL(query);
    }

    //get all the records
    public Cursor selectAll(){
        Cursor c = db.rawQuery("SELECT *" + " from " + TABLE_N_AND_A, null);
        return c;
    }

    // Find a specific record
    public Cursor searchName(String name) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_NAME +
                ", " + TABLE_ROW_AGE +
                " from " +
                TABLE_N_AND_A + " WHERE " +
                TABLE_ROW_NAME + " = '" + name + "';";

        Log.i("searchName() = ", query);

        Cursor c = db.rawQuery(query, null);


        return c;
    }

    //this class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper (Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        //this method only runs the 1st time the database is created

        @Override
        public void onCreate(SQLiteDatabase db) {
            //create a table for photos and their details

            String newTableQueryString = "create table " +
                    TABLE_N_AND_A + " (" +
                    TABLE_ROW_ID +
                    " integer primary key autoincrement not null," +
                    TABLE_ROW_NAME +
                    " text not null," +
                    TABLE_ROW_AGE +
                    " text not null);";

            db.execSQL(newTableQueryString);
        }
        //this method only runs when we increment DB_VERSION

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
