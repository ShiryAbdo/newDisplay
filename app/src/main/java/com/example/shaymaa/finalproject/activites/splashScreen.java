package com.example.shaymaa.finalproject.activites;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.shaymaa.finalproject.R;

import java.util.Timer;
import java.util.TimerTask;

public class splashScreen extends AppCompatActivity {
    private ProgressBar mProgress;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);




        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                splashScreen.this.runOnUiThread(new TimerTask() {
                    @Override
                    public void run() {
//
//                        sharedPref = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
//                        editor = sharedPref.edit();
//                        String emailShared = sharedPref.getString("email", "null");
//                        String passwordShared = sharedPref.getString("password", "null");
//                        String typeShared = sharedPref.getString("type", "null");
//
//                        if (!emailShared.equals("null")){
//                            checkLogin(emailShared, passwordShared, typeShared);
//
//                        }else {}

                        Intent intent = new Intent(splashScreen.this,   LOgActivty.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }, 2000);









    }



}
