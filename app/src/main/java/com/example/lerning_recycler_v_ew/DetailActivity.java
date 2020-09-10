package com.example.lerning_recycler_v_ew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        ImageView imageView=findViewById(R.id.image_view_detail);
        TextView like=findViewById(R.id.like_detail);
        Intent intent=getIntent();
        Picasso.get().load(intent.getStringExtra(MainActivity.EXTRA_URL)).into(imageView);
        like.setText(intent.getStringExtra("pageURL"));
    }
}