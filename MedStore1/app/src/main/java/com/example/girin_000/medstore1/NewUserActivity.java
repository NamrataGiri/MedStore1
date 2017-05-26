package com.example.girin_000.medstore1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by girin_000 on 5/24/2017.
 */

public class NewUserActivity extends AppCompatActivity {
    // Progress Dialog
    private ProgressDialog pDialog;

    //creation of OkHttpClient, request
    private OkHttpClient okhttpclient;
    private Request request;

    //url
    private String url_create_user = "192.168.1.6:9090/MedStoreTest/create_user.php";

    //Parameters
    EditText User;
    EditText Pass;
    EditText Add;
    EditText PhoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_user);

        // Edit Text
        User = (EditText) findViewById(R.id.UserName);
        Pass = (EditText) findViewById(R.id.Password);
        Add = (EditText) findViewById(R.id.Address);
        PhoneNo = (EditText) findViewById(R.id.Phone);

        Button AddUser = (Button) findViewById(R.id.btnUser);
        AddUser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              // initalize http client
                okhttpclient = new OkHttpClient();
                System.out.print(User.getText().toString());
                //initialize http request
                RequestBody formBody = new FormBody.Builder()
                        .add("FirstName", User.getText().toString())
                        .add("Password", Pass.getText().toString())
                        .add("Address",Add.getText().toString() )
                        .add("Phone",PhoneNo.getText().toString() )
                        .build();

                Request request = new Request.Builder()
                        .url(url_create_user).post(formBody).build();

                //execute the request
                okhttpclient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i(TAG,e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i(TAG,response.body().string());
                    }
                });

            }
        });
    }
}
