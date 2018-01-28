package com.example.danielmorales.comethru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


import java.sql.Driver;

public class MainActivity extends AppCompatActivity {
    private Button mDriver, mCustomer;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDriver = (Button) findViewById(R.id.Driver);
        mCustomer = (Button) findViewById(R.id.Customer);
        intent = new Intent(MainActivity.this, SingIn.class);

        mDriver.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intent.putExtra("person", 0);
                startActivity(intent);
                finish();
                return;
            }
        });

        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("person", 1);
                startActivity(intent);
                finish();
                return;
            }
        });
    }
}