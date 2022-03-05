package com.werwebwer.carmanager.tile;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.werwebwer.carmanager.R;

public class TileDialog extends Dialog {

    private Context mContext;
    private OnCancelListener mCancelListener;

    public TileDialog(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public TileDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init(context, null);
    }

    protected TileDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context, cancelListener);
    }

    private void init(@NonNull Context context, @Nullable OnCancelListener cancelListener) {
        mContext = context;
        mCancelListener = cancelListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.invalid_data_dialog);

//        this.editTextFullName = (EditText) findViewById(R.id.editText_fullName);
//        this.buttonOK = (Button) findViewById(R.id.button_ok);
//        this.buttonCancel  = (Button) findViewById(R.id.button_cancel);
//
//        this.buttonOK.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonOKClick();
//            }
//        });
//        this.buttonCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                buttonCancelClick();
//            }
//        });
    }
//    // User click "OK" button.
//    private void buttonOKClick()  {
//        String fullName = this.editTextFullName.getText().toString();
//
//        if(fullName== null || fullName.isEmpty())  {
//            Toast.makeText(this.context, "Please enter your name", Toast.LENGTH_LONG).show();
//            return;
//        }
//        this.dismiss(); // Close Dialog
//
//        if(this.listener!= null)  {
//            this.listener.fullNameEntered(fullName);
//        }
//    }
//
//    // User click "Cancel" button.
//    private void buttonCancelClick()  {
//        this.dismiss();
//    }
}
