package com.example.danielmorales.comethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    private Button customer_button;
    private Button vender_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        customer_button=(Button) findViewById(R.id.customer);
        vender_button=(Button) findViewById(R.id.vendorButton);

        customer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, CustomerRegistration.class);
                startActivity(intent);
            }
        });

        vender_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, paleteroRegister.class);
                startActivity(intent);
            }
        });

    }

}
