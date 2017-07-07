package com.example.shaymaa.finalproject.fragments;

 import android.content.Intent;
 import android.os.Bundle;
import android.app.Fragment;
 import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.Button;

 import com.example.shaymaa.finalproject.R;
 import com.example.shaymaa.finalproject.activites.MainActivity;


public class RegisterCompletThree extends Fragment {
    Button complet_register_moassa ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout. registration_company_thrid, container, false);
        complet_register_moassa= (Button)rootView.findViewById(R.id.complet_register_moassa);
        complet_register_moassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return rootView;

    }
}
