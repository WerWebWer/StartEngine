package com.werwebwer.carmanager.ui.settings;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.werwebwer.carmanager.R;
import com.werwebwer.carmanager.utils.PreferenceUtils;
import com.werwebwer.carmanager.utils.TextUtils;

import static com.werwebwer.carmanager.utils.Constants.DIALOG_TAG;
import static com.werwebwer.carmanager.utils.Constants.TIME_DELAY_MENU;

public class SettingsActivity extends AppCompatActivity {

    private PreferenceUtils mPreferenceUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, SettingsFragment.newInstance())
                    .commit();
        }
        mPreferenceUtils = new PreferenceUtils(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.settings_menu_status);

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mPreferenceUtils.isValidData()) {
                    item.setTitle(getApplicationContext().getString(R.string.settings_menu_status_ok));
                } else {
                    item.setTitle(getApplicationContext().getString(R.string.settings_menu_status_error));
                }
                handler.postDelayed(this, TIME_DELAY_MENU);
            }
        };
        handler.post(runnable);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.settings_menu_status) {
            if (!mPreferenceUtils.isValidData()) {
                new DataInvalidDialogFragment().show(getSupportFragmentManager(), DIALOG_TAG);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}