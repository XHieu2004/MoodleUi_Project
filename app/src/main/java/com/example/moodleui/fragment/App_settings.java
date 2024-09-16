package com.example.moodleui.fragment;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.moodleui.R;

public class App_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Set up the toolbar as the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Enable the back button functionality
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("App settings");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the toolbar's back button click
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close this activity and return to the previous one
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
