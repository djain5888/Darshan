package com.iniesta.darshan.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.iniesta.darshan.R;

public class LoginActivity extends AppCompatActivity {

    Button btn_login,btn_signup,btn_newmember;
    EditText et_email,et_password;
    TextView tv_skip,tv_forgot;
    CheckBox checkBox;

    String str_email,str_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login=findViewById(R.id.proceed);
        btn_signup=findViewById(R.id.signup);
        btn_newmember=findViewById(R.id.newmember);
        tv_skip=findViewById(R.id.skip);
        tv_forgot=findViewById(R.id.textview_forgot);
        checkBox=findViewById(R.id.checkbox_remember);
        et_email=findViewById(R.id.edit_email);
        et_password=findViewById(R.id.edit_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str_email=et_email.getText().toString();
                str_password=et_password.getText().toString();
                Toast.makeText(LoginActivity.this, "entered "+str_email, Toast.LENGTH_SHORT).show();

                if(str_email.equals("")|| str_password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Enter Email and Password First", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Abhi back end nahi bna hai", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });

        btn_newmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "Abhi Nahi Bana Ye Kuch Aur Try kar", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
