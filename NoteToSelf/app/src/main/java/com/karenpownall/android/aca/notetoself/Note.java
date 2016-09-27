package com.karenpownall.android.aca.notetoself;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

public class Note {

    //modify to store image, like saving string for title and description
    //bitmap - saving actual object, not widget

    private static final String JSON_TITLE = "title";
    private static final String JSON_DESCRIPTION = "description";
    private static final String JSON_IDEA = "idea";
    private static final String JSON_TODO = "todo";
    private static final String JSON_IMPORTANT = "important";

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;
    private Uri mPicture;


    //Constructor (s go on top of class, best practice)
    //only used when new is called with JSONObject
    public Note(JSONObject jo) throws JSONException{
        mTitle = jo.getString(JSON_TITLE);
        mDescription = jo.getString(JSON_DESCRIPTION);
        mIdea = jo.getBoolean(JSON_IDEA);
        mTodo = jo.getBoolean(JSON_TODO);
        mImportant = jo.getBoolean(JSON_IMPORTANT);
    }

    // Now we must provide an empty default constructor
    // for when we create a Note as we provide a
    // specialized constructor that must be used.
    public Note (){
    }

    public Uri getPicture() {
        return mPicture;
    }

    //setting data inside note object
    public void setPicture(Uri picture) {
        mPicture = picture;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isIdea() {
        return mIdea;
    }

    public void setIdea(boolean idea) {
        mIdea = idea;
    }

    public boolean isTodo() {
        return mTodo;
    }

    public void setTodo(boolean todo) {
        mTodo = todo;
    }

    public boolean isImportant() {
        return mImportant;
    }

    public void setImportant(boolean important) {
        mImportant = important;
    }

    public JSONObject convertToJSON() throws JSONException{
        JSONObject jo = new JSONObject();

        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_TODO, mTodo);
        jo.put(JSON_IMPORTANT, mImportant);

        return jo;
    }

} //end of class
