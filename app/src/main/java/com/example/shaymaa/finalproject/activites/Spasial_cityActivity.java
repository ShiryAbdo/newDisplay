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
import com.example.shaymaa.finalproject.data.Spasial_Adaptor;
import com.example.shaymaa.finalproject.data.Spasial_JSONResponse;
import com.example.shaymaa.finalproject.data.Spasial_data;
import com.example.shaymaa.finalproject.data.Wahat_elmodin_Adaptor;
import com.example.shaymaa.finalproject.interfaces.Area_tqny_Interface;
import com.example.shaymaa.finalproject.interfaces.Spasial_Interface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Spasial_cityActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Spasial_data> data;
    private Spasial_Adaptor adapter ;
    ImageView go_back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spasial_city);

        initViews();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Spasial_cityActivity.this, Part_Industrial_cities.class);
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
        Spasial_Interface request = retrofit.create(Spasial_Interface.class);
        Call<Spasial_JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<Spasial_JSONResponse>() {
            @Override
            public void onResponse(Call<Spasial_JSONResponse> call, Response<Spasial_JSONResponse> response) {

                Spasial_JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getFactory()));
                adapter = new Spasial_Adaptor(data,Spasial_cityActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Spasial_JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Spasial_cityActivity.this, Part_Industrial_cities.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
