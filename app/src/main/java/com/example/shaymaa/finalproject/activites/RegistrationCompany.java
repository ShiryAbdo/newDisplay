package com.example.shaymaa.finalproject.activites;

 import android.app.FragmentTransaction;
 import android.support.v7.app.AppCompatActivity;
 import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.fragments.RegisterCompletTwo;

public class RegistrationCompany extends AppCompatActivity {


    Button register_as_moassa ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_company_frist);
        register_as_moassa= (Button)findViewById(R.id.register_as_moassa);
        register_as_moassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterCompletTwo fr = new RegisterCompletTwo();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.container, fr);
                fragmentTransaction.commit();
            }
        });


    }
}
