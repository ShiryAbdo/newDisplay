package com.example.shaymaa.finalproject.activites;

 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
 import android.text.TextUtils;
 import android.util.Log;
 import android.view.View;
 import android.webkit.WebView;
 import android.widget.EditText;
 import android.widget.ImageView;
 import android.widget.Toast;

 import com.android.volley.Request;
 import com.android.volley.RequestQueue;
 import com.android.volley.Response;
import com.android.volley.VolleyError;
 import com.android.volley.toolbox.JsonObjectRequest;
 import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.data.Adapter_recycle_commentes;
 import com.example.shaymaa.finalproject.data.Flower_Adaptor;
 import com.example.shaymaa.finalproject.data.Folwers_Data;
 import com.example.shaymaa.finalproject.data.Get_Data;
 import com.example.shaymaa.finalproject.data.Productes_Adaptor;
 import com.example.shaymaa.finalproject.data.Productes_data;
 import com.example.shaymaa.finalproject.data.Show_productis_data;
 import com.example.shaymaa.finalproject.others.MyTextView;

 import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class ProductesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Productes_data> data;
    private Productes_Adaptor adapter ;
    ImageView go_back ,image;
    Bundle bundle;
    MyTextView add_montage;
    String idi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productes);

        initViews();
        add_montage=(MyTextView)findViewById(R.id.add_montage);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // back to main activity
        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  ProductesActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });






        bundle=getIntent().getExtras();


        if (bundle!=null){

            idi= bundle.getString("id");
        }

        add_montage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(  ProductesActivity.this, AddProducts.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("company_id",idi);
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

        getAddsDtaied("2");
//
    }






    private void  getAddsDtaied (final String id ) {

        String url= "http://ksafactory.com/API/view_products/index.php?company=2";
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, url
                , null, new com.android.volley.Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Productes_data data =new Productes_data();
                ArrayList<Productes_data> addData = new ArrayList<>();

                try {
                    JSONArray company = response.getJSONArray("product");



                    for (int n = 0; n < company.length(); n++) {
                        JSONObject object = company.getJSONObject(n);
//                        data= new Productes_data(object.getString("product_id"),
//                                object.getString("product_title"),
//                                object.getString("product_image_name"),
//                                object.getString("product_service"),
//                                object.getString("username"),
//                                object.getString("date"));


                        addData.add(new Productes_data(object.getString("product_id"),
                                object.getString("product_title"),
                                object.getString("product_image_name"),
                                object.getString("product_service"),
                                object.getString("username"),
                                object.getString("date")));
                        adapter = new Productes_Adaptor(addData,ProductesActivity.this);

                    }



                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();





                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                //Notify adapter about data changes
                adapter.notifyDataSetChanged();
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




