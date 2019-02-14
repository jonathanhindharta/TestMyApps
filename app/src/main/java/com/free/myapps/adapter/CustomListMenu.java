package com.free.myapps.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.free.myapps.R;


/**
 * Created by JonathanEKSI on 16/06/2016.
 */
public class CustomListMenu extends ArrayAdapter<String>{

    private final Activity context;

    private final Integer[] imageDigi;


    public CustomListMenu(Activity context,
                          Integer[] imageDigi) {
        super(context, R.layout.list_main_menu);
        this.context = context;
        this.imageDigi = imageDigi;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_main_menu, null, true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imgdigis);
        imageView.setImageResource(imageDigi[position]);

        return rowView;
    }
}