package com.example.danielmorales.comethru;

import android.app.ProgressDialog;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.StreamHandler;


public class CustomerRegistration extends AppCompatActivity implements View.OnClickListener {
    private Button buttonRegister2;
    private EditText emailButton2;
    private EditText passwordButton2;
    private Button paypal;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        buttonRegister2 = (Button) findViewById(R.id.registerButton);
        emailButton2 = (EditText) findViewById(R.id.customer_registration_email);
        passwordButton2 = (EditText) findViewById(R.id.password);

        buttonRegister2.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

    }
    public void registerUser(){
        String email = emailButton2.getText().toString().trim();
        String password = passwordButton2.getText().toString().trim();

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

        Intent intent = new Intent(CustomerRegistration.this,payPalActivity.class);
        startActivity(intent);
        
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //user is succesfully registered and logged in
                            //we well start the profile activity here
                            //right now lets display a toast only
                            Toast.makeText(CustomerRegistration.this, "Registered Successfully ", Toast.LENGTH_SHORT).show();
                        }else{
                            //Toast.makeText(CustomerRegistration.this, "Could not register. Please try again ", Toast.LENGTH_SHORT).show();
                        }
                        Intent intent = new Intent(CustomerRegistration.this, payPalActivity.class);
                        startActivity(intent);
                    }
                });


        //if validations are okay

        progressDialog.setMessage("Registering User");
        progressDialog.show();
    }

    @Override
    public void onClick(View view){
        if(view == buttonRegister2){
            registerUser();
        }

    }
}
