package com.example.shaymaa.finalproject.activites;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.activites.MainActivity;
import com.example.shaymaa.finalproject.maps.CountinuAdding;

import java.util.ArrayList;
import java.util.List;


public class AddFactoryThree extends AppCompatActivity  {
    Button cuttong_adding ;
    Spinner spinner1 ,spinner2 ,spinner3,spinner4;
    String spinner1_item  ,spinner2_item,spinner3_item ,spinner4_item;
    EditText discraption;
    Bundle bundle;

    String name_of_onwe,name_of_factory,telphone_of_factory,phone_numbe,email_adress,what_is_producted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.continue_add_factory_three);
        cuttong_adding =(Button)findViewById(R.id.cuttong_adding);


        bundle=getIntent().getExtras();
        if(bundle!=null){
            name_of_onwe=bundle.getString("name_of_onwe");
            name_of_factory=bundle.getString("name_of_factory");
            telphone_of_factory=bundle.getString("telphone_of_factory");
            phone_numbe=bundle.getString("phone_numbe");
            email_adress=bundle.getString("email_adress");
            what_is_producted=bundle.getString("what_is_producted");
        }



//

//

//
//        cuttong_adding.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                Intent intent=new Intent(AddFactoryThree.this,CountinuAdding.class);
//                intent.putExtra("city",spinner1_item);
//                intent.putExtra("facebook", spinner2_item);
//                intent.putExtra("twitter", spinner3_item );
//                intent.putExtra("instegrame",spinner4_item);
//                intent.putExtra("image",discraption.getText().toString().trim());
//
//
//
//                intent.putExtra("name_of_onwe",name_of_onwe);
//                intent.putExtra("name_of_factory",name_of_factory);
//                intent.putExtra("telphone_of_factory",telphone_of_factory);
//                intent.putExtra("phone_numbe",phone_numbe);
//                intent.putExtra("email_adress",email_adress);
//                intent.putExtra("what_is_producted",what_is_producted);
//                startActivity(intent);
//
//            }
//        });
//





    }



}
