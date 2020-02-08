package com.demo.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.myapplication.R;

public class ChatScreen extends AppCompatActivity {

    TextView showname;
    String str_name,showimg;
    ImageView showchat_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        showname = findViewById(R.id.show_name);
        showchat_image = findViewById(R.id.showchat_image);

        Intent i = getIntent();
        str_name = i.getStringExtra("NAME");
        showimg = i.getStringExtra("IMAGE");
        Log.d("showimg", "onCreate: "+showimg);

        showname.setText(str_name);
        showchat_image.setImageResource(Integer.parseInt(showimg));
       // Glide.with(this).load(Integer.parseInt(showimg)).into(showchat_image);


    }
}
