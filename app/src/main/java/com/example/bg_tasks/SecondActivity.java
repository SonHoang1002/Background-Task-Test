package com.example.bg_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {
    TextView tVSecond;

    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tVSecond = findViewById(R.id.tVSecond);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 4058);
        btnBack.setOnClickListener(view->{
            startActivity(new Intent(SecondActivity.this, MainActivity.class));
        });


        ApiClient.getAPI().getUsersByID(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                tVSecond.setText("Id: " + id + "\n Name: " + user.name + " \n Email: " + user.email + "\n Gender: " + user.gender + "\n Status: " + user.status);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

                tVSecond.setText("Error: " + t.getMessage());
            }
        });
    }
}