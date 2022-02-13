package com.werwebwer.carmanager.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TextUtils {

    public static boolean isEmpty(@Nullable String text) {
        return text == null || text.equals("");
    }

    public static boolean isNumber(@Nullable String number) {
        if (isEmpty(number)) return false;
        return clearNumber(number).matches("^[0-9]{11}$");
    }

    public static boolean isCode(@Nullable String code) {
        if (isEmpty(code)) return false;
        return code.matches("^[0-9]*$");
    }

    public static boolean isDataValid(
            @Nullable String number,
            @Nullable String code
    ) {
        return isNumber(number) && isCode(code);
    }

    @NonNull
    public static String clearNumber(@NonNull String number) {
        String result = number.replace("+", "");
        result = result.replace(" ", "");
        result = result.replace("(", "");
        result = result.replace(")", "");
        result = result.replace("-", "");
        result = result.replace("\n", "");
        result = result.replace("_", "");
        return result;
    }
}
