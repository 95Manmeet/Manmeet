package com.example.hasna.manmeet;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
//import static com.example.hasna.manmeet.R.id.forgetPassword;

import static android.app.Activity.RESULT_OK;

/**
 * Created by manmeet on 6/27/2018.
 */

public class Login extends AppCompatActivity{
    EditText username, password;
    TextView link_signup, forgetPassword;
    Context ctx;
    ArrayList<String> usernames, passwords;

    private static final int REQUEST_SIGNUP = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        link_signup = (TextView) findViewById(R.id.link_signup);
        forgetPassword = (TextView) findViewById(R.id.forgetPassword);

        //findViewById(forgetPassword).setOnClickListener(this);


        ctx = this;
        usernames = new ArrayList<String>();
        passwords = new ArrayList<String>();






        link_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
              //  overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });



        forgetPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the forget password Activity activity
                Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                //  finish();
                //  overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });



    }

    public void login (View view) {
        String name, pass;
        name = username.getText().toString();
        pass = password.getText().toString();
        Boolean loggedin = false;

        if (name.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Invalid Data to Proceed!", Toast.LENGTH_SHORT).show();
        } else {
            try {
               DatabaseOperaation dop = new DatabaseOperaation(ctx);
                Cursor cr = dop.getRecord(dop);
                cr.moveToFirst();
                do {
                    usernames.add(cr.getString(0));
                    passwords.add(cr.getString(1));
                } while (cr.moveToNext());

                for (int i = 0; i < usernames.size(); i++) {
                    if (usernames.get(i).equalsIgnoreCase(name) && passwords.get(i).equalsIgnoreCase(pass)) {
                        loggedin = true;
                        break;
                    }
                }

                if (loggedin) {
                    startActivity(new Intent(Login.this, MainActivity.class));
                    Toast.makeText(ctx, "Login Successful!", Toast.LENGTH_SHORT).show();
                } else Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}



