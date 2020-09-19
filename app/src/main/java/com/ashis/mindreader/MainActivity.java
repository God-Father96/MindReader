package com.ashis.mindreader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    LinearLayout splash_screen;
    ImageView bg_app,chat;
    Animation fade_in,frombottom1,fade_in1;
    ScrollView menus;
    CardView startgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash_screen=findViewById(R.id.splashtext);
        bg_app=findViewById(R.id.bgapp);
        chat=findViewById(R.id.chat);
        fade_in1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in1);
        fade_in=AnimationUtils.loadAnimation(MainActivity.this,R.anim.fade_in);
        splash_screen.startAnimation(fade_in);
        bg_app.animate().translationY(-2500).setDuration(800).setStartDelay(2500);

        splash_screen.animate().translationY(140).alpha(0).setDuration(800).setStartDelay(2000);
        menus=findViewById(R.id.menus);
        frombottom1=AnimationUtils.loadAnimation(MainActivity.this,R.anim.frombottom1);
        chat.startAnimation(fade_in1);
        menus.startAnimation(frombottom1);
        startgame=findViewById(R.id.startgame);
        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,game.class));
            }
        });

    }
}