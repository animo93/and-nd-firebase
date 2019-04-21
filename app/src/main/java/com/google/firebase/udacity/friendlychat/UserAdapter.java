package com.google.firebase.udacity.friendlychat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by animo on 30/9/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

    private List<User> userList;
    private Context mContext;


    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public UserAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public UserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(parent instanceof RecyclerView){
            View view = LayoutInflater.from(mContext).inflate(
                    R.layout.user,
                    parent,
                    false
            );
            view.setFocusable(true);
            return new UserAdapterViewHolder(view);
        }else{
            throw new RuntimeException("Not bound to RecyclerView");
        }
    }

    @Override
    public void onBindViewHolder(UserAdapterViewHolder holder, int position) {
        Log.d("UserAdapter","position "+position);
        final User user = userList.get(position);
        if(user != null){
            Glide.with(mContext).load(user.getAvtar_url())
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.imageView);
            holder.titleView.setText(user.getUserName());
            holder.emailView.setText(user.getEmailId());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(view.getContext(),ChatActivity.class);
                    //Log.d("UserAdapter","current user "+currentUser.getUserId());
                    intent.putExtra("currentUser",Utility.getCurrentUserId(mContext));
                    intent.putExtra("chatUser" ,user.getUserId());
                    mContext.startActivity(intent);

                }
            });

        }

    }

    @Override
    public int getItemCount() {
        Log.d("UserAdapter","userlist "+userList);
        return userList != null ?userList.size() : 0;
    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder{

        public final ImageView imageView;
        public final TextView titleView;
        public final TextView emailView;
        public final View itemView;

        public UserAdapterViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            this.imageView = (ImageView) itemView.findViewById(R.id.avatar_id);
            this.titleView = (TextView) itemView.findViewById(R.id.title);
            this.emailView = (TextView) itemView.findViewById(R.id.email);
        }
    }
}
