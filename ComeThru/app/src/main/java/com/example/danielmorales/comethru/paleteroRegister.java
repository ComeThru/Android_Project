package com.example.danielmorales.comethru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;
import java.util.logging.FileHandler;
import java.util.logging.StreamHandler;

public class paleteroRegister extends AppCompatActivity {

    private Button buttonRegister;
    private EditText emailButton;
    private EditText passwordButton;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paletero_register);

        buttonRegister = (Button) findViewById(R.id.register);
        emailButton = (EditText) findViewById(R.id.email);
        passwordButton = (EditText) findViewById(R.id.password);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabase.child("Name").setValue("lol");
            }
        });
    }

    public void registerUser(){
        String email = emailButton.getText().toString().trim();
        String password = passwordButton.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        //if validations are okay

        progressDialog.setMessage("Registering User");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            //user is succesfully registered and logged in
                            //we well start the profile activity here
                            //right now lets display a toast only
                            Toast.makeText(paleteroRegister.this, "Registered Successfully ", Toast.LENGTH_SHORT).show();
                            String user_id = firebaseAuth.getCurrentUser().getUid();
                            DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("Users").child("Driver").child(user_id);
                            current_user_db.setValue(true);

                        }else{
                            //Toast.makeText(paleteroRegister.this, "Could not register. Please try again ", Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(paleteroRegister.this, MapsActivity.class);
                        startActivity(intent);
                    }
                });

    }
    /*
    @Override
    public void onClick(View view){
        if(view == buttonRegister){
            registerUser();
        }

    }
    */
}
