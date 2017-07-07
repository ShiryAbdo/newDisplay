package com.example.shaymaa.finalproject.activites;

 import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.data.Adapter_recycle_commentes;
import com.example.shaymaa.finalproject.data.Get_Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


public class ProductesActivity extends AppCompatActivity {
    RecyclerView recy;
    Adapter_recycle_commentes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("المنتجات");


        recy = (RecyclerView) findViewById(R.id.rec);
        get_data_fromdb();

    }

    ;


    private void get_data_fromdb() {
        StringRequest request = new StringRequest(Request.Method.POST, "http://homebussines.net/udemy_courses/like.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.contains("done")) {
                    data_convert(response);
                }

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(request);
    }

    void data_convert(String data) {
        List<Get_Data> Data_List = new ArrayList<>();
        try {
            byte[] u = data.getBytes("ISO-8859-1");
            data = new String(u, "UTF-8");
            JSONObject job = new JSONObject(data);
            JSONArray jsonArray = job.getJSONArray("done");
            Log.e("jsonarray", String.valueOf(jsonArray.length()));
            for (int i = 0; i <= jsonArray.length(); i++) {
                JSONObject jobjecte = jsonArray.getJSONObject(i);
                String id = jobjecte.getString("id");
                String thephoto = jobjecte.getString("photo");
                String photo = URLDecoder.decode(thephoto, "UTF-8");
                String like = jobjecte.getString("likeed");
                Get_Data data_opject = new Get_Data(id, like, photo);
                Data_List.add(data_opject);
            }
        } catch (JSONException e) {
            Log.e("ee", String.valueOf(e));
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            Log.e("ee2", String.valueOf(e));
            e.printStackTrace();
        }
        adapter = new Adapter_recycle_commentes(Data_List,ProductesActivity.this);
        recy.setLayoutManager(new GridLayoutManager(ProductesActivity.this, 2));
        adapter.notifyDataSetChanged();
        recy.setAdapter(adapter);
    }

}
