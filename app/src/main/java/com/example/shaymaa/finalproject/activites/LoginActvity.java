package com.example.shaymaa.finalproject.activites;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.shaymaa.finalproject.AppConfig;
import com.example.shaymaa.finalproject.AppController;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.SQLiteHandler;
import com.example.shaymaa.finalproject.SessionManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActvity extends AppCompatActivity   {
    private static final String TAG =  "tage";
    TextView forget_password ,acount_new;
    EditText editText_email ,editText2_password ;
    Button loginbutton ;
    final Context context = this;
    private ProgressDialog pDialog;
    private SessionManager session;
    private SQLiteHandler db;
     public  String username  ,emaili ,passwordd  , uid ,type  ,myUrl ;

    CheckBox moasa_chekBox ,singelCheckBox;
     SharedPreferences.Editor editor;
     SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_login );
        editText2_password=(EditText)findViewById(R.id.editText2_password);
        editText_email=(EditText)findViewById(R.id.editText_email) ;
        moasa_chekBox=(CheckBox) findViewById(R.id.moasa_chekBox);
        singelCheckBox=(CheckBox)findViewById(R.id.singelCheckBox);
        sharedPref = getApplicationContext().getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        if( moasa_chekBox.isChecked()){
            type="2";
        }if (singelCheckBox.isChecked()){
            type="1";
        }


        String emailShared = sharedPref.getString("email", "null");
        String passwordShared = sharedPref.getString("password", "null");
        String typeShared = sharedPref.getString("type", "null");
        final SharedPreferences.Editor editor = sharedPref.edit();




        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // SQLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // Session manager
        session = new SessionManager(getApplicationContext());

        // Check if user is already logged in or not
        if (session.isLoggedIn()) {
            // User is already logged in. Take him to main activity
            Intent intent = new Intent( LoginActvity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        /////////////////////////////***///////////////////////////

        loginbutton = (Button)findViewById(R.id.loginbutton);
        forget_password = (TextView)findViewById(R.id.forgetpassword);
        acount_new=(TextView)findViewById(R.id.acount_new);
        forget_password.setPaintFlags(forget_password.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        acount_new.setPaintFlags(acount_new.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);



        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActvity.this,ForgetPassword.class);
                startActivity(intent);

            }
        });

        acount_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // close existing dialog fragments
                FragmentManager manager = getFragmentManager();
                Fragment frag = manager.findFragmentByTag("fragment_edit_name");
                if (frag != null) {
                    manager.beginTransaction().remove(frag).commit();
                }

//                R.style.custom_dialog_theme

                // custom dialog
                final Dialog dialog = new Dialog(LoginActvity.this,R.style.custom_dialog_theme);
                dialog.setContentView(R.layout.custom);

//                requestWindowFeature(Window.FEATURE_NO_TITLE);
                 // set the custom dialog components - text, image and button
                Button as_moassa = (Button) dialog.findViewById(R.id.as_moassa);
                // if button is clicked, close the custom dialog
                as_moassa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),RegistrationCompany.class);
                        startActivity(intent);
//                        dialog.dismiss();
                    }
                });


                Button as_singel = (Button) dialog.findViewById(R.id.as_singel);
                // if button is clicked, close the custom dialog
                as_singel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),RegistrationUser.class);
                        startActivity(intent);
//                        dialog.dismiss();
                    }
                });

//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();


            }


        });





////////////////////////////////////////////////////////////
    }



    /**
     * function to verify login details in mysql db
     * */
    private void checkLogin(final String email, final String password) {
        // Tag used to cancel the request
        String tag_string_req = "req_login";

//        pDialog.setMessage("Logging in ...");

//        showDialog();


             Uri.Builder builder = new Uri.Builder();
//        "http://ksafactory.com/API/login/index.php?email=m@gmail.com&password=6666&type=1"
//        http://ksafactory.com/API/login/index.php
                 builder.scheme("http")
                .authority("www.ksafactory.com")
                .appendPath("API")
                .appendPath("login")
                .appendPath("index.php")
                .appendQueryParameter("email",editText_email.getText().toString().trim())
                .appendQueryParameter("password",editText2_password.getText().toString().trim())
                .appendQueryParameter("type",type);
                 myUrl= builder.build().toString();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,myUrl
               , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                hideDialog();
                try {
                    JSONArray user = response.getJSONArray("login");
                    // Error in login. Get the error message
                    Toast.makeText(getApplicationContext(),
                            "recuest", Toast.LENGTH_LONG).show();

                    for(int n = 0; n < user.length(); n++)
                    {
                        JSONObject object = user.getJSONObject(n);
                        username  =object.getString("username");
                        emaili =object.getString("email");
                        passwordd =object.getString("password");
                        uid= object.getString("user_id");
                        type=object.getString("type");

                      }
//                      if (uid!=null){
//
//                          session.setLogin(true);


                          // Inserting row in users table
                          db.addUser(username, emaili, uid, passwordd);
                          Toast.makeText(getApplicationContext(),
                                  "login ", Toast.LENGTH_LONG).show();

                          // Launch main activity
                          Intent intent = new Intent( LoginActvity.this,
                                  MainActivity.class);
                    editor.putString("email", emaili);
                    editor.putString("password", passwordd);
                    editor.putString("type", type);

                    editor.commit();
                          startActivity(intent);
                          finish();
//                      }    else {
                    // Error in login. Get the error message
//                     Toast.makeText(getApplicationContext(),
//                             "ceart acount", Toast.LENGTH_LONG).show();
//                }



                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);
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
