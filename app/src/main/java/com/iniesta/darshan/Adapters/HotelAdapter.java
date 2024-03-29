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
import com.iniesta.darshan.models.HotelModel;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.HotelViewHolder> {

    private HotelAdapter.RecyclerViewClickListener listen;
    private Context mContext;
    private ArrayList<HotelModel> hotelList;

    public HotelAdapter(Context context, ArrayList<HotelModel> hotelModelArrayList, HotelAdapter.RecyclerViewClickListener listener){
        mContext = context;
        listen = listener;
        this.hotelList = hotelModelArrayList;
    }

    @NonNull
    @Override
    public HotelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.hotel_card_item, viewGroup, false);
        HotelViewHolder holder = new HotelViewHolder(view,listen);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelViewHolder hotelViewHolder, int i) {

        hotelViewHolder.mainImageView.setImageResource(hotelList.get(i).getImageId());
        hotelViewHolder.hotelName.setText(hotelList.get(i).getTitle());
        hotelViewHolder.hotelAddress.setText(hotelList.get(i).getAddress());
        hotelViewHolder.priceTextView.setText(Integer.toString(hotelList.get(i).getPrice()));
        hotelViewHolder.ratingTextView.setText(Double.toString(hotelList.get(i).getRating()));
        hotelViewHolder.sizeTextView.setText(hotelList.get(i).getRoomSize());
        hotelViewHolder.bookNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"Book Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        if (!hotelList.get(i).hasTv()){
            hotelViewHolder.tvImageView.setVisibility(View.GONE);
            hotelViewHolder.tvTextView.setVisibility(View.GONE);
        }

        if (!hotelList.get(i).hasSofa()){
            hotelViewHolder.sofaImageView.setVisibility(View.GONE);
            hotelViewHolder.sofaTextView.setVisibility(View.GONE);
        }

        if (!hotelList.get(i).hasAc()){
            hotelViewHolder.acImageView.setVisibility(View.GONE);
            hotelViewHolder.acTextView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    class HotelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mainImageView;
        ImageView tvImageView;
        ImageView sofaImageView;
        ImageView acImageView;
        TextView hotelName;
        TextView hotelAddress;
        TextView priceTextView;
        TextView ratingTextView;
        TextView sizeTextView;
        TextView tvTextView;
        TextView sofaTextView;
        TextView acTextView;
        Button bookNowButton;


        private HotelAdapter.RecyclerViewClickListener listener;
        public HotelViewHolder(View itemView, HotelAdapter.RecyclerViewClickListener listener2) {
            super(itemView);

            listener = listener2;
            mainImageView = itemView.findViewById(R.id.mainImage);
            hotelName = itemView.findViewById(R.id.mainTitle);
            hotelAddress = itemView.findViewById(R.id.desc);
            priceTextView = itemView.findViewById(R.id.price);
            ratingTextView = itemView.findViewById(R.id.rating);
            sizeTextView = itemView.findViewById(R.id.sizeText);
            tvImageView = itemView.findViewById(R.id.tvImage);
            sofaImageView = itemView.findViewById(R.id.sofaImage);
            acImageView = itemView.findViewById(R.id.acImage);
            tvTextView = itemView.findViewById(R.id.tvTextView);
            sofaTextView = itemView.findViewById(R.id.sofaTextView);
            acTextView = itemView.findViewById(R.id.acTextView);
            bookNowButton = itemView.findViewById(R.id.bookNowButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
