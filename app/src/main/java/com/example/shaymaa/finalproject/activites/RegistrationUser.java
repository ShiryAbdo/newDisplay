package com.example.shaymaa.finalproject.activites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shaymaa.finalproject.others.AppController;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.others.SQLiteHandler;
import com.example.shaymaa.finalproject.others.SessionManager;

import java.util.HashMap;
import java.util.Map;

public class RegistrationUser extends AppCompatActivity {
    Button register_as_singile ;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;
    private EditText editText_userName ,editText_email ,editText_phone ,editText_password ,editText_repassword;
    Spinner spinner_singil_register;
    CheckBox checkBox_agree;
    String myUrl;



    private static final String REGISTER_URL ="http://ksafactory.com/API/registration/index1.php";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONE = "mobile";
    public static final String kEY_CITY ="city";
    private static final String TAG =  "tage";
    String emailRegEx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration_user);
        editText_userName = (EditText) findViewById(R.id.editText_userName);
        editText_email = (EditText) findViewById(R.id.editText_email);
        editText_phone = (EditText) findViewById(R.id.editText_phone);
        editText_password = (EditText) findViewById(R.id.editText_password);
        editText_repassword = (EditText) findViewById(R.id.editText_repassword);
        spinner_singil_register = (Spinner) findViewById(R.id.spinner_singil_register);
        checkBox_agree = (CheckBox) findViewById(R.id.checkBox_agree);
        register_as_singile=(Button)findViewById(R.id.register_endifiual) ;
        emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";




        register_as_singile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText_userName.getText().toString().trim();
                String email = editText_email.getText().toString().trim();
                String mobile = editText_phone.getText().toString().trim();
                String password = editText_password.getText().toString().trim();
                String city = editText_password.getText().toString().trim();
                 if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()) {

                     if (editText_email.getText().toString().matches(emailRegEx) &&editText_email.getText().toString().length() > 0)
                     {

                         if(editText_password.getText().toString().trim().equals(editText_password.getText().toString().trim())){
                             registerUser(name, email, password, mobile, city);

                         }else {
                             Toast.makeText(getApplicationContext(), "كلمة المرور غير  متطابقة",Toast.LENGTH_LONG).show();
                         }


                         Toast.makeText(RegistrationUser.this, "تم التسجيل بنجاح" +name +email+password+mobile+city, Toast.LENGTH_SHORT).show();
                     }else {
                         Toast.makeText(getApplicationContext(),"الإيميل غير صالح",Toast.LENGTH_SHORT).show();
                     }

                } else {
                    Toast.makeText(getApplicationContext(), "!أضف البيانات", Toast.LENGTH_LONG).show();

                }
            }
        });



    }




    /**
     * Function to store user in MySQL database will post params(tag, name,
     * email, password) to register url
     * */
    private void registerUser(final String username, final String email,
                              final String password ,final String mobile ,final  String city) {

        Uri.Builder builder = new Uri.Builder();
//        "http://ksafactory.com/API/login/index.php?email=m@gmail.com&password=6666&type=1"
//        http://ksafactory.com/API/login/index.php
        builder.scheme("http")
                .authority("www.ksafactory.com")
                .appendPath("API")
                .appendPath("registration")
                .appendPath("index.php")
                .appendQueryParameter("username",editText_userName.getText().toString().trim())
                .appendQueryParameter("email", editText_email.getText().toString().trim())
                .appendQueryParameter("mobile",editText_phone.getText().toString().trim())
                .appendQueryParameter("city",editText_email.getText().toString().trim())
                .appendQueryParameter("password",editText_password.getText().toString().trim());
        myUrl= builder.build().toString();
        String tag_string_req = "req_register";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, myUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RegistrationUser.this,response,Toast.LENGTH_LONG).show();

//                        Toast.makeText( RegistrationUser.this, "this error",Toast.LENGTH_LONG).show();


                            startActivity(new Intent(getApplicationContext(),  LOgActivty.class));


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RegistrationUser.this,"errrrorrr",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(KEY_USERNAME,username);
                params.put(KEY_EMAIL,email);
                params.put(KEY_PHONE,mobile);
                params.put(kEY_CITY,password);
                params.put(KEY_PASSWORD,city);
                  return params;
            }

        };



        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }

    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}


