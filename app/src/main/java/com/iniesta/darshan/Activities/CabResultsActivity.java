package com.iniesta.darshan.Activities;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.Adapters.CabAdapter;

import com.iniesta.darshan.Adapters.poojaAdapter;
import com.iniesta.darshan.R;
import com.iniesta.darshan.models.poojamodel;

import java.util.ArrayList;

public class CabResultsActivity extends AppCompatActivity {
    private ArrayList<poojamodel> row2;
    private CabAdapter adapter1;
    private RecyclerView cabrecyclerView;
    final Context context = this;
    private TextView text;
    private Button dialogButton;
    private String[] NameListrow2 = new String[]{"Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath"};

    private int[] myImageListrow2 = new int[]{
            R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_results);
        cabrecyclerView = (RecyclerView) findViewById(R.id.cabrecycler1);
        row2 = eatFruits(1);

        CabAdapter.RecyclerViewClickListener listener3 = new CabAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    text = (TextView) dialog.findViewById(R.id.text);
                    // set the custom dialog components - text, image and button
                    text.setText(" row 3 position 1 dialog box");
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    //lisener for 2nd row
                }
                if (position == 1) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    text = (TextView) dialog.findViewById(R.id.text);

                    // set the custom dialog components - text, image and button

                    text.setText("row 3 position 2 dialog box");
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    //lisener for 2nd row
                }
                if (position == 2) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);

                    // set the custom dialog components - text, image and button

                    text.setText(" row 3 position 3 dialog box");
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    //lisener for 2nd row
                }
                if (position == 3) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button

                    text.setText(" row 3 position 4 dialog box");
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    //lisener for 2nd row
                }

                Toast.makeText(CabResultsActivity.this, "you clicked" + position, Toast.LENGTH_SHORT).show();

            }
        };
       //row1
        adapter1=new CabAdapter(this,row2,listener3);
        cabrecyclerView.setAdapter(adapter1);
        cabrecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


    }

    private ArrayList<poojamodel> eatFruits(int a) {

        ArrayList<poojamodel> list = new ArrayList<>();


        if (a == 1) {
            for (int i = 0; i < 4; i++) {
                poojamodel poojaModel = new poojamodel();
                poojaModel.setName(NameListrow2[i]);
                poojaModel.setName1(NameListrow2[i]);
                poojaModel.setImage_drawable(myImageListrow2[i]);
                list.add(poojaModel);
            }
        }
        return list;

    }
}
