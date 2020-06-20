package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    public void openResourceCenterActivity(View view) {
        Intent intentToOpenResourceCenterActivity = new Intent(this,ResourceCenterActivity.class);
        startActivity(intentToOpenResourceCenterActivity);
    }
}