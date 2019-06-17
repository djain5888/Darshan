package com.iniesta.darshan.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iniesta.darshan.R;
import com.iniesta.darshan.models.poojamodel;

import java.util.ArrayList;

public class CabAdapter extends RecyclerView.Adapter<CabAdapter.MyViewHolder> {
    private CabAdapter.RecyclerViewClickListener listen;
    private LayoutInflater inflater;
    private ArrayList<poojamodel> imageModelArrayList;
    public CabAdapter(Context ctx, ArrayList<poojamodel> imageModelArrayList, CabAdapter.RecyclerViewClickListener listener){
        listen=listener;
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }




    @NonNull
    @Override
    public CabAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        CabAdapter.MyViewHolder holder = new CabAdapter.MyViewHolder(view,listen);


        return holder;
    }

    @Override
    public void onBindViewHolder(CabAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.time.setText(imageModelArrayList.get(position).getName());
        holder.time2.setText(imageModelArrayList.get(position).getName1());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }
    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView time,time2;
        ImageView iv;
        private CabAdapter.RecyclerViewClickListener listener;
        public MyViewHolder(View itemView, CabAdapter.RecyclerViewClickListener listener2) {
            super(itemView);

            listener = listener2;
            time = (TextView) itemView.findViewById(R.id.tv);
            time2 = (TextView) itemView.findViewById(R.id.tv2);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());

        }
    }
}

