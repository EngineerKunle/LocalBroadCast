package com.tutorial.engineerkunle.localbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tutorial.engineerkunle.localbroadcast.Service.MyIntentService;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text) TextView mTextView;
    @BindView(R.id.textView) TextView mText;
    @BindView(R.id.button) Button mButton;
    @BindString(R.string.title) String Title;
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mText.setText(Title);
    }

    @OnClick(R.id.button)
    public void onClick(){
        Log.d(TAG, "has been clicked : Service starting");
        Intent i = new Intent(MainActivity.this, MyIntentService.class);
        startService(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(onNotice);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter mIntentFilter = new IntentFilter("sendData");
        LocalBroadcastManager.getInstance(this).registerReceiver(onNotice, mIntentFilter);
    }

    private BroadcastReceiver onNotice = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String data = intent.getStringExtra("TextView");

            mTextView.setText(data);

        }
    };
}
