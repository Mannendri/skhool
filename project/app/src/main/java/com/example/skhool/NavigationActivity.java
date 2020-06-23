package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
//// Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("message");
//
//        myRef.setValue("Hello, World!");
    }

    public void openResourceCenterActivity(View view) {
        Intent intentToOpenResourceCenterActivity = new Intent(this,ResourceCenterActivity.class);
        startActivity(intentToOpenResourceCenterActivity);
    }

    public void openLoginActivity(View view) {
        Intent intentToOpenLoginActivity = new Intent(this,LoginActivity.class);
        startActivity(intentToOpenLoginActivity);
    }

    public void openRegisterActivity(View view) {
        Intent intentToOpenRegisterActivity = new Intent(this, RegisterActivity.class);
        startActivity(intentToOpenRegisterActivity);
    }
}