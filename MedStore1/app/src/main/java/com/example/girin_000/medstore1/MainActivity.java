package com.example.girin_000.medstore1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    //Button BtnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Buttons
        Button BtnNewUser = (Button) findViewById(R.id.BtnCreateUser);
        BtnNewUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching create new user activity
                Intent i = new Intent(getApplicationContext(), NewUserActivity.class);
                startActivity(i);

            }
        });

    }
    }

