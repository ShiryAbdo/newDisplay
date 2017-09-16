package com.example.shaymaa.finalproject.interfaces;

import com.example.shaymaa.finalproject.data.BankJSONResponse;
import com.example.shaymaa.finalproject.data.e3lanatData;
import com.example.shaymaa.finalproject.data.e3lanatJSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 29/08/17.
 */

public interface ApiInterfaceA3lanat {
    @GET("view_ads/index1.php?ads")
    Call<e3lanatJSONResponse> getJSON();
}
