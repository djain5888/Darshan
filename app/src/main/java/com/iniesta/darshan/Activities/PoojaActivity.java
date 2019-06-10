package com.iniesta.darshan.Activities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.R;
import com.iniesta.darshan.Adapters.poojaAdapter;
import com.iniesta.darshan.models.poojamodel;

import java.util.ArrayList;

public class PoojaActivity extends AppCompatActivity {
    CardView places,pooja,pack,cab,hotel;
    private ArrayList<poojamodel> row2;
    private ArrayList<poojamodel> row1;
    private ArrayList<poojamodel> row3;
    private ArrayList<poojamodel> row4;
    private poojaAdapter adapter1;
    private poojaAdapter adapter2;
    private poojaAdapter adapter3;
    private poojaAdapter adapter4;
    final Context context = this;
    private TextView text;
    private Button dialogButton;


    private int[] myImageListrow2 = new int[]{R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1,

    };
    private int[] myImageListrow3 = new int[]{
            R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1,

    };
    private int[] myImageListrow4 = new int[]{
            R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1,

    };
    private int[] myImageListrow1 = new int[]{R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.varansi1,
            R.drawable.haridwar,
            R.drawable.mathura,
            R.drawable.vrindawan,
            R.drawable.apple
    };
    private String[] NameListrow2 = new String[]{"Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath"};
    private String[] smallNameListrow2 = new String[]{"Ayodhya,Uttar Pradesh", "Mathura,Uttar Pradesh", "Hardiwar,Uttrakhand", "Varansi,Uttar Pradesh"};
    private String[] NameListrow1 = new String[]{"Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath", "Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath"};
    private String[] smallNameListrow1 = new String[]{"Ayodhya,Uttar Pradesh", "Mathura,Uttar Pradesh", "Hardiwar,Uttrakhand", "Varansi,Uttar Pradesh", "Ayodhya,Uttar Pradesh", "Mathura,Uttar Pradesh", "Hardiwar,Uttrakhand", "Varansi,Uttar Pradesh"};
    private String[] NameListrow3 = new String[]{"Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath"};
    private String[] smallNameListrow3 = new String[]{"Ayodhya,Uttar Pradesh", "Mathura,Uttar Pradesh", "Hardiwar,Uttrakhand", "Varansi,Uttar Pradesh"};
    private String[] NameListrow4 = new String[]{"Shree Ram Mandir", "Vrindavan", "Mata Mansa Devi", "Kashi Vishwanath"};
    private String[] smallNameListrow4 = new String[]{"Ayodhya,Uttar Pradesh", "Mathura,Uttar Pradesh", "Hardiwar,Uttrakhand", "Varansi,Uttar Pradesh"};

