package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.data.Elmonshat_modafa_Adaptor;
import com.example.shaymaa.finalproject.data.Elmonshat_modafa_Data;
import com.example.shaymaa.finalproject.data.Flower_Adaptor;
import com.example.shaymaa.finalproject.data.Folwers_Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Elmonshat_modafa extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Elmonshat_modafa_Data> data;
    private Elmonshat_modafa_Adaptor adapter ;
    ImageView go_back;
    Bundle bundle;
    String idi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elmonshat_modafa);
        initViews();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  Elmonshat_modafa.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        bundle=getIntent().getExtras();


        if (bundle!=null){

            idi= bundle.getString("id");
        }
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        getAddsDtaied("1");

    }



    private void  getAddsDtaied (final String id )
    {

        String url= "http://ksafactory.com/API/company_by_user/index.php?user_id="+id;
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url
                , null, new com.android.volley.Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Elmonshat_modafa_Data data = new Elmonshat_modafa_Data();
                ArrayList<Elmonshat_modafa_Data> data22= new ArrayList<>();

                try {
                    JSONArray company = response.getJSONArray("company");

                    for (int n = 0; n < company.length(); n++) {
                        JSONObject object = company.getJSONObject(n);
                        data= new Elmonshat_modafa_Data(object.getString("company_id"),
                                object.getString("company_name"),object.getString("company_image_name"));

                        data22.add(data);

                    }


                    adapter = new Elmonshat_modafa_Adaptor(data22,Elmonshat_modafa.this);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();





                } catch (JSONException e) {
                    e.printStackTrace();
                }



            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }




}
