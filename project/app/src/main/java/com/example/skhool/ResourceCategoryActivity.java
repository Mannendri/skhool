package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ResourceCategoryActivity extends AppCompatActivity {
    private TextView titleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_category);

        titleTV = findViewById(R.id.title);
        Bundle bundle = getIntent().getExtras();
        String title = (String) bundle.get("title");
        titleTV.setText(title);

        ArrayList<ResourceItem> resourceItems = new ArrayList<>();


    }
}