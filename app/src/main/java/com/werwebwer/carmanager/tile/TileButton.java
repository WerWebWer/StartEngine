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
        changeState();

        SendSMS.send(getApplicationContext());

        new Handler(Looper.getMainLooper()).postDelayed(this::changeState, Constants.TIME_DELAY);
    }

    private void changeState() {
        Tile tile = getQsTile();
        if (tile.getState() == STATE_ACTIVE) {
            tile.setState(STATE_INACTIVE);
        } else {
            tile.setState(STATE_ACTIVE);
        }
        tile.updateTile();
    }
}
