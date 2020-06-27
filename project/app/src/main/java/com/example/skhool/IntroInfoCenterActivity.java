package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntroInfoCenterActivity extends AppCompatActivity {
    EditText editTextGrade;
    Button searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_info_center);
        editTextGrade = findViewById(R.id.editTextGrade);

        searchBtn = findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = editTextGrade.getText().toString();
                Intent intentToOpenInfoCenter = new Intent(getApplicationContext(), InfoCenterActivity.class);
                intentToOpenInfoCenter.putExtra("grade","grade");
                startActivity(intentToOpenInfoCenter);


            }
        });
    }
}