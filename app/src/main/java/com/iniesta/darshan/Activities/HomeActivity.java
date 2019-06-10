package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.Adapters.FruitAdapter;
import com.iniesta.darshan.models.FruitModel;
import com.iniesta.darshan.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity  {

    private TextView mTextMessage;
    CardView places,pooja,pack,cab,hotel;

    private RecyclerView recyclerView,recyclerView4,recyclerView3,recyclerView2,recyclerView1;
    private ArrayList<FruitModel> imageModelArrayList,imageModelArrayList1,imageModelArrayList2;
    private FruitAdapter adapter,adapter2,adapter4;

    //item for REcycler view0
    private int[] myImageList0 = new int[]{ R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1
            };
    private String[] myImageNameList0 = new String[]{"Shree Ram Mandir","Vrindavan","Mata Mansa Devi","Kashi Vishwanath"};
    private String[] myImageNameList20 = new String[]{"Ayodhya,Uttar Pradesh","Mathura,Uttar Pradesh","Hardiwar,Uttrakhand","Varansi,Uttar Pradesh"};

    //item for REcycler view2
    private int[] myImageList2 = new int[]{ R.drawable.hotels,
            R.drawable.cabdivya1,
            R.drawable.hawan,
            R.drawable.tourguide
    };
    private String[] myImageNameList2 = new String[]{"Hotels","Cabs","Pooja/Hawan","Tour Guide"};
    private String[] myImageNameList22 = new String[]{"Cheap and Best Hotels","Cabs at Best Price","We provide all types of Pooja/Hawan","Tour Guide with Full Information"};

    //item for REcycler view4
    private int[] myImageList4 = new int[]{ R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1
    };
    private String[] myImageNameList4 = new String[]{"Shree Ram Mandir","Vrindavan","Mata Mansa Devi","Kashi Vishwanath"};
    private String[] myImageNameList24 = new String[]{"Ayodhya,Uttar Pradesh","Mathura,Uttar Pradesh","Hardiwar,Uttrakhand","Varansi,Uttar Pradesh"};

    BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    Intent i1=new Intent(HomeActivity.this, DashActivity.class);
                    startActivity(i1);
                    return true;
                case R.id.navigation_profile:
                    Intent i2=new Intent(HomeActivity.this, ProfileActivity.class);
                    startActivity(i2);
                    //mTextMessage.setText("Profile");
                    return true;
                case R.id.navigation_help:
                    Intent i3=new Intent(HomeActivity.this, HelpActivity.class);
                    startActivity(i3);
                    //mTextMessage.setText("Help");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);//For Keyboard

        //Navigation view
        navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.getMenu().getItem(0).setChecked(true);



        //Finding Id's
        mTextMessage = findViewById(R.id.message);
        places=findViewById(R.id.card_view1);
        pooja=findViewById(R.id.card_view2);
        pack=findViewById(R.id.card_view3);
        cab=findViewById(R.id.card_view4);
        hotel=findViewById(R.id.card_view);

        //Finding Recycler Id's
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
//        recyclerView1 = (RecyclerView) findViewById(R.id.recycler1);
        recyclerView2 = (RecyclerView) findViewById(R.id.recycler2);
//        recyclerView3 = (RecyclerView) findViewById(R.id.recycler3);
        recyclerView4 = (RecyclerView) findViewById(R.id.recycler4);

        //Listerner for Recycler vieew
        FruitAdapter.RecyclerViewClickListener listener =new FruitAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(HomeActivity.this, position+" Pressed", Toast.LENGTH_SHORT).show();
            }
        };

        FruitAdapter.RecyclerViewClickListener listener1 =new FruitAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(HomeActivity.this, position+" Pressed", Toast.LENGTH_SHORT).show();
                if(position==0)
                {
                    Intent intent=new Intent(HomeActivity.this, HotelActivity.class);
                    startActivity(intent);
                }
                if(position==1)
                {
                    Intent intent=new Intent(HomeActivity.this, CabActivity.class);
                    startActivity(intent);
                }
                if(position==2)
                {
                    Intent intent=new Intent(HomeActivity.this, PoojaActivity.class);
                    startActivity(intent);
                }
                if(position==3)
                {
                    Toast.makeText(HomeActivity.this, "Please Complete this module in site", Toast.LENGTH_SHORT).show();
                }
            }
        };

        FruitAdapter.RecyclerViewClickListener listener2 =new FruitAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(HomeActivity.this, position+" Pressed", Toast.LENGTH_SHORT).show();
            }
        };


        //Adapter
        imageModelArrayList = eatFruits();
        adapter = new FruitAdapter(this, imageModelArrayList,listener);

        imageModelArrayList1 = eatFruits2();
        adapter2 = new FruitAdapter(this, imageModelArrayList1,listener1);

        imageModelArrayList2 = eatFruits4();
        adapter4 = new FruitAdapter(this, imageModelArrayList2,listener2);

//        recyclerView1.setAdapter(adapter);
//        recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView2.setAdapter(adapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        recyclerView4.setAdapter(adapter4);
        recyclerView4.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        //Click Listener
        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Places clicked", Toast.LENGTH_SHORT).show();
            }
        });

        pooja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Pooja clicked", Toast.LENGTH_SHORT).show();
                Intent i1=new Intent(HomeActivity.this,PoojaActivity.class);
                startActivity(i1);
            }
        });

        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Packages clicked", Toast.LENGTH_SHORT).show();
            }

        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, " Hotel clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,HotelActivity.class);
                startActivity(intent);
            }
        });

        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, " Cab clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this,CabActivity.class);
                startActivity(intent);
            }
        });

        //AutoComplete ki khicdi
        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.search1);
        final ArrayAdapter<String> adpater2= new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,myImageNameList2);
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoCompleteTextView.showDropDown();
            }
        });
        autoCompleteTextView.setAdapter(adpater2);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(HomeActivity.this, "You Selected "+myImageNameList2[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<FruitModel> eatFruits(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setName(myImageNameList0[i]);
            fruitModel.setName1(myImageNameList20[i]);
            fruitModel.setImage_drawable(myImageList0[i]);
            list.add(fruitModel);
        }

        return list;
    }

    private ArrayList<FruitModel> eatFruits2(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setName(myImageNameList2[i]);
            fruitModel.setName1(myImageNameList22[i]);
            fruitModel.setImage_drawable(myImageList2[i]);
            list.add(fruitModel);
        }

        return list;
    }

    private ArrayList<FruitModel> eatFruits4(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setName(myImageNameList24[i]);
            fruitModel.setName1(myImageNameList4[i]);
            fruitModel.setImage_drawable(myImageList4[i]);
            list.add(fruitModel);
        }
        return list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        navView=findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navView.getMenu().getItem(0).setChecked(true);
    }
}
