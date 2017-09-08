package com.example.shaymaa.finalproject.data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.activites.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shirya on 31/08/17.
 */

public class Adaptor_Industrial_cities extends RecyclerView.Adapter<Adaptor_Industrial_cities.ViewHolder> {
    private ArrayList<Industrial_cities_Data> androidList;
    private Context context;
    private int lastPosition=-1;
    String city_name ,factory_space, factory_title;


    public Adaptor_Industrial_cities(ArrayList<Industrial_cities_Data> android,Context c) {
        this.androidList = android;
        this.context=c;
    }

    @Override
    public Adaptor_Industrial_cities.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.  industrial_cities_row, viewGroup, false);


        return new Adaptor_Industrial_cities.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(Adaptor_Industrial_cities.ViewHolder viewHolder, int i) {
        if(androidList.get(i).getCity_name().contains("ar")){
            city_name= androidList.get(i).getCity_name().substring(18).replace("\";}", "");

        }else {
            city_name=  androidList.get(i).getCity_name();
        }

//
//        if(androidList.get(i).getCity_name().contains("ar")){
//            factory_space= androidList.get(i).getCity_name().substring(20).replace("\";}", "");
//
//        }else {
//            factory_space=  androidList.get(i).getCity_name();
//        }
//
//        if(androidList.get(i).getFactory_title().contains("ar")){
//            factory_title= androidList.get(i).getCity_name().substring(20).replace("\";}", "");
//
//        }else {
//            factory_title=  androidList.get(i).getCity_name();
//        }




        viewHolder.city_name.setText(city_name);
        viewHolder.factory_space.setText(androidList.get(i).getFactory_space());
        viewHolder.factory_title.setText(androidList.get(i).getFactory_title());
        Picasso.with(context).load(androidList.get(i). getFactory_image()).error(android.R.drawable.stat_notify_error).fit().into(viewHolder.factory_image);
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, MainActivity.class));
            }
        });
        setAnimation(viewHolder.cardView, i);

    }



    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView city_name,factory_space,factory_title;
        private CardView cardView;
        private ImageView factory_image;
        public ViewHolder(View view) {
            super(view);
            cardView=(CardView)view.findViewById(R.id.cardView);
            city_name = (TextView)view.findViewById(R.id.city_name);
            factory_space = (TextView)view.findViewById(R.id.factory_space);
            factory_title = (TextView)view.findViewById(R.id.factory_title);
            factory_image = (ImageView)view.findViewById(R.id.factory_image);

        }
    }

}
