package com.werwebwer.carmanager.utils;

import android.content.Context;
import android.telephony.SmsManager;
import android.widget.Toast;

import com.werwebwer.carmanager.R;

public class SendSMS {
    public static void send(Context context) {
        try {
            Toast.makeText(context, context.getString(R.string.sens_sms), Toast.LENGTH_LONG).show();
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(context.getString(R.string.number), null, context.getString(R.string.code), null, null);
        } catch (Exception e) {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_LONG).show();
        }
    }
}
