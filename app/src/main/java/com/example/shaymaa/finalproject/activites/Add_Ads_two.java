package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shaymaa.finalproject.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.shaymaa.finalproject.R.id.spinner;

public class Add_Ads_two extends AppCompatActivity {
    Spinner chose_part_dasteris ,chose_class_add,type_shope_in_dasters;
    EditText add_contentt;
    Button cuttongadding ;
    List<String> categories;
    String item_type_shope_in_dasters;
    String item_chose_class_add;
    String item_chose_part_dasteris;
    Bundle bundle;
    String add_title,add_price,add_content,image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__ads_two);
        chose_part_dasteris =(Spinner)findViewById(R.id.chose_part_dasteris);
        chose_class_add =(Spinner)findViewById(R.id.chose_class_add);
        type_shope_in_dasters =(Spinner)findViewById(R.id.type_shope_in_dasters);
        add_contentt=(EditText)findViewById(R.id.add_content);
        cuttongadding=(Button)findViewById(R.id.cuttongadding);



        bundle=getIntent().getExtras();


        if (bundle!=null){

            add_title= bundle.getString("add_title");
             add_price=bundle.getString("add_price");
            add_content=bundle.getString("add_content");
            image=bundle.getString("image");
        }





        // Spinner Drop down elements
        categories= new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

     ;

        // Spinner click listener
        chose_part_dasteris.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                // On selecting a spinner item
                item_chose_part_dasteris= parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item_chose_part_dasteris, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // attaching data adapter to spinner
        chose_part_dasteris.setAdapter(dataAdapter);



        // Spinner click listener
        chose_class_add.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                // On selecting a spinner item
                item_chose_class_add = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item_chose_class_add, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // attaching data adapter to spinner
        chose_class_add.setAdapter(dataAdapter);


        // Spinner click listener
        type_shope_in_dasters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {

                // On selecting a spinner item
                item_type_shope_in_dasters= parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item_type_shope_in_dasters, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // attaching data adapter to spinner
        type_shope_in_dasters.setAdapter(dataAdapter);





        cuttongadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add_contentt.getText().toString().trim().length() > 0){
                    Intent intent =new Intent(Add_Ads_two.this,Add_Ads_three.class);
                    intent.putExtra("add_title",add_title);
                    intent.putExtra("add_price",add_price);
                    intent.putExtra("add_content",add_content);
                    intent.putExtra("image",image);
                    intent.putExtra("item_type_shope_in_dasters",item_type_shope_in_dasters);
                    intent.putExtra("item_chose_class_add",item_chose_class_add);
                    intent.putExtra("item_chose_part_dasteris",item_chose_part_dasteris);
                    intent.putExtra("add_contentt",add_contentt.getText().toString());
                }


            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( Add_Ads_two.this,   Add_Ads.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
