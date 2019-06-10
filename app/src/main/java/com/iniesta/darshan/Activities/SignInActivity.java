package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.iniesta.darshan.R;

public class SignInActivity extends AppCompatActivity {

    Button btn_submit;
    FloatingActionButton btn_back;
    EditText fullName,eMail,mobile,Address,password,passwordR;
    RadioButton rb_male,rb_female,rb_trans;
    String strName,stremail,strmobile,strAddess,strPassword,strPasswordr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Finding Id
        btn_submit=findViewById(R.id.btn_submit);
        btn_back=findViewById(R.id.back_btn);
        fullName=findViewById(R.id.full_name);
        eMail=findViewById(R.id.new_email);
        Address=findViewById(R.id.new_address);
        mobile=findViewById(R.id.new_mobile);
        password=findViewById(R.id.new_password);
        passwordR=findViewById(R.id.new_repeatPassword);
        rb_male=findViewById(R.id.male);
        rb_female=findViewById(R.id.female);
        rb_trans=findViewById(R.id.trans);

        //ClickListener
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivity.super.onBackPressed();

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strName=fullName.getText().toString();
                stremail=eMail.getText().toString();
                strAddess=Address.getText().toString();
                strmobile=mobile.getText().toString();
                strPassword=password.getText().toString();
                strPasswordr=passwordR.getText().toString();

                if(strName.equals("")||stremail.equals("")||strAddess.equals("")||strmobile.equals("")||strPasswordr.equals("")||strPassword.equals(""))
                {
                    Toast.makeText(SignInActivity.this, "Please Give All Information", Toast.LENGTH_SHORT).show();
                    fullName.setText("");eMail.setText("");mobile.setText("");Address.setText("");password.setText("");passwordR.setText("");

                }
                else if(!(rb_male.isChecked()||rb_female.isChecked()||rb_trans.isChecked()))
                {
                    Toast.makeText(SignInActivity.this, "Gender to bta de ", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(SignInActivity.this, "Abhi Backend Nahi bna iska but That's Fine", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(SignInActivity.this, HomeActivity.class);
                    startActivity(intent);
                }


            }
        });
    }
}
