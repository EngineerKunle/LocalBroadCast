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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    @BindView(R.id.button) Button mButton;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void onClick(View view){
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
