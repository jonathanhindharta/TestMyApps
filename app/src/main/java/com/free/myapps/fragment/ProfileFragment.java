package com.free.myapps.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.free.myapps.R;
import com.free.myapps.utils.Global;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProfileFragment extends Fragment {
    @Bind(R.id.txtEmail)
    TextView txtEmail;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        txtEmail.setText(Global.getEmail(getActivity()));
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
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
