package com.example.shaymaa.finalproject.activites;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.shaymaa.finalproject.AppController;
import com.example.shaymaa.finalproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LOgActivty extends AppCompatActivity {
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    EditText editText_email, editText2_password;
    Button loginbutton;
    CheckBox moasa_chekBox, singelCheckBox;
    public String username, emaili, passwordd, uid, type, myUrl;
    TextView forget_password, acount_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_login);
        editText2_password = (EditText) findViewById(R.id.editText2_password);
        editText_email = (EditText) findViewById(R.id.editText_email);
        moasa_chekBox = (CheckBox) findViewById(R.id.moasa_chekBox);
        singelCheckBox = (CheckBox) findViewById(R.id.singelCheckBox);
        loginbutton = (Button) findViewById(R.id.loginbutton);

//        if (moasa_chekBox.isChecked()) {
            type = "2";
//        }
//        if (singelCheckBox.isChecked()) {
            type = "1";
//        }


        loginbutton = (Button) findViewById(R.id.loginbutton);


        forget_password = (TextView) findViewById(R.id.forgetpassword);
        acount_new = (TextView) findViewById(R.id.acount_new);
        forget_password.setPaintFlags(forget_password.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        acount_new.setPaintFlags(acount_new.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(),
                        " Click", Toast.LENGTH_LONG)
                        .show();
                String email = editText_email.getText().toString().trim();
                String password = editText2_password.getText().toString().trim();
                // Check for empty data in the form
                if (!email.isEmpty() && !password.isEmpty()) {
                    Toast.makeText(getApplicationContext(),
                            "passs", Toast.LENGTH_LONG)
                            .show();
                    // login user
                    checkLogin(email, password, type);
                } else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext(),
                            "Please enter the credentials!", Toast.LENGTH_LONG)
                            .show();
                }

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
                final Dialog dialog = new Dialog(LOgActivty.this, R.style.custom_dialog_theme);
                dialog.setContentView(R.layout.custom);

//                requestWindowFeature(Window.FEATURE_NO_TITLE);
                // set the custom dialog components - text, image and button
                Button as_moassa = (Button) dialog.findViewById(R.id.as_moassa);
                // if button is clicked, close the custom dialog
                as_moassa.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), RegistrationCompany.class);
                        startActivity(intent);
//                        dialog.dismiss();
                    }
                });


                Button as_singel = (Button) dialog.findViewById(R.id.as_singel);
                // if button is clicked, close the custom dialog
                as_singel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), RegistrationUser.class);
                        startActivity(intent);
//                        dialog.dismiss();
                    }
                });

//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.show();


            }


        });

    }

    private void checkLogin(String email, String password, String typee) {
//        Toast.makeText(getApplicationContext(),
//                "colled", Toast.LENGTH_LONG).show();

        Uri.Builder builder = new Uri.Builder();
//        "http://ksafactory.com/API/login/index.php?email=m@gmail.com&password=6666&type=1"
//        http://ksafactory.com/API/login/index.php
        builder.scheme("http")
                .authority("www.ksafactory.com")
                .appendPath("API")
                .appendPath("login")
                .appendPath("index.php")
                .appendQueryParameter("email", editText_email.getText().toString().trim())
                .appendQueryParameter("password", editText2_password.getText().toString().trim())
                .appendQueryParameter("type", type);
        myUrl = builder.build().toString();
        Toast.makeText(getApplicationContext(),
                myUrl, Toast.LENGTH_LONG).show();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, myUrl
                , null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(getApplicationContext(),
                        "recuest" +response , Toast.LENGTH_LONG).show();
                 try {
                    JSONArray user = response.getJSONArray("login");
                    // Error in login. Get the error message
                    Toast.makeText(getApplicationContext(),
                            "recuest", Toast.LENGTH_LONG).show();

                    for (int n = 0; n < user.length(); n++) {
                        JSONObject object = user.getJSONObject(n);
                        username = object.getString("username");
                        emaili = object.getString("email");
                        passwordd = object.getString("password");
                        uid = object.getString("user_id");
                        type = object.getString("type");

                    }

                    Toast.makeText(getApplicationContext(),
                            "ceart acount", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LOgActivty.this,
                            MainActivity.class);
                    startActivity(intent);
                    finish();


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
            }
        });

        // Adding request to request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
//        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }



}