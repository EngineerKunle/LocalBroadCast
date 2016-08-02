package com.tutorial.engineerkunle.localbroadcast.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.tutorial.engineerkunle.localbroadcast.Adapter.ListArrayAdapter;

public class ListActivity extends android.app.ListActivity {

    private static final String TAG = ListActivity.class.getSimpleName();
    static final String[] HERO_LIST = new String[] {"Kunle", "Human Touch", "Steve Jobs", "Ninja Turtle", "X-Men"};
    static final String[] HERO_LIST_DES = new String[] {"Iron Man", "Fantastic 4", "Apple CEO", "RLDM", "Mutants power"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);
        setListAdapter(new ListArrayAdapter(this, HERO_LIST, HERO_LIST_DES ));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        String selected = (String) getListAdapter().getItem(position);
        String definition = HERO_LIST_DES[position];
        Toast.makeText(this, selected + "\n"+ definition, Toast.LENGTH_SHORT).show();
    }
}
