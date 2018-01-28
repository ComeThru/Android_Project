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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.StreamHandler;


    public class CustomerRegistration extends AppCompatActivity  {
        private Button buttonRegister2;
        private EditText emailButton2;
        private EditText passwordButton2;
        private Button paypal;
        private ProgressDialog progressDialog;
        private FirebaseAuth firebaseAuth;
        private FirebaseAuth.AuthStateListener firebaseAuthListener;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_customer_registration);

            buttonRegister2 = (Button) findViewById(R.id.registerButton);
            emailButton2 = (EditText) findViewById(R.id.customer_registration_email);
            passwordButton2 = (EditText) findViewById(R.id.password);


            firebaseAuth = FirebaseAuth.getInstance();
            firebaseAuthListener = new FirebaseAuth.AuthStateListener() {

                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        Intent intent = new Intent(CustomerRegistration.this, CustomerRegistration.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
            };

            final String email = emailButton2.getText().toString().trim();
            final String password = passwordButton2.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                //email is empty
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)) {
                //password is empty
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                return;
            }
            buttonRegister2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(CustomerRegistration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(CustomerRegistration.this, "sign up error", Toast.LENGTH_SHORT).show();
                            } else {
                                String user_id = firebaseAuth.getCurrentUser().getUid();
                                DatabaseReference current_user_db = FirebaseDatabase.getInstance().getReference().child("User").child("Driver").child(user_id);
                                current_user_db.setValue(true);
                            }
                        }

                    });
                }
            });

            progressDialog.setMessage("Registering User");
            progressDialog.show();


        }

        @Override
        protected void onStart() {
            super.onStart();
            firebaseAuth.addAuthStateListener(firebaseAuthListener);
        }

        @Override
        protected void onStop() {
            super.onStop();
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }

    }

        /*

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
                        Intent intent = new Intent(CustomerRegistration.this, MapsActivity.class);
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
*/

