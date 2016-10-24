package com.karenpownall.android.aca.pong;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


// I feel like this would be better served as an Intent,
// but this is what works right now
public class DialogHome extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_home, null);

        TextView textTitle = (TextView) dialogView.findViewById(R.id.titleText);
        Button btnPlay = (Button) dialogView.findViewById(R.id.btnPlay);

        mBuilder.setView(dialogView);

        btnPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return mBuilder.create();
    }
}
