package com.example.calvin.chinatown;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class  MainActivity extends Activity implements  View.OnClickListener{

    private TextView Locations;
    private Button Scan;
    private ImageView testscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int MY_PERMISSIONS_REQUEST_CAMERA=0;
        // Here, this is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_CAMERA );

        }

        Locations = findViewById(R.id.Locs);
        Scan = findViewById(R.id.Scan);

        Locations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocationsActivity.class);
                startActivity(intent);
            }
        });


        Scan.setOnClickListener(this);

    }

    public void setImageClick(View v){
        Intent intent = new Intent(MainActivity.this, ScannedBarcodeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, ScannedBarcodeActivity.class);
        startActivity(intent);
    }


}
