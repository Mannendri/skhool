package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.mymulti_screenapp.InfoAdapter;

import java.util.ArrayList;

public class InfoCenterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_center);

        ListView infoCenterListView = findViewById(R.id.info_center_list_view);

        ArrayList<InfoItem> info9 = new ArrayList<>();
        String grades9 = "\u2022Grades are important in ninth grade along with academic rigor. Make sure you seek advice from a guidance counselor" +
                "or teacher to ensure you are choosing challenging courses.\n" +
                "\u2022Writing is essential to nearly every class in high school and college. If " +
                "you need extra help or tutoring in writing, get it now. Don't worry about receiving a bad essay grade, but make sure you learn from " +
                "your mistakes";
        info9.add(new InfoItem("Grades", grades9,R.drawable.grades));
        String scores9 = "\u2022Be aware of Regents exams. It is important that you take these exams and perform well on them.\n" +
                "\u2022Try to be reading all the time!\n" +
                "\u2022Use the resources available to you at local community organizations and your public library.\n";
        info9.add(new InfoItem("Score",scores9,R.drawable.book));
        String activities9 = "\u2022Make your summers count. Find a job or program that builds on favorite subjects, extracurriculars, or hobbies";
        info9.add(new InfoItem("Activities",activities9,R.drawable.activity));
        String legwork9 = "\u2022Start talking to your family about your family budget. How will you pay for college? You can start saving now for " +
                "a laptop or other college essentials.\n" +
                "\u2022Start looking into requirements for honors or scholarship programs at colleges. These programs can help significantly on the" +
                "financial front.\n" +
                "\u2022Make sure that your identity (i.e. your name) is consistent on all transcripts, standardized tests, application, etc.";
        info9.add(new InfoItem("Legwork",legwork9,R.drawable.important));

        Intent data = getIntent();
        String choice = data.getStringExtra("grade");
        if (choice=="9"){
            com.example.mymulti_screenapp.InfoAdapter infoAdapter = new InfoAdapter(this, info9);
            infoCenterListView.setAdapter(infoAdapter);
        }

    }

}