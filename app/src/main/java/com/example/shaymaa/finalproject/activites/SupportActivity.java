package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shaymaa.finalproject.AppController;
import com.example.shaymaa.finalproject.R;

import java.util.HashMap;
import java.util.Map;

public class SupportActivity extends AppCompatActivity {
    ImageView go_back ;
    TextView editText_nam , editText_phone, editText_email, editText_address,contain_massge;
    Button sed_button;
    String name,phone ,email ,address,massage ,myUrl;


    public static final String KEY_name = "name";
    public static final String KEY_phone = "mobile";
    public static final String KEY_email = "message_title";
    public static final String KEY_address = "message_title";
    public static final String kEY_massage ="content";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        editText_nam=(TextView)findViewById(R.id.editText_nam) ;
        editText_phone=(TextView)findViewById(R.id.editText_phone) ;
        editText_email=(TextView)findViewById(R.id.editText_email) ;
        editText_address=(TextView)findViewById(R.id.editText_address) ;
        contain_massge=(TextView)findViewById(R.id.contain_massge) ;



        sed_button=( Button) findViewById(R.id.sed_button) ;

        name= editText_nam.getText().toString().trim();
        phone= editText_phone.getText().toString().trim();
        email= editText_email.getText().toString().trim();
        address= editText_address.getText().toString().trim();
        massage= contain_massge.getText().toString().trim();

        go_back =(ImageView)findViewById(R.id.go_back);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupportActivity.this,    MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        sed_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()&&!email.isEmpty()&&!massage.isEmpty()) {

                    senData(name, phone, email, address, massage);

                }else {
                    Toast.makeText(getApplicationContext(), "details!", Toast.LENGTH_LONG).show();

                }

            }
        });

    }




    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     * */
    private void  senData (final String  namee, final String  phonee,
                              final String   emaile,final String   adresse ,final  String  massagee) {

        Uri.Builder builder = new Uri.Builder();
//        "http://ksafactory.com/API/login/index.php?email=m@gmail.com&password=6666&type=1"
//        http://ksafactory.com/API/login/index.php
        builder.scheme("http")
                .authority("www.ksafactory.com")
                .appendPath("API")
                .appendPath("contact_us/")
                .appendPath("index.php")
                .appendQueryParameter("name",namee)
                .appendQueryParameter("mobile", phonee)
                .appendQueryParameter("message_title",adresse)
                .appendQueryParameter("email",emaile)
                .appendQueryParameter("content",massagee) ;
         myUrl= builder.build().toString();
        String tag_string_req = "req_register";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText( SupportActivity.this,response,Toast.LENGTH_LONG).show();

//                        Toast.makeText( RegistrationUser.this, "this error",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SupportActivity.this,"errrrorrr",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_name,namee);
                params.put(KEY_phone,phonee);
                params.put(KEY_email, emaile);
                params.put(KEY_address,adresse);
                params.put(kEY_massage,massagee);
                 return params;
            }

        };






        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }
}
