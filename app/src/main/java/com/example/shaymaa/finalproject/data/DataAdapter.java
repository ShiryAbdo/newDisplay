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
import android.widget.TextView;

import com.example.shaymaa.finalproject.R;
import com.example.shaymaa.finalproject.activites.Wassf_asnaa_mape_oOne;
import com.example.shaymaa.finalproject.activites.wasffWithTabb;

import java.util.ArrayList;

/**
 * Created by Shaymaa on 6/23/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Factory_data> androidList;
    private Context context;
    private int lastPosition=-1;

    public DataAdapter(ArrayList<Factory_data> android,Context c) {
        this.androidList = android;
        this.context=c;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout. singel_card_masna, viewGroup, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.factory_name.setText(androidList.get(i).getName());
        viewHolder.cintery_name.setText(androidList.get(i).getVer());
        viewHolder.email_factory.setText(androidList.get(i).getApi());
        viewHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,wasffWithTabb.class));
            }
        });
        setAnimation(viewHolder.card, i);

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
        private TextView factory_name,cintery_name,email_factory;
        private CardView card;
         public ViewHolder(View view) {
            super(view);
            card=(CardView)view.findViewById(R.id.card);
            factory_name = (TextView)view.findViewById(R.id.name_factory);
            cintery_name = (TextView)view.findViewById(R.id.counter_name);
            email_factory = (TextView)view.findViewById(R.id.email_factory);

        }
    }

}

