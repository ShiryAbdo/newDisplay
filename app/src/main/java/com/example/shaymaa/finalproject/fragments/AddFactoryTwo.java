package com.example.shaymaa.finalproject.fragments;

   import android.app.FragmentManager;
   import android.app.FragmentTransaction;
   import android.os.Bundle;
import android.app.Fragment;
   import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shaymaa.finalproject.R;


public class AddFactoryTwo extends Fragment {

     Button continu_add_factor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.continue_add_factory, container, false);
        continu_add_factor = (Button)rootView.findViewById(R.id.continu_add_factor);
        continu_add_factor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFactoryThree fr = new AddFactoryThree();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.container, fr);
                fragmentTransaction.commit();
            }
        });
        return rootView;

    }
}
