package com.karenpownall.android.aca.pong;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//TODO enter high scores
//TODO persistence

public class DialogLoser extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_loser, null);

        TextView endText = (TextView) dialogView.findViewById(R.id.endText);
        Button btnReset = (Button) dialogView.findViewById(R.id.btnRestart);

        mBuilder.setView(dialogView);

        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //MainActivity callingActivity = (MainActivity) getActivity();

                //take user to home screen
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                // Create and show the dialog.
                DialogHome mDialogHome = new DialogHome ();
                mDialogHome.show(ft, "dialog");
                dismiss();
            }
        });
        return mBuilder.create();
    }
}
