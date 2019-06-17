package com.iniesta.darshan.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.iniesta.darshan.R;

import java.util.Calendar;
import java.util.Date;

public class HotelActivity extends AppCompatActivity {

    private Button submitButton;
    private AutoCompleteTextView search,reason;
    private Spinner spinnerRooms,spinnerPersons;
    private EditText checkInDate,checkOutDate;
    private DatePickerDialog picker;

    private String[] numbers = { "1", "2", "3", "4", "5", "6"};
    private String[] myImageNameList = new String[]{"Shree Ram Mandir","Vrindavan","Mata Mansa Devi","Kashi Vishwanath",};
    private String[] reasonsList = new String[]{"Leisure","Work","Pooja"};

    private String hotelString;
    private String reasonString = "";
    private String checkInString = "";
    private String checkOutString = "";
    private int rooms;
    private int persons;

    private CardView places,pooja,packages,cab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        submitButton = findViewById(R.id.submitHotel);
        search = findViewById(R.id.hotel_search);
        reason = findViewById(R.id.reason);
        checkInDate = findViewById(R.id.checkIndate);
        checkOutDate = findViewById(R.id.checkOutdate);
        spinnerRooms = findViewById(R.id.spinnerRooms);
        spinnerPersons = findViewById(R.id.spinnerPersons);

        places = findViewById(R.id.card_view1H);
        pooja = findViewById(R.id.card_view2H);
        packages = findViewById(R.id.card_view3H);
        cab = findViewById(R.id.card_view4H);

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HotelActivity.this,"Places",Toast.LENGTH_SHORT).show();
            }
        });
        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelActivity.this,PoojaActivity.class);
                startActivity(intent);
            }
        });
        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HotelActivity.this,"Packages",Toast.LENGTH_SHORT).show();
            }
        });
        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelActivity.this,CabActivity.class);
                startActivity(intent);            }
        });

        //search for hotel/city/area
        final ArrayAdapter<String> hotelAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myImageNameList);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                search.showDropDown();
            }
        });
        search.setAdapter(hotelAdapter);
        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                hotelString = myImageNameList[position];
            }
        });

        checkInDate.setInputType(InputType.TYPE_NULL);
        checkInDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                Date today = new Date();
                long minDate = cldr.getTime().getTime();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add( Calendar.MONTH, +3 ) ;
                long maxDate = c.getTime().getTime() ;

                picker = new DatePickerDialog(HotelActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                checkInDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(minDate);
                picker.getDatePicker().setMaxDate(maxDate);
                picker.show();

            }
        });

        checkOutDate.setInputType(InputType.TYPE_NULL);
        checkOutDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                Date today=new Date();
                long minDate = cldr.getTime().getTime();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add( Calendar.MONTH, +4 ) ;
                long maxDate = c.getTime().getTime() ;

                picker = new DatePickerDialog(HotelActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                checkOutDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(minDate);
                picker.getDatePicker().setMaxDate(maxDate);
                picker.show();

            }
        });

        //rooms spinner
        spinnerRooms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rooms = Integer.parseInt(numbers[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter roomsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,numbers);
        roomsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRooms.setAdapter(roomsAdapter);

        //persons spinner
        spinnerPersons.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                persons = Integer.parseInt(numbers[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter personsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,numbers);
        roomsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPersons.setAdapter(personsAdapter);

        //reason for travel
        final ArrayAdapter<String> reasonAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,reasonsList);
        reason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                reason.showDropDown();
            }
        });
        reason.setAdapter(reasonAdapter);
        reason.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                reasonString = reasonsList[position];
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(HotelActivity.this, HomeActivity.class);
// set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }

    public void submitHotel(View view){
        hotelString = search.getText().toString();
        checkInString = checkInDate.getText().toString();
        checkOutString = checkOutDate.getText().toString();
        reasonString = reason.getText().toString();

        Toast.makeText(this,"Submit clicked\nHotel: " + hotelString + " CheckIn: " + checkInString
                + " CheckOut: " + checkOutString + "Rooms: " + rooms + " Persons: " + persons,Toast.LENGTH_LONG).show();

        Intent hotelIntent = new Intent(HotelActivity.this,HotelResultsActivity.class);
        startActivity(hotelIntent);
    }

}
