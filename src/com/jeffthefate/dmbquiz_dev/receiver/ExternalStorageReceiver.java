package com.jeffthefate.dmbquiz_dev.receiver;

import java.io.File;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;

import com.jeffthefate.dmbquiz_dev.ApplicationEx;
import com.jeffthefate.dmbquiz_dev.Constants;
/**
 * Receives when the contexts and widgets should be updated.
 * 
 * @author Jeff Fate
 */
public class ExternalStorageReceiver extends BroadcastReceiver {
 
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            ApplicationEx.cacheLocation =
                    context.getExternalCacheDir().getAbsolutePath();
            File path = new File(ApplicationEx.cacheLocation +
                    Constants.SCREENS_LOCATION);
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.FROYO) {
                path.setExecutable(true, false);
                path.setReadable(true, false);
                path.setWritable(true, false);
            }
            path.mkdirs();
        }
    }
 
}