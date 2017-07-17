package com.example.shaymaa.finalproject.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.activites.MainActivity;


public class AddFactoryThree extends Fragment {
    Button countinu ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.continue_add_factory_three, container, false);
        countinu = (Button)rootView.findViewById(R.id.cuttong_adding);
        countinu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return rootView;


    }
}
