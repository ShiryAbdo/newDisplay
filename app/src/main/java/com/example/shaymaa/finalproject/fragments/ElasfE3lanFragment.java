package com.example.shaymaa.finalproject.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.others.MyTextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ElasfE3lanFragment extends Fragment {


 TextView wasfeText ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_elasf_e3lan, container, false);
        wasfeText=(TextView)rootView.findViewById(R.id.wasfeText);

        return rootView;
    }

}
