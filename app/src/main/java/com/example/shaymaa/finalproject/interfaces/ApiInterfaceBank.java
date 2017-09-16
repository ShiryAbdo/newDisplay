package com.example.shaymaa.finalproject.interfaces;

import com.example.shaymaa.finalproject.data.BankJSONResponse;
import com.example.shaymaa.finalproject.data.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by shirya on 29/08/17.
 */

public interface ApiInterfaceBank {

    @GET("banks/index.php?banks")
    Call<BankJSONResponse> getJSON();
}
