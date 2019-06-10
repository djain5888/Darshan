package com.iniesta.darshan.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iniesta.darshan.models.FruitModel;
import com.iniesta.darshan.R;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<FruitModel> imageModelArrayList;
    private FruitAdapter.RecyclerViewClickListener mlisten;
    public FruitAdapter(Context ctx, ArrayList<FruitModel> imageModelArrayList,RecyclerViewClickListener mlistener){
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        mlisten = mlistener;
    }

    @Override
    public FruitAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view,mlisten);

        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.MyViewHolder holder, int position) {

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
        private FruitAdapter.RecyclerViewClickListener listener;

        public MyViewHolder(View itemView,RecyclerViewClickListener listener2) {
            super(itemView);

            time = (TextView) itemView.findViewById(R.id.tv);
            time2 = (TextView) itemView.findViewById(R.id.tv2);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            listener = listener2;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
