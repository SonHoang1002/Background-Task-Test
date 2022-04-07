package com.example.bg_tasks;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private Context context;
    private ArrayList<User> mUserList;

    public UserListAdapter(Context context, ArrayList<User> mUserList) {
        this.context = context;
        this.mUserList = mUserList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(context);
        View mItemView = mInflater.inflate(R.layout.user_list_item, parent, false);
        return new UserViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.tVUser.setText(mUserList.get(position).name);
        holder.btnDelete.setOnClickListener(view -> {
            Toast.makeText(context, "" + (mUserList.get(position).id).toString(), Toast.LENGTH_SHORT).show();
        });


    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tVUser;
        Button btnDelete, btnUpdate;
        UserListAdapter adapter;

        public UserViewHolder(@NonNull View itemView, UserListAdapter userListAdapter) {
            super(itemView);
            adapter = userListAdapter;
            tVUser = itemView.findViewById(R.id.tVUser);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            btnUpdate = itemView.findViewById(R.id.btnUpdate);
            itemView.setOnClickListener(view -> {
                int id = mUserList.get(getLayoutPosition()).id;
                Toast.makeText(context, "this is: " + id, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("id", id);
                context.startActivity(intent);
            });


        }
    }
}

