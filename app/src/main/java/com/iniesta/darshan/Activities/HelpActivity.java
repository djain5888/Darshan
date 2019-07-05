package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.iniesta.darshan.R;

public class HelpActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private BottomNavigationView navView;
    private CardView cardabout,cardcon,cardcarrer;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    Intent intent = new Intent(HelpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent intent2 = new Intent(HelpActivity.this,DashActivity.class);
                    startActivity(intent2);
                    return true;
                case R.id.navigation_profile:
                    //mTextMessage.setText("Profile");
                    Intent intent3 = new Intent(HelpActivity.this, ProfileActivity.class);
                    startActivity(intent3);
                    return true;
                case R.id.navigation_help:
                    ///mTextMessage.setText("Help");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.getMenu().getItem(3).setChecked(true);

        cardabout = findViewById(R.id.card1);
        cardabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HelpActivity.this,AboutUsActivity.class);
                startActivity(intent);
            }
        });

        cardcarrer = findViewById(R.id.card3);
        cardcarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HelpActivity.this,CareerActivity.class);
                startActivity(intent);
            }
        });

        cardcon = findViewById(R.id.card2);
        cardcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(HelpActivity.this,Contact_us.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        navView=findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.getMenu().getItem(3).setChecked(true);
    }

}
