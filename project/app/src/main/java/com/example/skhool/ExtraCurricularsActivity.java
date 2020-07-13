package com.example.skhool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import android.widget.TextView;

import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import static com.example.skhool.R.layout.extracurricular_item;

public class ExtraCurricularsActivity extends AppCompatActivity {
    EditText editTextYears;
    EditText editTextName;
    ListView listView;
    int collegeScore;
    ArrayList<ExtraCurricularItem> list = new ArrayList<ExtraCurricularItem>();
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra_curriculars);

        listView = findViewById(R.id.extracurriculars_listview);
        editTextName = findViewById(R.id.editTextName);
        editTextYears = findViewById(R.id.editTextYears);
        fAuth = FirebaseAuth.getInstance();



    }

    public void addExtraCurricular(View view) {



        final ExtraCurricularAdapter[] extraCurricularAdapter = new ExtraCurricularAdapter[1];

        ExtraCurricularItem newItem = new ExtraCurricularItem(editTextName.getText().toString(), editTextYears.getText().toString());
        list.add(newItem);
        final DocumentReference[] docRef = {fStore.collection("users").document(user.getUid())};
        Map<String, Object> edited = new HashMap<>();
        edited.put("extracurriculars",list);
        docRef[0].update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(ExtraCurricularsActivity.this,"Extracurricular added successfully!",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ExtraCurricularsActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
        docRef[0].addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                ArrayList<String> extracurriculars = (ArrayList<String>) documentSnapshot.get("extracurriculars");
                extraCurricularAdapter[0] = new ExtraCurricularAdapter(getApplicationContext(),extracurriculars);
            }
        });
        listView.setAdapter(extraCurricularAdapter[0]);
        collegeScore++;




    }


}