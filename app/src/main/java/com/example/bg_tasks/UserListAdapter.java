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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
//        holder.btnDelete.setOnClickListener(view -> {
//            Toast.makeText(context, "" + (mUserList.get(position).id).toString(), Toast.LENGTH_SHORT).show();
//            mUserList.remove(mUserList.get(position).id);
//
//        });


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
            btnDelete.setOnClickListener(view -> {
                int pos  = getLayoutPosition();
                int id = mUserList.get(pos).id;
                ApiClient.getAPI().deleteUserByID(id).enqueue(new Callback<ArrayList<User>>() {
                    @Override
                    public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {

                        Toast.makeText(context, "id: "+id+" deleted", Toast.LENGTH_SHORT).show();
                        adapter.notifyItemRemoved(pos);
                    }
                    @Override
                    public void onFailure(Call<ArrayList<User>> call, Throwable t) {

                    }
                });


                // delete user with list
//                mUserList.remove(pos);
//                adapter.notifyDataSetChanged();


            });
            btnUpdate.setOnClickListener(view->{

                int pos  = getLayoutPosition();
                int id = mUserList.get(pos).id;

//                Toast.makeText(context, "" + (mUserList.get(pos).id).toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("id", id);
                intent.putExtra("pos", pos);
                context.startActivity(intent);
//                adapter.notifyDataSetChanged();
            });


        }
    }
//    update
//    nh???n n??t update ????? t??m ph???n t??? th??? m???y trong d??nh s??ch
//    l???y th??ng
//    n??m th??ng tin ra 1 trang kh??c
//    s???a th??ng tin
//    ?????t l???i th??ng tin

}
 // ApiClient.getAPI().getAllUsers().enqueue(new Callback<ArrayList<User>>() {
//                            @Override
//                            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
//                                mUserList.addAll(response.body());
//                                adapter.notifyDataSetChanged();
//                            }
//
//                            @Override
//                            public void onFailure(Call<ArrayList<User>> call, Throwable t) {
//
//
//                            }
//                        });
//                        adapter.notifyItemRemoved(pos);
