package com.demo.myapplication.Fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.myapplication.Adapter.ChatAdapter;
import com.demo.myapplication.Model.Call;
import com.demo.myapplication.Model.Chats;
import com.demo.myapplication.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {

    private ArrayList<Chats> chats;
    private ChatAdapter chatAdapter;
    private RecyclerView recyclerView;
    private int Img_string1 = R.drawable.sky;
    private int Img_string2 = R.drawable.tree;
    private int Img_string3 = R.drawable.pro;
    private int Img_string4 = R.drawable.light;
    private int Img_string5 = R.drawable.flower;
    int img_string = R.drawable.rose;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.chats_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_chat);
        chats = new ArrayList<>();
        chatAdapter = new ChatAdapter(getContext(), chats);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(chatAdapter);
        ChatData();
    }

    private void ChatData() {

        chats.add(new Chats("ADA", img_string, "What About Next Plan?", "8:15 "));
        chats.add(new Chats("ODBNB", Img_string1, "Woow! Great So we will ready For that!", "5:15 "));
        chats.add(new Chats("Amit Gupta", Img_string2, "Are Bhai!, Wait i will share u a file.", "7:10 "));
        chats.add(new Chats("Afsar ", Img_string3, "Call Me When ur are free.", "1:00 "));
        chats.add(new Chats("Vinay Patil", Img_string4, "How r You Bro...", "06:30 "));
        chats.add(new Chats("Arun ", Img_string5, "Check Out My New Video On Youtube!", "05:56 "));
        chats.add(new Chats("Supriya Mam", img_string, "Hello", "04:30 "));


    }


}
