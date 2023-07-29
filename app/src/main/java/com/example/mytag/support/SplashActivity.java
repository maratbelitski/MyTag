package com.example.mytag.support;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytag.MainActivity;
import com.example.mytag.R;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    ImageView squirrel,logo;
    TextView appName;
    ConstraintLayout layoutDev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //создаем сплашскрин
        Intent intent = new Intent(this, MainActivity.class);
        Thread thread = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

        squirrel = findViewById(R.id.imageView3);
        logo = findViewById(R.id.imageView5);
        appName = findViewById(R.id.textView);
        layoutDev = findViewById(R.id.constraintLayout);

        Animation left =AnimationUtils.loadAnimation(this, R.anim.left_animation);
        Animation right =AnimationUtils.loadAnimation(this, R.anim.right_animation);
        Animation down =AnimationUtils.loadAnimation(this, R.anim.down_animation);
        Animation arrive =AnimationUtils.loadAnimation(this, R.anim.arrive_animation);

        squirrel.startAnimation(arrive);
        logo.startAnimation(down);
        appName.startAnimation(left);
        layoutDev.startAnimation(right);
    }
}