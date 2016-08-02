package com.tutorial.engineerkunle.localbroadcast.Service;

import android.app.Activity;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.tutorial.engineerkunle.localbroadcast.MainActivity;
import com.tutorial.engineerkunle.localbroadcast.R;

import butterknife.BindString;
import butterknife.ButterKnife;


/**
 * Created by EngineerKunle on 26/07/2016.
 */
public class MyIntentService extends IntentService {

    private static final String TAG = "MyIntentService";
    public String mText = "text has changed";

    public MyIntentService(){
        super("MyIntentService");
        Log.d(TAG," service has started");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "on handle called");
        Intent in = new Intent("sendData");
        Log.d(MyIntentService.class.getSimpleName(), "value is " + mText);
        in.putExtra("TextView", mText);
        Log.d(TAG, "sending broadcast");
        LocalBroadcastManager.getInstance(this).sendBroadcast(in);

    }
}
