package com.example.shaymaa.finalproject.activites;

  import android.content.Intent;
  import android.support.v7.app.AppCompatActivity;
  import android.os.Bundle;
  import android.view.View;
  import android.widget.Button;

 import com.example.shaymaa.finalproject.R;
 import com.example.shaymaa.finalproject.maps.CountinuAdding;

public class addFactory extends AppCompatActivity {

    Button cuttong_adding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_factory);
        cuttong_adding =(Button)findViewById(R.id.cuttong_adding);


        cuttong_adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addFactory.this, CountinuAdding.class);
                startActivity(intent);
            }
        });
    }
}
