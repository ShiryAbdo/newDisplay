package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.data.Area_tqny_Adaptor;
import com.example.shaymaa.finalproject.data.Area_tqny_JSONResponse;
import com.example.shaymaa.finalproject.data.Area_tqny_data;
import com.example.shaymaa.finalproject.data.Cites_stand_up_JSONResponse;
import com.example.shaymaa.finalproject.data.cites_stand_up_Adaptor;
import com.example.shaymaa.finalproject.data.cites_stand_up_data;
import com.example.shaymaa.finalproject.interfaces.Area_tqny_Interface;
import com.example.shaymaa.finalproject.interfaces.Cites_stand_up_Interface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cites_stand_upActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<cites_stand_up_data> data;
    private cites_stand_up_Adaptor adapter ;
    ImageView go_back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cites_stand_up);
        initViews();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Cites_stand_upActivity.this, Part_Industrial_cities.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }


    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        loadJSON();
    }



    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ksafactory.com/API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Cites_stand_up_Interface request = retrofit.create(Cites_stand_up_Interface.class);
        Call<Cites_stand_up_JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<Cites_stand_up_JSONResponse>() {
            @Override
            public void onResponse(Call<Cites_stand_up_JSONResponse> call, Response<Cites_stand_up_JSONResponse> response) {

                Cites_stand_up_JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getfactory()));
                adapter = new cites_stand_up_Adaptor(data, Cites_stand_upActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Cites_stand_up_JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Cites_stand_upActivity.this, Part_Industrial_cities.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
