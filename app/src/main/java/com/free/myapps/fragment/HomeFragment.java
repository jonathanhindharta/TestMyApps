package com.free.myapps.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.free.myapps.R;
import com.free.myapps.activity.PageDetailActivity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends Fragment {
    /*@Bind(R.id.imageView3)
    ImageView imageView3;

    @Bind(R.id.imageView4)
    ImageView imageView4;

    @Bind(R.id.imageView5)
    ImageView imageView5;

    @OnClick(R.id.imageView3)
    void bimageView3OnClick() {
        Intent intent = new Intent(getActivity(), PageDetailActivity.class);
        intent.putExtra("index",0);
        startActivity(intent);
    }

    @OnClick(R.id.imageView4)
    void bimageView4OnClick() {
        Intent intent = new Intent(getActivity(), PageDetailActivity.class);
        intent.putExtra("index",1);
        startActivity(intent);
    }

    @OnClick(R.id.imageView5)
    void bimageView5OnClick() {
        Intent intent = new Intent(getActivity(), PageDetailActivity.class);
        intent.putExtra("index",2);
        startActivity(intent);
    }*/

    @Bind(R.id.listmenu)
    ListView listmenu;

    private Integer[] imageDigi= {
            R.drawable.agumon,
            R.drawable.gabumon,
            R.drawable.tentomon
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);


        List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<3;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img", Integer.toString(imageDigi[i]) );
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = { "img"};

        // Ids of views in listview_layout
        int[] to = { R.id.imgdigis};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), aList, R.layout.list_main_menu, from, to);

        listmenu.setAdapter(adapter);
        listmenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), PageDetailActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
        //return inflater.inflate(R.layout.fragment_home, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
