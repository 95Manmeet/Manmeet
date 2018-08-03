package com.example.hasna.manmeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static com.example.hasna.manmeet.R.id.button;
import static com.example.hasna.manmeet.R.id.otherIssues;
import static com.example.hasna.manmeet.R.id.wrongFuel;

/**
 * Created by manmeet on 6/27/2018.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(wrongFuel).setOnClickListener(this);
        findViewById(otherIssues).setOnClickListener(this);
        findViewById(button).setOnClickListener(this);

    }
    @Override
    public void onClick (View view) {
        switch (view.getId()) {

            case R.id.wrongFuel:
                startActivity(new Intent(this, WrongFuel.class));

                break;

            case R.id.otherIssues:

                startActivity(new Intent(this, OtherIssues.class));

                break;
            case R.id.button:

                startActivity(new Intent(this, DiscountOffer.class));

                break;


        }

    }


}


