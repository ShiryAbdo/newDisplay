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
import com.example.shaymaa.finalproject.data.DataAdapter;
 import com.example.shaymaa.finalproject.data.JSONResponse;
import com.example.shaymaa.finalproject.data.e3lanatData;
import com.example.shaymaa.finalproject.data.e3lanatDataAdaptor;
import com.example.shaymaa.finalproject.data.e3lanatJSONResponse;
import com.example.shaymaa.finalproject.interfaces.ApiInterfaceA3lanat;
import com.example.shaymaa.finalproject.interfaces.RequestInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class e3lanatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<e3lanatData> data;
    private e3lanatDataAdaptor adapter ;
    ImageView go_back ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e3lanat);

        initViews();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(e3lanatActivity.this,  MainActivity.class);
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
        ApiInterfaceA3lanat request = retrofit.create(ApiInterfaceA3lanat.class);
        Call<e3lanatJSONResponse> call = request.getJSON();
        call.enqueue(new Callback<e3lanatJSONResponse>() {
            @Override
            public void onResponse(Call<e3lanatJSONResponse> call, Response<e3lanatJSONResponse> response) {

                e3lanatJSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.geAds()));
                adapter = new e3lanatDataAdaptor(data,e3lanatActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<e3lanatJSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
