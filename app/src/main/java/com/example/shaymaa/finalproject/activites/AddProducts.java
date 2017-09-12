package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.others.AppController;

import java.util.HashMap;
import java.util.Map;

public class AddProducts extends AppCompatActivity {
     EditText title ,price,discount,service,freight,method,content;
    String myUrl;
    public static final String KEY_user_id = "user_id";
    public static final String KEY_product_id = "product_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        title=(EditText)findViewById(R.id.title);
        price=(EditText)findViewById(R.id.price);
        discount=(EditText)findViewById(R.id.discount);
        service=(EditText)findViewById(R.id.service);
        freight=(EditText)findViewById(R.id.title);
        method=(EditText)findViewById(R.id.method);
        method=(EditText)findViewById(R.id.content);



    }


    private void AddTPrductio(final String product_id , final String user_id)

    {



        Uri.Builder builder = new Uri.Builder();
//        "http://ksafactory.com/API/login/index.php?email=m@gmail.com&password=6666&type=1"
//        http://ksafactory.com/API/login/index.php
        builder.scheme("http")
                .authority("www.ksafactory.com")
                .appendPath("API")
                .appendPath("add_to_fav")
                .appendPath("index.php")
                .appendQueryParameter("product_id",product_id)
                .appendQueryParameter("user_id", user_id);

        myUrl= builder.build().toString();
        String tag_string_req = "req_register";




        StringRequest stringRequest = new StringRequest(Request.Method.GET, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(DetalisOfProduction_WitAdd.this,response,Toast.LENGTH_LONG).show();

//                        Toast.makeText( RegistrationUser.this, "this error",Toast.LENGTH_LONG).show();


                        startActivity(new Intent(getApplicationContext(),  MainActivity.class));


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(DetalisOfProduction_WitAdd.this,"errrrorrr",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_product_id,product_id);
                params.put(KEY_user_id,user_id);


                return params;
            }

        };






        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);



    }

}
