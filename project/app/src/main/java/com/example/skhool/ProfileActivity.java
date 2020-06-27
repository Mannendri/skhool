package com.example.skhool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import org.w3c.dom.DocumentType;

import javax.annotation.Nullable;

public class ProfileActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    TextView usernameTextView, gradeTextView, emailTextView;
    Button changePassword;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        usernameTextView = findViewById(R.id.usernameTextView);
        gradeTextView = findViewById(R.id.gradeTextView);
        emailTextView = findViewById(R.id.emailTextView);
        changePassword = findViewById(R.id.changePassword);
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        userID = fAuth.getCurrentUser().getUid();
        user = fAuth.getCurrentUser();

        final DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.exists()){
                    usernameTextView.setText(documentSnapshot.getString("username"));
                    gradeTextView.setText(documentSnapshot.getString("grade"));
                    emailTextView.setText(documentSnapshot.getString("email")) ;

                }
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText resetPassword = new EditText(v.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("Reset Password?");
                passwordResetDialog.setMessage("Enter new password (>6 characters): ");
                passwordResetDialog.setView(resetPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // extract the email and send reset link
                        String newPassword = resetPassword.getText().toString();
                        user.updatePassword(newPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(ProfileActivity.this,"Password updated successfully!",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(ProfileActivity.this,"Password update failed.",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //close the dialog
                    }
                });
                passwordResetDialog.create().show();
            }
        });
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
            Toast.makeText(ProfileActivity.this, "Signed out successfully!", Toast.LENGTH_SHORT).show();
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

    public void openEditProfileActivity(View view) {
        Intent intentToOpenEditProfileActivity = new Intent(this,EditProfileActivity.class);
        intentToOpenEditProfileActivity.putExtra("username",usernameTextView.getText().toString());
        intentToOpenEditProfileActivity.putExtra("grade",gradeTextView.getText().toString());
        intentToOpenEditProfileActivity.putExtra("email",emailTextView.getText().toString());
        startActivity(intentToOpenEditProfileActivity);
    }
}