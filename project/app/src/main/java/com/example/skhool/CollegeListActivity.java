package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CollegeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        ArrayList<String> collegeNames = new ArrayList<>();

        CollegeAdapter adapter = new CollegeAdapter(this,collegeNames);
        ListView collegeNamesListView = findViewById(R.id.colleges_list_view);
        collegeNamesListView.setAdapter(adapter);
    }


}