    private RecyclerView poojarecyclerView, poojarecyclerView3, poojarecyclerView2, poojarecyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pooja);


        poojarecyclerView = (RecyclerView) findViewById(R.id.poojarecycler);
        poojarecyclerView3 = (RecyclerView) findViewById(R.id.poojarecycler3);
        poojarecyclerView1 = (RecyclerView) findViewById(R.id.poojarecycler1);
        poojarecyclerView2 = (RecyclerView) findViewById(R.id.poojarecycler2);
        places=findViewById(R.id.card_view1);

        pack=findViewById(R.id.card_view3);
        cab=findViewById(R.id.card_view4);
        hotel=findViewById(R.id.card_view);

        row1 = eatFruits(0);
        row2 = eatFruits(1);
        row3=eatFruits(2);
        row4=eatFruits(3);
        places.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PoojaActivity.this, "Places clicked", Toast.LENGTH_SHORT).show();

            }
        });

        pack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PoojaActivity.this, "Packages clicked", Toast.LENGTH_SHORT).show();
            }

        });
        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PoojaActivity.this, " Hotel clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PoojaActivity.this,HotelActivity.class);
                startActivity(intent);
            }
        });
        cab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PoojaActivity.this,CabActivity.class);
                Toast.makeText(PoojaActivity.this, " Cab clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        poojaAdapter.RecyclerViewClickListener listener2 = new poojaAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {//Row2
                if (position == 0) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    text = (TextView) dialog.findViewById(R.id.text);
                    // set the custom dialog components - text, image and button
                    text.setText(" row 2 position 1 dialog box");
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

                    text.setText(" row 2 position 2 dialog box");
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

                    text.setText(" row 2 position 3 dialog box");
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

                    text.setText(" row 2 position 4 dialog box");
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

                Toast.makeText(PoojaActivity.this, "you clicked" + position, Toast.LENGTH_SHORT).show();

            }
        };
        poojaAdapter.RecyclerViewClickListener listener3 = new poojaAdapter.RecyclerViewClickListener() {
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

                Toast.makeText(PoojaActivity.this, "you clicked" + position, Toast.LENGTH_SHORT).show();

            }
        };
        poojaAdapter.RecyclerViewClickListener listener4 = new poojaAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (position == 0) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    text = (TextView) dialog.findViewById(R.id.text);
                    // set the custom dialog components - text, image and button
                    text.setText(" row 4 position 1 dialog box");
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

                    text.setText("  row 4 position 2 dialog box");
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

                    text.setText("  row 4 position 3 dialog box");
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

                    text.setText("  row 4 position 4 dialog box");
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

                Toast.makeText(PoojaActivity.this, "you clicked" + position, Toast.LENGTH_SHORT).show();

            }
        };
        poojaAdapter.RecyclerViewClickListener listener = new poojaAdapter.RecyclerViewClickListener() {//listener for 3rd row
            @Override
            public void onClick(View view, int position) {

                if (position == 0) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    text = (TextView) dialog.findViewById(R.id.text);
                    // set the custom dialog components - text, image and button
                    text.setText("position 1 dialog box");
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

                    text.setText("position 2 dialog box");
                    // if button is clicked, close the custom dialog
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                    //lisener for 3rd row
                }
                if (position == 2) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);

                    // set the custom dialog components - text, image and button

                    text.setText("position 3 dialog box");
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

                    text.setText("position 4 dialog box");
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
                if (position == 4) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button

                    text.setText("position 5 dialog box");
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
                if (position == 5) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button

                    text.setText("position 6 dialog box");
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
                if (position == 6) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button

                    text.setText("position 7 dialog box");
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
                if (position == 7) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.dilalogs);
                    dialog.setTitle("Title...");
                    text = (TextView) dialog.findViewById(R.id.text);
                    dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    dialog.setTitle("Title...");

                    // set the custom dialog components - text, image and button

                    text.setText("position 8 dialog box");
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
                Toast.makeText(PoojaActivity.this, " clicked" + position, Toast.LENGTH_SHORT).show();

            }
        };
        adapter1 = new poojaAdapter(this, row1, listener);//row1
        adapter2 = new poojaAdapter(this, row2, listener2);//2nd row
        adapter3 = new poojaAdapter(this, row3, listener3);//3rd row
        adapter4 = new poojaAdapter(this, row4, listener4);//4th row

        poojarecyclerView1.setAdapter(adapter1);
        poojarecyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        poojarecyclerView.setAdapter(adapter4);
        poojarecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        poojarecyclerView3.setAdapter(adapter3);
        poojarecyclerView3.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        poojarecyclerView2.setAdapter(adapter2);
        poojarecyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(PoojaActivity.this, HomeActivity.class);
// set the new task and clear flags
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        super.onBackPressed();
    }


    private ArrayList<poojamodel> eatFruits(int a) {

        ArrayList<poojamodel> list = new ArrayList<>();


        if (a == 1) {
            for (int i = 0; i < 4; i++)
            {
                poojamodel poojaModel = new poojamodel();
                poojaModel.setName(NameListrow2 [i]);
                poojaModel.setName1(smallNameListrow2[i]);
                poojaModel.setImage_drawable(myImageListrow2[i]);
                list.add(poojaModel);
            }
        }
        else if (a == 0) {
            for (int i = 0; i < 8; i++) {
                poojamodel poojaModel = new poojamodel();
                {
                    poojaModel.setName(NameListrow1[i]);
                    poojaModel.setName1(smallNameListrow1[i]);
                    poojaModel.setImage_drawable(myImageListrow1[i]);
                    list.add(poojaModel);

                }
            }


        }
        else if (a == 2) {
            for (int i = 0; i < 4; i++)
            {
                poojamodel poojaModel = new poojamodel();
                poojaModel.setName(NameListrow3 [i]);
                poojaModel.setName1(smallNameListrow3[i]);
                poojaModel.setImage_drawable(myImageListrow3[i]);
                list.add(poojaModel);
            }
        }
        else if (a == 3) {
            for (int i = 0; i < 4; i++)
            {
                poojamodel poojaModel = new poojamodel();
                poojaModel.setName(NameListrow4 [i]);
                poojaModel.setName1(smallNameListrow4[i]);
                poojaModel.setImage_drawable(myImageListrow4[i]);
                list.add(poojaModel);
            }
        }
        return list;
    }
}
