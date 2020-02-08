package com.demo.myapplication.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.myapplication.Activities.ChatScreen;
import com.demo.myapplication.Model.Chats;
import com.demo.myapplication.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    ArrayList<Chats> chatsList = new ArrayList<>();
    Context context;

    public ChatAdapter(Context context, ArrayList<Chats> chatsList) {
        this.chatsList = chatsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

        final Chats chat = chatsList.get(position);
        holder.txtName.setText(chat.getName());
        holder.txtMsg.setText(chat.getLastMsg());
        holder.txtTime.setText(chat.getLastMsgTime());
        Glide.with(context)
                .load(chat.getImage())
                .apply(new RequestOptions().placeholder(R.drawable.rose))
                .into(holder.profilePic);

        final String IMAGE_URL= String.valueOf(chat.getImage());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(new Intent(context, ChatScreen.class));
                intent.putExtra("NAME", chat.getName());
                intent.putExtra("IMAGE", IMAGE_URL);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        if (chatsList != null) {
            return chatsList.size();
        }
        return 0;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ImageView profilePic;
        TextView txtName, txtMsg, txtTime;
        RelativeLayout relativeLayout;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePic = itemView.findViewById(R.id.profile_image);
            txtName = itemView.findViewById(R.id.text_username);
            txtMsg = itemView.findViewById(R.id.text_lastmsg);
            txtTime = itemView.findViewById(R.id.text_last_time);
            relativeLayout = itemView.findViewById(R.id.rl_Chat);


            profilePic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.activity_image_dialoge);

                    ImageView imger = dialog.findViewById(R.id.show_profile);
                    TextView textViewUser = dialog.findViewById(R.id.show_name);

                    textViewUser.setText(chatsList.get(getAdapterPosition()).getName());
                    Glide.with(context)
                            .load(chatsList.get(getAdapterPosition()).getImage())
                            .into(imger);
                    dialog.show();

                }
            });


        }
    }


}
