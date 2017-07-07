package com.example.shaymaa.finalproject.data;

import retrofit2.http.GET;

/**
 * Created by Shaymaa on 7/3/2017.
 */

public class Get_Data {
    public String Like_Stat;
    public String post_Id;
    public String photo_link;
    public Get_Data(String Like){
        Like_Stat=Like;
    }
    public Get_Data(String id, String like,String photo){
        post_Id=id;
        Like_Stat=like;
        photo_link=photo;

    }
}
