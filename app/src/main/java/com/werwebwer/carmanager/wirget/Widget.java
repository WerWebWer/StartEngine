package com.werwebwer.carmanager.wirget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;

import com.werwebwer.carmanager.R;
import com.werwebwer.carmanager.utils.SendSMS;

public class Widget extends AppWidgetProvider {

    public static String ACTION_WIDGET_RECEIVER = "SendSMS";

    @Override
    public void onReceive(@NonNull Context context, @NonNull Intent intent) {
        final String action = intent.getAction();
        if (action.equals(ACTION_WIDGET_RECEIVER))
            SendSMS.send(context);
        super.onReceive(context, intent);
    }

    @Override
    public void onUpdate(
            @NonNull Context context,
            @NonNull AppWidgetManager appWidgetManager,
            int[] appWidgetIds
    ) {
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

        Intent active = new Intent(context, Widget.class);
        active.setAction(ACTION_WIDGET_RECEIVER);

        PendingIntent actionPendingIntent = PendingIntent.getBroadcast(context, 0, active, 0);
        remoteViews.setOnClickPendingIntent(R.id.widget_button, actionPendingIntent);

        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
