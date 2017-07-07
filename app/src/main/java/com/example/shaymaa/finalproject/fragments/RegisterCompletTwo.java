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

import static com.example.shaymaa.finalproject.R.id.container;


public class RegisterCompletTwo extends Fragment {


    Button register_as_moassa_two ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.registration_company_second, container, false);
        register_as_moassa_two = (Button)rootView.findViewById(R.id.register_as_moassa_two);
        register_as_moassa_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegisterCompletThree fr = new RegisterCompletThree();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.container, fr);
                fragmentTransaction.commit();

            }
        });
        return rootView;

    }
}
