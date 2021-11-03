package com.angelfgdeveloper.manresapp.helpers;

import android.text.TextUtils;
import android.util.Patterns;

public class Validators {

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 5;
    }

}
