package com.example.danielmorales.comethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class payPalActivity extends AppCompatActivity {
    private Button singIn;
    private EditText emailText;
    private EditText passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_pal);

        singIn = (Button) findViewById(R.id.singIn);
        emailText = (EditText) findViewById(R.id.email);
        passwordText =(EditText) findViewById(R.id.password);


        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString().trim();
                String password = passwordText.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    //email is empty
                    Toast.makeText(getApplicationContext(), "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    //password is empty
                    Toast.makeText(getApplicationContext(), "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(payPalActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

    }

}
