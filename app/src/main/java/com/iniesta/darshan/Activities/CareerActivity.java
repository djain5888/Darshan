package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iniesta.darshan.R;

public class CareerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_career);


    }

    public void applyCareers(View view){
        Intent intent = new Intent(CareerActivity.this, Applynow.class);
        startActivity(intent);
        //Toast.makeText(this,"Button clicked",Toast.LENGTH_SHORT).show();
    }
}
