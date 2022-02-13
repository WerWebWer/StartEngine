package com.werwebwer.carmanager.utils;

import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.werwebwer.carmanager.R;
import com.werwebwer.carmanager.ui.settings.SettingsActivity;

public class SendSMS {

    public static void send(@NonNull Context context) {
        PreferenceUtils preferenceUtils = new PreferenceUtils(context);
        String number = preferenceUtils.getNumber();
        String startEngine = preferenceUtils.getCodeStartEngine();

        if (!TextUtils.isDataValid(number, startEngine)) {
            Toast.makeText(context, context.getString(R.string.sendsms_data_invalid), Toast.LENGTH_LONG).show();
            openSettings(context);
            return;
        }

        try {
            Toast.makeText(context, context.getString(R.string.sendsms_send_sms, number, startEngine), Toast.LENGTH_LONG).show();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, startEngine, null, null);
        } catch (Exception e) {
            Toast.makeText(context, context.getString(R.string.sendsms_error), Toast.LENGTH_LONG).show();
            openSettings(context);
        }
    }

    private static void openSettings(@NonNull Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
