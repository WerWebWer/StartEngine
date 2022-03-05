package com.werwebwer.carmanager.tile;

import android.os.Handler;
import android.os.Looper;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import com.werwebwer.carmanager.utils.Constants;
import com.werwebwer.carmanager.utils.SendSMS;

import static android.service.quicksettings.Tile.STATE_ACTIVE;
import static android.service.quicksettings.Tile.STATE_INACTIVE;

public class TileButton extends TileService {
    
    @Override
    public void onClick() {
        super.onClick();
        changeState(STATE_ACTIVE);

        if (!SendSMS.send(getApplicationContext())) {
            showDialog(new TileDialog(getApplicationContext()));
        }
        new Handler(Looper.getMainLooper()).postDelayed(() -> changeState(STATE_INACTIVE), Constants.TIME_DELAY);
    }

    private void changeState(int state) {
        Tile tile = getQsTile();
        tile.setState(state);
        tile.updateTile();
    }
}
