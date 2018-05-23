package com.example.marvin.searchviewlist_demo;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter {
    Activity activity;
    String[] data;

    public MyAdapter(Activity activity, String[] data) {
        super(activity,R.layout.rowlist,data);

        this.activity=activity;
        this.data=data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=activity.getLayoutInflater();
        View view=inflater.inflate(R.layout.rowlist,null);

        ImageView imageView = view.findViewById(R.id.icon);
        TextView textView = view.findViewById(R.id.listItem);

        textView.setText(data[position]);
        imageView.setImageResource(R.drawable.ic_call_made_black_24dp);

        return view;


    }
}
