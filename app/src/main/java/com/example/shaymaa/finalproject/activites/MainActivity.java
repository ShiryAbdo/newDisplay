package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.shaymaa.finalproject.R;

public class MainActivity extends AppCompatActivity {


    LinearLayout productesImage_layout ,layou_factory ,layout_singel_register  ,layout_moassa_register,layot_factory_parts,layout_supports;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

//
        productesImage_layout= (LinearLayout)findViewById(R.id.productesImage_layout);
        productesImage_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ProductesActivity.class);
                startActivity(intent);

            }
        });
//
        layou_factory= (LinearLayout)findViewById(R.id.layou_factory);
        layou_factory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SoadyFactory.class);
                startActivity(intent);

            }
        });
//
        layout_singel_register= (LinearLayout)findViewById(R.id.layout_singel_register);
        layout_singel_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),  RegistrationUser.class);
                startActivity(intent);

            }
        });
//
        layout_moassa_register= (LinearLayout)findViewById(R.id.layout_moassa_register);

        layout_moassa_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),   RegistrationCompany.class);
                startActivity(intent);

            }
        });
//
        layot_factory_parts= (LinearLayout)findViewById(R.id.layot_factory_parts);

        layot_factory_parts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),    FactoryParts.class);
                startActivity(intent);

            }
        });

//
        layout_supports= (LinearLayout)findViewById(R.id.layout_supports);

        layout_supports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SupportActivity.class);
                startActivity(intent);

            }
        });
    }
}
