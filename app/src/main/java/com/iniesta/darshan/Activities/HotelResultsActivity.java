package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.Adapters.HotelAdapter;
import com.iniesta.darshan.R;
import com.iniesta.darshan.models.HotelModel;
import com.iniesta.darshan.models.poojamodel;

import java.util.ArrayList;

public class HotelResultsActivity extends AppCompatActivity {

    private TextView placeTextView;
    private TextView checkInTextView;
    private TextView checkOutTextView;
    private HotelAdapter hotelAdapter;
    private RecyclerView hotelsRecycler;
    private HotelAdapter.RecyclerViewClickListener listener;

    private ArrayList<HotelModel> hotelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_results);

        addItems();

        placeTextView = findViewById(R.id.placeText);
        checkInTextView = findViewById(R.id.checkInText);
        checkOutTextView = findViewById(R.id.checkOutText);

        listener = new HotelAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getApplicationContext(),position + " clicked",Toast.LENGTH_SHORT).show();
            }
        };

        System.out.println(hotelList);

        hotelsRecycler = findViewById(R.id.hotelRecycler);
        hotelAdapter = new HotelAdapter(this,hotelList,listener);
        hotelsRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        hotelsRecycler.setAdapter(hotelAdapter);

        Bundle b = getIntent().getBundleExtra("bundle");
        if (b!=null) {
            String place = b.getString("hotel");
            String checkIn = b.getString("checkIn");
            String checkOut = b.getString("checkOut");

            if (!place.equals("") && !checkIn.equals("") && !checkOut.equals("") ) {
                placeTextView.setText(place);
                checkInTextView.setText(checkIn);
                checkOutTextView.setText(checkOut);
            }
        }

    }

    public void modifyHotel(View view){
        Intent intent = new Intent(HotelResultsActivity.this,HotelActivity.class);
        startActivity(intent);
    }

    public void addItems(){
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
        hotelList.add(new HotelModel(R.drawable.varansi1,"Gargee Grand","Exhibition Road, Patna",
                3100,4.2,"450X500",true,true,true));
    }

}
