package com.werwebwer.carmanager.ui.settings;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceFragmentCompat;

import com.werwebwer.carmanager.R;
import com.werwebwer.carmanager.utils.PreferenceUtils;
import com.werwebwer.carmanager.utils.TextUtils;

import static com.werwebwer.carmanager.utils.Constants.DIALOG_TAG;

public class SettingsFragment extends PreferenceFragmentCompat {


    @NonNull
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openDialog();
    }

    private void openDialog() {
        if (new PreferenceUtils(getContext()).isValidData())
            return;

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag(DIALOG_TAG);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        DialogFragment newFragment = DataInvalidDialogFragment.newInstance();
        newFragment.show(ft, DIALOG_TAG);
    }
}
