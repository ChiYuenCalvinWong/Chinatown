package com.example.calvin.chinatown;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class LocationsActivity extends Activity implements View.OnClickListener, View.OnLongClickListener {

    private List<Place> placeList = new ArrayList<>();

    private RecyclerView recyclerView;

    private PlaceAdapter placeAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);

        recyclerView = findViewById(R.id.RecyclerView);

        placeAdapter = new PlaceAdapter(placeList, this);

        recyclerView.setAdapter(placeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        for(int i = 0; i < 20 ; i++){
            placeList.add(new Place());
        }
    }

    @Override
    public void onClick(View v) {
        int pos = recyclerView.getChildAdapterPosition(v);
        Place p = placeList.get(pos);
        Intent intent = new Intent(LocationsActivity.this, LocationActivity.class);
        intent.putExtra("PLACENAME", p.getName());
        startActivity(intent);

    }

    @Override
    public boolean onLongClick(View v) {
        int pos = recyclerView.getChildAdapterPosition(v);
        Place p = placeList.get(pos);

        return false;
    }
}
