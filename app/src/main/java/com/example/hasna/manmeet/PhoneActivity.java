package com.example.hasna.manmeet;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;

public class PhoneActivity extends Activity {
    private Button button;


    @SuppressLint("MissingPermission")
    public void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.main);

     //   button = (Button) findViewById(R.id.buttonCall);
        Bundle bundle = getIntent().getExtras();
       String number = bundle.getString("Key");

        Intent callIntent = new Intent(Intent.ACTION_CALL);

            callIntent.setData(Uri.parse(number));

              //  startActivity(callIntent);
                //Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", number, null));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);




    }
}
