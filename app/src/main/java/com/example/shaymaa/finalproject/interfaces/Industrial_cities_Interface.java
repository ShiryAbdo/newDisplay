package com.example.shaymaa.finalproject.interfaces;

 import com.example.shaymaa.finalproject.data.IndustrialJSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 31/08/17.
 */

public interface Industrial_cities_Interface {

    @GET("factories/index1.php?factories ")
    Call<IndustrialJSONResponse> getJSON();
}
