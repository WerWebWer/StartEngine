package com.werwebwer.carmanager.ui.settings;

import android.content.Context;
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
import com.werwebwer.carmanager.utils.PreferenceUtils;
import com.werwebwer.carmanager.utils.TextUtils;

import static com.werwebwer.carmanager.utils.Constants.ARGS;

public class DataInvalidFragment extends DialogFragment implements View.OnClickListener {

    @NonNull
    static DataInvalidFragment newInstance() {
        return new DataInvalidFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @NonNull ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        getDialog().setTitle(getContext().getString(R.string.dialog_invalid_title));
        View v = inflater.inflate(R.layout.invalid_data_dialog, container, false);


        TextView tv = v.findViewById(R.id.dialog_invalid_text);
        v.findViewById(R.id.dialog_invalid_button_ok).setOnClickListener(this);
        if (!TextUtils.isDataValid(
                new PreferenceUtils(getContext()).getNumber(),
                new PreferenceUtils(getContext()).getCodeStartEngine()))
            tv.setText(getContext().getString(R.string.dialog_invalid_with_args_text, getInvalidProperties(getContext())));
        else
            tv.setText(getContext().getString(R.string.dialog_invalid_without_args_text));
        return v;
    }

    @NonNull
    private String getInvalidProperties(@NonNull Context context) {
        String result = "";
        PreferenceUtils preferenceUtils = new PreferenceUtils(context);
        if(!TextUtils.isNumber(preferenceUtils.getNumber()))
            result = result + ARGS[0] + ", ";
        if(!TextUtils.isCode(preferenceUtils.getCodeStartEngine()))
            result = result + ARGS[1] + ", ";
        result = result.substring(0, result.length() - 2);
        return result;
    }

    public void onClick(@NonNull View v) {
        dismiss();
    }

    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
    }
}