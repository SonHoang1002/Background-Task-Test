

package com.example.bg_tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    TextView pTName,pTEmail,pTGender,pTStatus,tVUpdate;
    Button btnChange;
    ArrayList<User> mWordList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tVUpdate = findViewById(R.id.tVUpdate);
        pTName = findViewById(R.id.pTName);
        btnChange = findViewById(R.id.btnChange);
        pTEmail = findViewById(R.id.pTEmail);
        pTGender = findViewById(R.id.pTGender);
        pTStatus = findViewById(R.id.pTStatus);


        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 4058);
        int pos = intent.getIntExtra("pos", 0);
//        Toast.makeText(this, "update id: " + id, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "update pos: "+pos, Toast.LENGTH_SHORT).show();
//        tVUpdate.setText(new StringBuilder().append("id: ").append(id).append(" pos: ").append(pos).toString());
//        btnBack.setOnClickListener(view->{
//            startActivity(new Intent(SecondActivity.this, MainActivity.class));
//        });

       ApiClient.getAPI().getUsersByID(id).enqueue(new Callback<User>() {
           @Override
           public void onResponse(Call<User> call, Response<User> response) {
               User user = response.body();
               pTName.setText(user.name);
               pTEmail.setText(user.email);
               pTGender.setText(user.gender);
               pTStatus.setText(user.status);
           }

           @Override
           public void onFailure(Call<User> call, Throwable t) {
               tVUpdate.setText("Error: " + t.getMessage());
           }
       });
       btnChange.setOnClickListener(view->{
//          ApiClient.getAPI().
           Toast.makeText(this, "Update !!", Toast.LENGTH_SHORT).show();
       });



    }

}










