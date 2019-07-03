package com.iniesta.darshan.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.iniesta.darshan.R;

public class Applynow extends AppCompatActivity {

    private Spinner Applyingfor;
    private Button submitButton;
    private EditText mName, mEmail, mMobile,mAddress1, mAddress2, mPoliceStation, mState,mZipCode;
    private String name,email,mobile,address1, address2, policestation,state,zipcode, applyingfor;
    private String[] applying = { "Select Service", "Travel Guide", "Travel Assistant", "Sales Intern"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_now);

        getSupportActionBar().hide();


        submitButton = findViewById(R.id.submit_btn);
        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.mailId);
        mMobile = findViewById(R.id.mobileno);
        mAddress1 = findViewById(R.id.address1);
        mAddress2 = findViewById(R.id.address2);
        mPoliceStation = findViewById(R.id.policestation);
        mState = findViewById(R.id.state);
        mZipCode = findViewById(R.id.zipcode);
        Applyingfor = findViewById(R.id.Applyingfor);


        ArrayAdapter serviceAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,applying);
        serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Applyingfor.setAdapter(serviceAdapter);

        Applyingfor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                applyingfor = applying[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = mName.getText().toString();
                email = mEmail.getText().toString();
                mobile = mMobile.getText().toString();
                address1 = mAddress1.getText().toString();
                address2 = mAddress2.getText().toString();
                policestation = mPoliceStation.getText().toString();
                state = mState.getText().toString();
                zipcode = mZipCode.getText().toString();

                Toast.makeText(Applynow.this, name+" "+email+" "+mobile+" "+address1+" "+address2+" "+policestation+" "+state+" "+zipcode+""+applyingfor, Toast.LENGTH_LONG).show();

            }
        });




    }


}
