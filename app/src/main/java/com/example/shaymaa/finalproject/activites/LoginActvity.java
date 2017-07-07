package com.example.shaymaa.finalproject.activites;

import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;


public class LoginActvity extends AppCompatActivity   {
    TextView forget_password ,acount_new;
    Button loginbutton ;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_login );
        /////////////////////////////***///////////////////////////

        loginbutton = (Button)findViewById(R.id.loginbutton);



        forget_password = (TextView)findViewById(R.id.forgetpassword);
        acount_new=(TextView)findViewById(R.id.acount_new);
        forget_password.setPaintFlags(forget_password.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        acount_new.setPaintFlags(acount_new.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new  Intent(getApplicationContext() ,MainActivity.class);
                startActivity(intent);
            }
        });



        acount_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent =new  Intent(getApplicationContext() , RegistrationUser.class);
//                startActivity(intent);

                // close existing dialog fragments
                FragmentManager manager = getFragmentManager();
                Fragment frag = manager.findFragmentByTag("fragment_edit_name");
                if (frag != null) {
                    manager.beginTransaction().remove(frag).commit();
                }


                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);
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

                dialog.show();
            }


        });





////////////////////////////////////////////////////////////
    }


}
