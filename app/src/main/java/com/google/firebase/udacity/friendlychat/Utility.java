package com.google.firebase.udacity.friendlychat;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by animo on 6/10/17.
 */

public class Utility {
    public static String getCurrentUserId(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefsFile",Context.MODE_PRIVATE);
        String currentUserId = sharedPreferences.getString(context.getString(R.string.current_user),null);
        return currentUserId;
    }
}
