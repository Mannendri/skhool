package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.skhool.R.layout.extracurricular_item;

public class ExtraCurricularsActivity extends AppCompatActivity {
    EditText editTextYears;
    EditText editTextName;
    ListView listView;
    int collegeScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curriculars);

        listView = findViewById(R.id.extracurriculars_listview);
        editTextName = findViewById(R.id.editTextName);
        editTextYears = findViewById(R.id.editTextYears);


    }

    public void addExtraCurricular(View view) {
        ArrayList<ExtraCurricularItem> list = new ArrayList<ExtraCurricularItem>();
        ExtraCurricularItem newItem = new ExtraCurricularItem(editTextName.getText().toString(), editTextYears.getText().toString());
        list.add(newItem);
        ExtraCurricularAdapter extraCurricularAdapter = new ExtraCurricularAdapter(this,list);
        listView.setAdapter(extraCurricularAdapter);
        collegeScore++;



    }
}