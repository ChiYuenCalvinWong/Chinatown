package com.example.calvin.chinatown;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationActivity extends Activity {

    private TextView LocName;
    private TextView Address;
    private TextView About;
    private TextView Tap;
    private  Boolean musicrunning;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        LocName = findViewById(R.id.LocName);
        Address = findViewById(R.id.Address);
        About = findViewById(R.id.About);
        Tap = findViewById(R.id.Tap);

        Intent intent = getIntent();
        if(intent.hasExtra("PLACENAME")){
            LocName.setText(intent.getStringExtra("PLACENAME"));
        }

        Tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to Detail activity
            }
        });

        LocName.setText("Ping Tom Memorial Park");
        About.setText("This is the introduction of the Park\n We need HR team to provide something for the app\n Bye!");
        Address.setText("1234 Example st");

    }

    public void startMusic(View v){
        Intent intent = new  Intent(LocationActivity.this, MusicService.class);
        intent.putExtra("NAME", LocName.toString());
        startService(intent);

    }

    public void stopMusic(View v){
        stopService(new Intent(LocationActivity.this, MusicService.class));
    }
}
