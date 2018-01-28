package com.example.danielmorales.comethru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SingIn extends AppCompatActivity {

    private int person;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        TextView registerButtton = (TextView) findViewById(R.id.register);

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

    }


}
