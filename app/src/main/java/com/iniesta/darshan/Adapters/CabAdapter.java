package com.iniesta.darshan.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.R;
import com.iniesta.darshan.models.CabModel;


import java.util.ArrayList;

public class CabAdapter extends RecyclerView.Adapter<CabAdapter.MyViewHolder> {
    public Context c1;
    private CabAdapter.RecyclerViewClickListener listen;
    private LayoutInflater inflater;
    private ArrayList<CabModel> imageModelArrayList;
    public CabAdapter(Context ctx, ArrayList<CabModel> imageModelArrayList, CabAdapter.RecyclerViewClickListener listener){
        listen=listener;
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        c1=ctx;

    }




    @NonNull
    @Override
    public CabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cab_card_style, parent, false);
        CabAdapter.MyViewHolder holder = new CabAdapter.MyViewHolder(view,listen);


        return holder;
    }

    @Override
    public void onBindViewHolder(CabAdapter.MyViewHolder holder, final int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.cabname.setText(imageModelArrayList.get(position).getName());
        holder.seater.setText(imageModelArrayList.get(position).getSeater()+"seater");
        holder.rating.setText(Integer.toString(imageModelArrayList.get(position).getRating()));
        holder.price.setText(Integer.toString(imageModelArrayList.get(position).getprice()));
        holder.luggage.setText(imageModelArrayList.get(position).getLuggage()+"luggage");
        if(imageModelArrayList.get(position).getAc()==true)
        {
            holder.ac.setVisibility(View.VISIBLE);
            holder.ac1.setVisibility(View.VISIBLE);
        }
        else {
            holder.ac1.setVisibility(View.GONE);
            holder.ac.setVisibility(View.GONE);
        }
        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=imageModelArrayList.get(position).getName();
                Toast.makeText(c1 ,"booked "+s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }
    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView cabname,luggage,seater,price,ac,rating;
        ImageView iv,ac1;
        Button b1;
        private CabAdapter.RecyclerViewClickListener listener;
        public MyViewHolder(View itemView, CabAdapter.RecyclerViewClickListener listener2) {
            super(itemView);

            listener = listener2;
            b1=itemView.findViewById(R.id.bookButton);
            cabname = (TextView) itemView.findViewById(R.id.cabName);
            seater = (TextView) itemView.findViewById(R.id.seattext);
            iv = (ImageView) itemView.findViewById(R.id.car);
            luggage=(TextView)itemView.findViewById(R.id.bagtext);
            price=(TextView)itemView.findViewById(R.id.price2);
            rating=(TextView)itemView.findViewById(R.id.rat1);
            ac1=(ImageView)itemView.findViewById(R.id.acim);
            ac=(TextView)itemView.findViewById(R.id.actext);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());

        }
    }
}

