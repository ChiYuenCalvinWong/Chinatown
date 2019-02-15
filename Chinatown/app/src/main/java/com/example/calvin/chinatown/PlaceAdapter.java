package com.example.calvin.chinatown;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Place> placeList;
    private LocationsActivity locationsActivity;

    public PlaceAdapter(List<Place> plaList, LocationsActivity loc){
        this.placeList = plaList;
        this.locationsActivity = loc;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.location_list_row, viewGroup, false);

        itemView.setOnClickListener(locationsActivity);
        itemView.setOnLongClickListener(locationsActivity);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Place place = placeList.get(i);
        myViewHolder.name.setText(place.getName());
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}
