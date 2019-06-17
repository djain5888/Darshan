package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.iniesta.darshan.R;

public class HotelResultsActivity extends AppCompatActivity {

    TextView placeTextView;
    TextView checkInTextView;
    TextView checkOutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_results);

        placeTextView = findViewById(R.id.placeText);
        checkInTextView = findViewById(R.id.checkInText);
        checkOutTextView = findViewById(R.id.checkOutText);

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
}
