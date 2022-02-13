package com.werwebwer.carmanager.ui.settings;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.werwebwer.carmanager.R;

public class DataInvalidFragment extends DialogFragment implements View.OnClickListener {
    private String mArg;

    @NonNull
    static DataInvalidFragment newInstance(@NonNull String arg) {
        DataInvalidFragment dataInvalidFragment = new DataInvalidFragment();
        Bundle args = new Bundle();
        args.putString("arg", arg);
        dataInvalidFragment.setArguments(args);
        return dataInvalidFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mArg = getArguments().getString("arg");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Data is invalid");
        View v = inflater.inflate(R.layout.invalid_data_dialog, container, false);


        TextView tv = v.findViewById(R.id.dialog_invalid_title);
        v.findViewById(R.id.dialog_invalid_button_ok).setOnClickListener(this);

        tv.setText("Dialog " + mArg);
        return v;
    }

    public void onClick(View v) {
        dismiss();
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}