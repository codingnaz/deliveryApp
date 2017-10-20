package com.example.saimon22.deliveryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class signIn extends AppCompatActivity implements View.OnClickListener {
    Button loginButton;
    EditText UserName, Password;
    TextView createAccountButton, ResetPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        loginButton = (Button) findViewById(R.id.signInButton);
        UserName= (EditText) findViewById(R.id.userName);
        Password= (EditText) findViewById(R.id.password);
        createAccountButton=(TextView) findViewById(R.id.createAccountButton);
        ResetPassword=(TextView) findViewById(R.id.ResetPassword);


        createAccountButton.setOnClickListener(this);
        ResetPassword.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.createAccountButton:
                startActivity(new Intent(this, SignUpPage.class));



                break;
            case R.id.ResetPassword:

                break;
        }
    }
}
