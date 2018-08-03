package com.example.hasna.manmeet;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by manmeet on 6/27/2018.
 */

public class SignUp extends AppCompatActivity {
    EditText username,password,email;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.signup_username);
        password = (EditText) findViewById(R.id.signup_password);
        email = (EditText) findViewById(R.id.signup_email);
        ctx = this;
    }

    public void signup(View view) {
        String name,pass,mail;
        name = username.getText().toString();
        pass = password.getText().toString();
        mail = email.getText().toString();

        if(name.isEmpty() || pass.isEmpty() || mail.isEmpty()){
            Toast.makeText(this, "Invalid Data to Proceed!", Toast.LENGTH_SHORT).show();
        }else{
            DatabaseOperaation dop = new DatabaseOperaation(ctx);
            dop.putRecord(dop,name,pass,mail);
            Toast.makeText(ctx, "Signup Successful!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

