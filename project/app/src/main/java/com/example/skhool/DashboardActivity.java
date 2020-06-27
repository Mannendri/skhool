package com.example.skhool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

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
            startActivity(new Intent(this.getApplicationContext(),NavigationActivity.class));
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
}