package com.example.shaymaa.finalproject.activites;

  import android.content.Intent;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.util.Log;
  import android.view.View;
  import android.widget.Button;
  import android.widget.EditText;
  import android.widget.Toast;

  import com.example.shaymaa.finalproject.R;
 import com.example.shaymaa.finalproject.maps.CountinuAdding;

public class addFactory extends AppCompatActivity {

    Button cuttong_adding  ,cuttongadding;

    EditText name_of_onwe , name_of_factory, telphone_of_factory,phone_numbe, email_adress,
            what_is_producted  ,site;
     String  emailRegEx;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_factory);
        cuttong_adding =(Button)findViewById(R.id.cuttong_adding);
        name_of_onwe=(EditText)findViewById(R.id.name_of_onwe);
        name_of_factory=(EditText)findViewById(R.id.name_of_factory);
        telphone_of_factory=(EditText)findViewById(R.id.telphone_of_factory);
        phone_numbe=(EditText)findViewById(R.id.phone_numbe);
        email_adress=(EditText)findViewById(R.id.email_adress);
        what_is_producted=(EditText)findViewById(R.id.what_is_producted);
        cuttongadding=(Button)findViewById(R.id.cuttongadding);
        site=(EditText)findViewById(R.id.site);
        emailRegEx = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";
//
        cuttongadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),email_adress.getText().toString(),Toast.LENGTH_SHORT).show();

 if (email_adress.getText().toString().matches(emailRegEx) && email_adress.getText().toString().length() > 0)
                {
                    Intent intent = new Intent(addFactory.this,CuntinoAddTWO.class);
                    intent.putExtra("name_of_onwe",name_of_onwe.getText().toString().trim());
                    intent.putExtra("name_of_factory",name_of_factory.getText().toString().trim());
                    intent.putExtra("telphone_of_factory",telphone_of_factory.getText().toString().trim());
                    intent.putExtra("phone_numbe",phone_numbe.getText().toString().trim());
                    intent.putExtra("email_adress",email_adress.getText().toString().trim());
                    intent.putExtra("what_is_producted",what_is_producted.getText().toString().trim());
                    intent.putExtra("site",site.getText().toString().trim());
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"الإيميل غير صالح",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent( addFactory.this,  wasffWithTabb.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
