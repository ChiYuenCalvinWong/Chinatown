package com.example.calvin.chinatown;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.Language){
//            dialog();
        }
        return super.onOptionsItemSelected(item);

    }

    public void dialog(View v){
        final String[] langArray = new String[2];

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Language");
//        builder.setItems();
    }

}
