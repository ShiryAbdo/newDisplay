package com.example.shaymaa.finalproject.activites;

 import android.content.Intent;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.util.Log;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.EditText;
 import android.widget.Spinner;
 import android.widget.Toast;
 import android.widget.AdapterView.OnItemSelectedListener;

 import com.example.shaymaa.finalproject.R;

 import java.util.ArrayList;
 import java.util.List;

public class RegistrationCompany extends AppCompatActivity  implements OnItemSelectedListener {
 EditText name_user, email_user,phone_user,name_comany_arabick,name_comany_english;

    String item;
    Spinner spinner;
    String emailRegEx ;
    Button register_as_moassa ;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String emails ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_company_frist);
        register_as_moassa= (Button)findViewById(R.id.register_as_moassa);


        name_user=(EditText)findViewById(R.id.name_user);
        email_user=(EditText)findViewById(R.id.email_user);
        phone_user=(EditText)findViewById(R.id.phone_user);
        name_comany_arabick=(EditText)findViewById(R.id.name_comany_arabick);
        name_comany_english=(EditText)findViewById(R.id.name_comany_english);
        emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";

        spinner= (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("الرياض");
        categories.add("الدوحه");
        categories.add("مكه");
        categories.add("المدينه");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

      emails =email_user.getText().toString().trim();




        register_as_moassa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), email_user.getText().toString().trim(),Toast.LENGTH_SHORT).show();

                if ( email_user.getText().toString().trim().matches(emailRegEx) && email_user.getText().toString().trim().length() > 0)
                {
                    Intent intent=new Intent(RegistrationCompany.this,RegisterCompletTwo.class);
                    intent.putExtra("name_of_comapy",name_user.getText().toString().trim());
                    intent.putExtra("email_of_comapy",email_user.getText().toString().trim());
                    intent.putExtra("phone_of_comapy",phone_user.getText().toString().trim());
                    intent.putExtra("name_comany_arabick",name_comany_arabick.getText().toString().trim());
                    intent.putExtra("name_comany_english",name_comany_english.getText().toString().trim());
                    intent.putExtra("item_spinner",item);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"الإيميل غير صالح",Toast.LENGTH_SHORT).show();
                }



            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(  RegistrationCompany.this,  LOgActivty.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
