package com.example.shaymaa.finalproject.activites;

 import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.fragments.AddFactoryTwo;
import com.example.shaymaa.finalproject.fragments.RegisterCompletTwo;

public class addFactory extends AppCompatActivity {

    Button cuttong_adding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_factory);
        cuttong_adding =(Button)findViewById(R.id.cuttong_adding);
        cuttong_adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFactoryTwo fr = new AddFactoryTwo();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.container, fr);
                fragmentTransaction.commit();
            }
        });
    }
}
