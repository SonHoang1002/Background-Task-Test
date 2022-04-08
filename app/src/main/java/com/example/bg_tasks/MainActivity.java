package com.example.bg_tasks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private UserListAdapter mAdapter;
    ArrayList<User> mWordList = new ArrayList<>();


    // 88fd6d644cc96d508867db023178aa79dc166ebab06cef2aa12855342a566aba
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new UserListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                mWordList.addAll(response.body());
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });


    }

//    public void startTask(View view) {
//        mTextView.setText("Loading..");
////        button1.setVisibility(View.INVISIBLE);
//
//        ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//            @Override
//            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                ArrayList<User> userList = response.body();
//                mTextView.setText("Number of Users: " + userList.size());
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//            }
//        });
//
//        ApiClient.getAPI().getUsersByID(3387).enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                mTextView.setText(""+user.name);
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                mTextView.setText("Error:" + t.getMessage());
//            }
//        });
//        new Thread(() -> {
//            try {
//                URL url = new URL("https://gorest.co.in/public/v2/users");
//                HttpURLConnection httpsConnection  = (HttpURLConnection) url.openConnection();
//                BufferedReader in = new BufferedReader(new InputStreamReader(httpsConnection.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                handler.post(() -> {
//                    mTextView.setText(response);
//                    button1.setVisibility(View.VISIBLE);
//                });
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();
//        new Thread(() -> {
//            int n = new Random().nextInt(11);
//            int s = 6000;
//            try {
//                for (int i = 0; i < 100; i++) {
//                    Thread.sleep(s / 600);
//                    int finalI = i;
//                    handler.post(() -> progressBar.setProgress(finalI));
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            handler.post(() -> {
//                mTextView.setText("Done: ");
//                button1.setVisibility(View.VISIBLE);
//            });
//        }).start();


}