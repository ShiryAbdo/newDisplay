package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.others.MyTextView;
import com.squareup.picasso.Picasso;

public class CitiesDetails extends AppCompatActivity {
     ImageView  city_image_name;
    MyTextView  space,discription,city,titel;
    ImageView go_back ;
    Bundle bundle;
    String imageUr,Factory_space,Factory_title,contant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities_details);
        bundle=getIntent().getExtras();

        if (bundle!=null){

            imageUr= bundle.getString("imageUr");
            Factory_space=bundle.getString("Factory_space");
            Factory_title=bundle.getString("Factory_title");
            contant=bundle.getString("contant");
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CitiesDetails.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        city_image_name=(ImageView)findViewById(R.id.city_image_name);
        space=(MyTextView)findViewById(R.id.space);
        city=(MyTextView)findViewById(R.id.city);
        titel=(MyTextView)findViewById(R.id.titel);
        discription=(MyTextView)findViewById(R.id.discription);
        Picasso.with(this).load(imageUr).error(android.R.drawable.stat_notify_error).fit().into(city_image_name);
        space.setText(Factory_space);
        discription.setText(contant);
        titel.setText(Factory_title);
//        city.setText(city);
//


    }
}
