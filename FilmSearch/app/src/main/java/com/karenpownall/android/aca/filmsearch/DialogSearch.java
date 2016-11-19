package com.karenpownall.android.aca.filmsearch;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.karenpownall.android.aca.filmsearch.R.layout.dialog_search;

public class DialogSearch extends DialogFragment{

    @BindView(R.id.queryButton) Button mQueryButton;
    @BindView(R.id.searchText) EditText mSearchText;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    Button mCancelButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View dialogView = inflater.inflate(R.layout.dialog_search, null);

        ButterKnife.bind(this, dialogView);

        //mCancelButton = (Button) dialogView.findViewById(R.id.cancelButton);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setView(dialog_search).setMessage("Search");
        }

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        mQueryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mSearchIntent = new Intent(getActivity(), MainActivity.class);
                mSearchIntent.putExtra("Search", mSearchText.getText().toString());
                startActivity(mSearchIntent);

            }
        });

        return dialogView;
    }
}
