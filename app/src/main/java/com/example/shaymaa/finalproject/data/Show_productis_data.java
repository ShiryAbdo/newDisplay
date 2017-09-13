package com.example.shaymaa.finalproject.data;

/**
 * Created by shirya on 13/09/17.
 */

public class Show_productis_data {


    private String product_id ;
    private String product_title ;
    private String product_image_name ;
    private String product_service ;
    private String username ;
    private String date ;


    public Show_productis_data(String product_id, String product_title, String product_image_name, String product_service, String username, String date) {
        this.product_id = product_id;
        this.product_title = product_title;
        this.product_image_name = product_image_name;
        this.product_service = product_service;
        this.username = username;
        this.date = date;
    }


    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public void setProduct_image_name(String product_image_name) {
        this.product_image_name = product_image_name;
    }

    public void setProduct_service(String product_service) {
        this.product_service = product_service;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProduct_id() {
        return product_id;
    }

    public String getProduct_title() {
        return product_title;
    }

    public String getProduct_image_name() {
        return product_image_name;
    }

    public String getProduct_service() {
        return product_service;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }
}
