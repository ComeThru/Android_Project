package com.example.danielmorales.comethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SingIn extends AppCompatActivity {

    private int person;
    private TextView register;
    private Button sign_in_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        TextView registerButtton = (TextView) findViewById(R.id.register);
        Button sign_in_button = (Button) findViewById(R.id.signInButton);

        Intent intent = getIntent();
        person = intent.getIntExtra("person", 0);

        registerButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(person == 0){
                    Intent intent = new Intent(SingIn.this, Register.class);
                    startActivity(intent);
                }else{
                    ;
                }

            }
        });

        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SingIn.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}
