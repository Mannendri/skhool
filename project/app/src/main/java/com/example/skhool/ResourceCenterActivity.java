package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResourceCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_center);

    }


    public void openResourceCategoryActivity1(View view) {
        Intent intentToOpenResourceCategoryActivity = new Intent(this,ResourceCategoryActivity.class);
        intentToOpenResourceCategoryActivity.putExtra("title","Scholarships");

        startActivity(intentToOpenResourceCategoryActivity);
    }
    public void openResourceCategoryActivity2(View view) {
        Intent intentToOpenResourceCategoryActivity = new Intent(this,ResourceCategoryActivity.class);
        intentToOpenResourceCategoryActivity.putExtra("title","Exam Prep");

        startActivity(intentToOpenResourceCategoryActivity);
    }

    public void openResourceCategoryActivity3(View view) {
        Intent intentToOpenResourceCategoryActivity = new Intent(this,ResourceCategoryActivity.class);
        intentToOpenResourceCategoryActivity.putExtra("title","College Planning");

        startActivity(intentToOpenResourceCategoryActivity);
    }
}