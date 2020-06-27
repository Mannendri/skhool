package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

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
                intentToOpenInfoCenter.putExtra("grade",grade);
                startActivity(intentToOpenInfoCenter);
            }
        });

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.sign_out_menu) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(IntroInfoCenterActivity.this, "Signed out successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this.getApplicationContext(),MainActivity.class));
            finish();
            return true;
        }
        else if (item.getItemId() == R.id.resource_center_menu){
            startActivity(new Intent(this.getApplicationContext(),ResourceCenterActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.profile_menu){
            startActivity(new Intent(this.getApplicationContext(),ProfileActivity.class));
            return true;
        }
        else if (item.getItemId() == R.id.dashboard_menu){
            startActivity(new Intent(this.getApplicationContext(),DashboardActivity.class));
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }
}
