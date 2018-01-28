package com.example.danielmorales.comethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.view.View;
=======
>>>>>>> 735a8f9cf8441d3ab27533ae0bd61a8a85fbdbf4
import android.widget.Button;

public class Register extends AppCompatActivity {

<<<<<<< HEAD
    private Button customer_button;
    private Button vender_button;
=======
    private Button consumer_button;
    private Button ice_cream_man;
>>>>>>> 735a8f9cf8441d3ab27533ae0bd61a8a85fbdbf4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

<<<<<<< HEAD
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
=======

        Button consumer_button = (Button) findViewById(R.id.)
>>>>>>> 735a8f9cf8441d3ab27533ae0bd61a8a85fbdbf4

    }

}
