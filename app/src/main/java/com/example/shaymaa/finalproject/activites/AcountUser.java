package com.example.shaymaa.finalproject.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;

public class AcountUser extends AppCompatActivity {
    TextView username ,notivication ,massage ,outtig,fevourt_adds,flowers ,setting_acount,add_adds,my_adds;

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
    }
}
