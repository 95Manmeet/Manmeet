package com.example.hasna.manmeet;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by manmeet on 6/27/2018.
 */

public class ForgetPassword extends AppCompatActivity{
    EditText editText;
    TextView textView;
    Button searchPassword;
    String pass,name;
    Context ctx;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        editText = (EditText) findViewById(R.id.forget_username);
        textView = (TextView) findViewById(R.id.forget_password);
        searchPassword = (Button) findViewById(R.id.searchPassword);

        ctx = this;

        searchPassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                forgetPassword();
                // Start the forget password Activity activity
                //Intent intent = new Intent(getApplicationContext(), ForgetPassword.class);
                //startActivityForResult(intent, REQUEST_SIGNUP);
                //  finish();
                //  overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });


    }
            public void forgetPassword() {

            name = editText.getText().toString();

            if (name.isEmpty()) {
                Toast.makeText(this, "Invalid Data to Proceed!", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    DatabaseOperaation dop = new DatabaseOperaation(ctx);
                    pass = dop.getSinlgeEntry(name);
                    textView.setText(pass);

                } catch (Exception e) {
                    Toast.makeText(ctx, "No Such User Exists!", Toast.LENGTH_SHORT).show();
                }
            }
        }





}
