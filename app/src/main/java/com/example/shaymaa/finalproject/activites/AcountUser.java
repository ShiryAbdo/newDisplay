package com.example.shaymaa.finalproject.activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;

public class AcountUser extends AppCompatActivity {
    TextView username ,notivication ,massage ,outtig,fevourt_adds,flowers ,setting_acount,add_adds,my_adds;
    ImageView go_back ;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acount_user2);
        username=(TextView)findViewById(R.id.editText_nam);
        notivication=(TextView)findViewById(R.id.notivication);
        massage=(TextView)findViewById(R.id.massage);
        outtig=(TextView)findViewById(R.id.outtig);
        fevourt_adds=(TextView)findViewById(R.id.fevourt_adds);
        flowers=(TextView)findViewById(R.id.flowers);
        setting_acount=(TextView)findViewById(R.id.setting_acount);
        add_adds=(TextView)findViewById(R.id.add_adds);
        my_adds=(TextView)findViewById(R.id.my_adds);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AcountUser.this,  MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        setting_acount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), UpdateAcountUser.class);
                startActivity(intent);

            }
        });


        outtig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 sharedPref = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                editor = sharedPref.edit();
                editor.clear();
                editor.commit();


                Intent intent = new Intent(getApplicationContext(), LOgActivty.class);
                finish();
                startActivity(intent);
            }
        });


    }
}
