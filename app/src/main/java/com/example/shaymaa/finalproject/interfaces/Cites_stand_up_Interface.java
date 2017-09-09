package com.example.shaymaa.finalproject.interfaces;

import com.example.shaymaa.finalproject.data.Area_tqny_JSONResponse;
import com.example.shaymaa.finalproject.data.Cites_stand_up_JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 09/09/17.
 */

public interface Cites_stand_up_Interface {
    @GET("factories_categories/index.php?factory_type")
    Call<Cites_stand_up_JSONResponse> getJSON();
}
