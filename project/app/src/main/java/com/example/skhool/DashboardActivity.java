package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
    private TextView collegeScoreTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        collegeScoreTV = findViewById(R.id.collegeScore);
        Intent data = getIntent();
        collegeScoreTV.setText(data.getStringExtra("collegeScore") +" / "+"50");

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.sign_out_menu) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(DashboardActivity.this, "Signed out successfully!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this.getApplicationContext(),MainActivity.class));
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
    @Override
    public void onBackPressed() {
        return;
    }

    public void openExtraCurricularsActivity(View view) {
        Intent intentToExtraCurricularsActivity = new Intent(this, ExtraCurricularsActivity.class);
        startActivity(intentToExtraCurricularsActivity);
    }

    public void openIntroInfoActivity(View view) {
        Intent intentToOpenIntroInfoActivity = new Intent(this,IntroInfoCenterActivity.class);
        startActivity(intentToOpenIntroInfoActivity);
    }
}