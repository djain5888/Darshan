package com.iniesta.darshan.Activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.iniesta.darshan.R;

import java.util.Calendar;
import java.util.Date;

public class CabActivity extends AppCompatActivity {
    Button b1;
    String s1;
    AutoCompleteTextView autoCompleteTextView2,autoCompleteTextView4;
    AutoCompleteTextView autoCompleteTextView,autoCompleteTextView3;
    EditText date;
    DatePickerDialog picker;
    EditText eText,eText2;
    Switch aSwitch;
    private CardView places,pooja,packages,hotel;

    private String[] myImageNameList = new String[]{"Shree Ram Mandir","Vrindavan","Mata Mansa Devi","Kashi Vishwanath","Kashi Vishwanath1","Kashi Vishwanath2"};

    private String[] myTimeList = new String[]{"12:00 AM","12:30 AM","01:00 AM","01:30 AM","02:00 AM","02:30 AM","03:00 AM","03:30 AM","04:00 AM","04:30 AM","05:00 AM","05:30 AM","06:00 AM","06:30 AM","07:00 AM","07:30 AM","08:00 AM","08:30 AM","09:00 AM","09:30 AM","10:00 AM","10:30 AM","11:00 AM","11:30 AM","12:00 PM","12:30 PM","01:00 PM","01:30 PM","02:00 PM","02:30 PM","03:00 PM","03:30 PM","04:00 PM","04:30 PM","05:00 PM","05:30 PM","06:00 PM","06:30 PM","07:00 PM","07:30 PM","08:00 PM","08:30 PM","09:00 PM","09:30 PM","10:00 PM","10:30 PM","11:00 PM","11:30 PM"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab);
        b1=findViewById(R.id.submit);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        autoCompleteTextView = findViewById(R.id.search2);
        autoCompleteTextView3=findViewById(R.id.time);
        autoCompleteTextView4=findViewById(R.id.time2);
        date=findViewById(R.id.date);
        aSwitch=findViewById(R.id.switch1);

        places = findViewById(R.id.card_view1Cab);
        pooja = findViewById(R.id.card_view2Cab);
        packages = findViewById(R.id.card_view3Cab);
        hotel = findViewById(R.id.card_view5Cab);

        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CabActivity.this,"Places",Toast.LENGTH_SHORT).show();
            }
        });
        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CabActivity.this,PoojaActivity.class);
                startActivity(intent);
            }
        });
        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(CabActivity.this,"Packages",Toast.LENGTH_SHORT).show();
            }
        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CabActivity.this,HotelActivity.class);
                startActivity(intent);            }
        });

        final ArrayAdapter<String> adpatertime = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myTimeList);
        final ArrayAdapter<String> adpater = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myImageNameList);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.showDropDown();

            }
        });
        autoCompleteTextView.setAdapter(adpater);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        autoCompleteTextView2 = findViewById(R.id.dest);
        final ArrayAdapter<String> adpater7= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myImageNameList);

        autoCompleteTextView2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                autoCompleteTextView2.showDropDown();
            }
        });
        autoCompleteTextView2.setAdapter(adpater7);
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                s1=autoCompleteTextView2.getText().toString();

            }
        });

        autoCompleteTextView3.setAdapter(adpatertime);
        autoCompleteTextView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                s1=autoCompleteTextView3.getText().toString();

            }
        });
        autoCompleteTextView3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                autoCompleteTextView3.showDropDown();
            }
        });

        autoCompleteTextView4.setAdapter(adpatertime);
        autoCompleteTextView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                s1=autoCompleteTextView4.getText().toString();

            }
        });
        autoCompleteTextView4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                autoCompleteTextView4.showDropDown();
            }
        });



        eText=(EditText) findViewById(R.id.date);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                Date today=new Date();
                long minDate = cldr.getTime().getTime();
                Date newday = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add( Calendar.MONTH, +3 ) ;// Subtract 6 months
                long maxDate = c.getTime().getTime() ;//

//

                picker = new DatePickerDialog(CabActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(minDate);
                picker.getDatePicker().setMaxDate(maxDate);
                picker.show();

            }
        });

        eText2=(EditText) findViewById(R.id.date2);
        eText2.setInputType(InputType.TYPE_NULL);
        eText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                Date today=new Date();
                long minDate = cldr.getTime().getTime();
                Date newday = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(today);
                c.add( Calendar.MONTH, +3 ) ;// Subtract 6 months
                long maxDate = c.getTime().getTime() ;//

//

                picker = new DatePickerDialog(CabActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override

                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText2.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.getDatePicker().setMinDate(minDate);
                picker.getDatePicker().setMaxDate(maxDate);
                picker.show();

            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    eText2.setVisibility(View.VISIBLE);
                    autoCompleteTextView4.setVisibility(View.VISIBLE);
                }
                else
                {
                    eText2.setVisibility(View.INVISIBLE);
                    autoCompleteTextView4.setVisibility(View.INVISIBLE);
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(CabActivity.this, HomeActivity.class);
// set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }


    public void submitcab(View view) {

        s1=autoCompleteTextView2.getText().toString();
        String s2=eText.getText().toString();
        Intent i1=new Intent(CabActivity.this,CabResultsActivity.class);
        startActivity(i1);

//        Toast.makeText(this, "you entered "+s1, Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "you entered "+s2, Toast.LENGTH_SHORT).show();

    }


}
