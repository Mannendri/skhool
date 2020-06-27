package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
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
        Log.d("title",title);

        ArrayList<ResourceItem> resourceItems = new ArrayList<>();
        if(title.equals("Scholarships")){
            resourceItems.add(new ResourceItem("scholarships.com","https://www.scholarships.com/"));
            resourceItems.add(new ResourceItem("College Board","https://opportunity.collegeboard.org/"));

        }
        else if(title.equals("Exam Prep")){
            resourceItems.add(new ResourceItem("Khan Academy","https://www.khanacademy.org/"));
            resourceItems.add(new ResourceItem("The Princeton Review","https://www.princetonreview.com/"));
            resourceItems.add(new ResourceItem("College Board","https://collegereadiness.collegeboard.org/sat"));


        }
        else{
            resourceItems.add(new ResourceItem("Adventures in Education","https://www.aie.org/"));
            resourceItems.add(new ResourceItem("College Basics","https://www.collegebasics.com/"));
            resourceItems.add(new ResourceItem("College Prep 101","http://www.collegeprep101.com/"));



        }

        ListView listView = findViewById(R.id.resource_item_listview);
        ResourceAdapter resourceAdapter = new ResourceAdapter(this,resourceItems);
        listView.setAdapter(resourceAdapter);
    }

    private void increaseCollegeScore(){

    }
}