package com.karenpownall.android.aca.notetoself;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DialogNewNote extends DialogFragment{

    //camera functionality
    private static final int CAMERA_REQUEST = 123;
    private ImageView mPicTake;
    private ImageButton mBtnPhoto;
    //file path for photo
    private String mCurrentPhotoPath;
    //where photo is stored
    private Uri mImageUri = Uri.EMPTY;
    Note newNote = new Note();


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Declare and initialize an AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        /*
        Initialize a LayoutInflater object, which we'll use to inflate our
        XML layout. (Turn our XML Layout into a Java Object.)
        inflater.inflate basically replaces setContentView for our dialog
        Then we create and inflate a new View, which will then contain all the
        UI elements from our dialog_new_note.xml layout file.
        */

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_note, null);

        //camera functionality
        //uses code from slides Android Lesson 14
        mPicTake = (ImageView) dialogView.findViewById(R.id.picTake);
        mBtnPhoto = (ImageButton) dialogView.findViewById(R.id.btnPhoto);
        //mBtnPhoto = (Button) dialogView.findViewById(R.id.btnPhoto);

        mBtnPhoto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File photoFile = null;
                try {
                    photoFile = createImageFile();
                }catch (IOException ex){
                    //error occurred creating file
                    Log.e("error", "error creating file");
                }

                //continue only if file was created successfully
                if (photoFile != null){
                    mImageUri = Uri.fromFile(photoFile);
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }
            }
        });

        /*
        Here we get references to each of the UI widgets in our layout.  Many of
        the objects are declared final because they will be used in an anonymous
        class. This is required.
         */

        final EditText editTitle = (EditText) dialogView.findViewById(R.id.editTitle);
        final EditText editDescription = (EditText) dialogView.findViewById(R.id.editDescription);
        final CheckBox checkBoxIdea = (CheckBox) dialogView.findViewById(R.id.checkBoxIdea);
        final CheckBox checkBoxTodo = (CheckBox) dialogView.findViewById(R.id.checkBoxTodo);
        final CheckBox checkBoxImportant = (CheckBox) dialogView.findViewById(R.id.checkBoxImportant);
        Button btnCancel = (Button) dialogView.findViewById(R.id.btnCancel);
        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);

        /*
        Now we set the message of the dialog using builder. Then we write an
        anonymous class to handle clicks on btnCancel. In the overridden onClick
        method, we simply call dismiss(), which is a public method of DialogFragment,
        to close the dialog window.
         */

        builder.setView(dialogView).setMessage("Add a new note");

        //Handle cancel button
        btnCancel.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dismiss();
            }
        });

        /*
        Now we add an anonymous class to handle what happens when the user clicks on
        the OK button (btnOK)
         */

        //Handle OK button
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Set its variables to match the users entries on the form
                newNote.setTitle(editTitle.getText().toString());
                newNote.setDescription(editDescription.getText().toString());
                newNote.setIdea(checkBoxIdea.isChecked());
                newNote.setTodo(checkBoxTodo.isChecked());
                newNote.setImportant(checkBoxImportant.isChecked());

                //Get a reference to MainActivity
                MainActivity callingActivity = (MainActivity) getActivity();

                //Pass newNote back to MainActivity
                callingActivity.createNewNote(newNote);

                //Quit the dialog
                dismiss();
            }
        });

        return builder.create();
    }

    //camera/photo functionality
    private File createImageFile() throws IOException {
        //create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd__HHmmss").format(new Date());
        String imageFileName = "JPEG_ " + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        mCurrentPhotoPath = "file: " + image.getAbsolutePath();
        return image;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            //Bitmap photo = (Bitmap)data.getExtras().get("data");
            //newNote.setPicture(photo);
            try {
                newNote.setPicture(Uri.parse(mImageUri.toString()));
                mPicTake.setImageURI(Uri.parse(mImageUri.toString()));
            } catch (Exception e) {
                Log.e("Error", "Uri not set");
            }
        }else {
            mImageUri = Uri.EMPTY;
        }
    }

    /*
    causes Null Pointer Exception
    really necessary here?
    doesn't work in DialogShowNote either

    @Override
    public void onDestroy() {
        super.onDestroy();
        BitmapDrawable bd = (BitmapDrawable) mPicTake.getDrawable();
        bd.getBitmap().recycle();
        mPicTake.setImageBitmap(null);
    }
    */
}
