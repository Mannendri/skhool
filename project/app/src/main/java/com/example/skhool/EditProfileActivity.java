package com.example.skhool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditProfileActivity extends AppCompatActivity {
    EditText profileUsername, profileGrade, profileEmail;
    Button saveProfileInfo;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profileUsername = findViewById(R.id.profileUsername);
        profileGrade = findViewById(R.id.profileGrade);
        profileEmail = findViewById(R.id.profileEmail);
        saveProfileInfo = findViewById(R.id.saveProfileInfo);

        Intent data = getIntent();
        final String username = data.getStringExtra("username");
        final String grade = data.getStringExtra("grade");
        String email = data.getStringExtra("email");

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();

        profileUsername.setText(username);
        profileGrade.setText(grade);
        profileEmail.setText(email);

        saveProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (profileUsername.getText().toString().isEmpty() || profileGrade.getText().toString().isEmpty() ||
                    profileEmail.getText().toString().isEmpty()){
                    Toast.makeText(EditProfileActivity.this,"One or many fields are empty.",Toast.LENGTH_SHORT).show();
                    return;
                }
                final String email = profileEmail.getText().toString();
                user.updateEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        DocumentReference docRef = fStore.collection("users").document(user.getUid());
                        Map<String, Object> edited = new HashMap<>();
                        edited.put("email",email);
                        edited.put("username",profileUsername.getText().toString());
                        edited.put("grade",profileGrade.getText().toString());
                        docRef.update(edited).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(EditProfileActivity.this,"Profile updated successfully!",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(EditProfileActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(EditProfileActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}