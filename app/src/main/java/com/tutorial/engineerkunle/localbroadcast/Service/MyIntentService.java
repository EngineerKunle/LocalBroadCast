package com.tutorial.engineerkunle.localbroadcast.Service;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


/**
 * Created by EngineerKunle on 26/07/2016.
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";

    public MyIntentService(){
        super("MyIntentService");
        Log.d(TAG," service has started");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "on handle called");
        Intent in = new Intent("sendData");
        in.putExtra("TextView", "Your Name");
        Log.d(TAG, "sending broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(in);

    }
}
