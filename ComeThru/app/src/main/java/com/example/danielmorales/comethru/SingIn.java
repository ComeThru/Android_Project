package com.example.danielmorales.comethru;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnContextClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SingIn extends AppCompatActivity implements View.OnClickListener{

    private int person;
    private TextView register;
    private EditText emailText;
    private EditText passwordText;
    private Button signIn;
    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        final Intent intent = getIntent();
        person = intent.getIntExtra("person", 0);

        register = (TextView) findViewById(R.id.register);
        emailText = (EditText) findViewById(R.id.email);
        passwordText = (EditText) findViewById(R.id.password);
        signIn = (Button) findViewById(R.id.signInButton);
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        signIn.setOnClickListener(this);
        register.setOnClickListener(this);

        Button mapButton = (Button) findViewById(R.id.mapButton);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingIn.this, MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void userLogin(){
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

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

        progressDialog.setMessage("Registering User");
        progressDialog.show();

        Log.d("sdk","kds");

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if(task.isSuccessful()){
                            Log.d("lol","lol");
                            //start the profile activity
                            Intent intent = new Intent(SingIn.this, MapsActivity.class);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == signIn){
            userLogin();
        }

        if(view == register) {
            finish();
            startActivity(new Intent(this, Register.class));
        }
    }
}
