package com.tutorial.engineerkunle.localbroadcast.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorial.engineerkunle.localbroadcast.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by EngineerKunle on 02/08/2016.
 */
public class ListArrayAdapter extends ArrayAdapter<String>{

    private final String[] list;
    private final String[] descriptionList;
    int[] imgIds = new int [] {R.drawable.ic_me, R.drawable.ic_human_touch, R.drawable.ic_jobs, R.drawable.ic_turtle, R.drawable.ic_xmen };

    private LayoutInflater inflator;

    static class ViewHolder {

        @BindView(R.id.item_name)
        TextView name;

        @BindView(R.id.item_description)
        TextView description;

        @BindView(R.id.item_image)
        ImageView flag;

        public ViewHolder(View view){
            ButterKnife.bind(this, view);
        }
    }

    public ListArrayAdapter(Activity ctx, String[] values, String[] description) {

        super(ctx, R.layout.list_mobile, values);
        this.list = values;
        this.descriptionList = description;
        inflator = ctx.getLayoutInflater();

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder;
        if (view == null) {
            view = inflator.inflate(R.layout.list_mobile, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.name.setText(list[position]);
        holder.description.setText(descriptionList[position]);
        holder.flag.setImageResource(imgIds[position]);

        return view;
    }
}
