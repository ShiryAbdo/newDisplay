package com.example.shaymaa.finalproject.interfaces;

import com.example.shaymaa.finalproject.data.Area_tqny_JSONResponse;
import com.example.shaymaa.finalproject.data.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 09/09/17.
 */

public interface Area_tqny_Interface {

    @GET("factories_categories/index2.php?factory_type")
    Call<Area_tqny_JSONResponse> getJSON();
}


