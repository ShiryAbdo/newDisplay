package com.example.shaymaa.finalproject.activites;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shaymaa.finalproject.R;

import java.io.ByteArrayOutputStream;

public class Add_Ads extends AppCompatActivity {
     EditText add_title ,add_price,add_content;
    ImageView add_image ;
    Button cuttongadding;

    Intent intent;
    String[] FILE;
    private static int IMG_RESULT = 1;
    String ImageDecode,imageByte ;
    Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__ads);
        add_title=(EditText)findViewById(R.id.add_title);
        add_price=(EditText)findViewById(R.id.add_price);
        add_content=(EditText)findViewById(R.id.add_content);
        add_image=(ImageView)findViewById(R.id.add_image);
        cuttongadding=(Button)findViewById(R.id.cuttongadding);
        add_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMG_RESULT);
            }
        });


        cuttongadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( add_title.getText().toString().trim().length() > 0&&
                        add_price.getText().toString().trim().length() > 0&&
                        add_content.getText().toString().trim().length() > 0){

                    Intent intent = new Intent(Add_Ads.this,Add_Ads_two.class);
                    intent.putExtra("add_title",add_title.getText().toString());
                    intent.putExtra("add_price",add_price.getText().toString());
                    intent.putExtra("add_content",add_content.getText().toString().toString().trim());
                    intent.putExtra("image",imageByte);

                    startActivity(intent);
                }

            }
        });

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {

            if (requestCode == IMG_RESULT && resultCode == RESULT_OK
                    && null != data) {


                Uri URI = data.getData();
                String[] FILE = { MediaStore.Images.Media.DATA };


                Cursor cursor = getContentResolver().query(URI,
                        FILE, null, null, null);

                cursor.moveToFirst();

                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), URI);
                imageByte=getStringImage(bitmap);
                 add_image.setImageBitmap(bitmap);

                int columnIndex = cursor.getColumnIndex(FILE[0]);
                ImageDecode = cursor.getString(columnIndex);
                cursor.close();
//
//                image.setImageBitmap(BitmapFactory
//                        .decodeFile(ImageDecode));

//                Toast.makeText(this, columnIndex+"", Toast.LENGTH_LONG)
//                        .show();

            }
        } catch (Exception e) {
            Toast.makeText(this, "Please try again", Toast.LENGTH_LONG)
                    .show();
        }

    }


    public String getStringImage(Bitmap bitmap){
        Log.i("MyHitesh",""+bitmap);
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);


        return temp;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent( Add_Ads.this,  MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
