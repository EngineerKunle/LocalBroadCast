package com.tutorial.engineerkunle.localbroadcast.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tutorial.engineerkunle.localbroadcast.R;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = ListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
