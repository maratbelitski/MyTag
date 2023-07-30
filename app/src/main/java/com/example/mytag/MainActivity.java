package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mytag.support.ButtonsAnimation;


public class MainActivity extends AppCompatActivity implements ButtonsAnimation {
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRules = findViewById(R.id.b_rules);
        Button buttonStartGame = findViewById(R.id.b_start_game);
        Button buttonRecords = findViewById(R.id.b_records);
        ImageView imageMyTag = findViewById(R.id.image_mytag);

        showButtonAnimation(buttonRules);
        showButtonAnimation(buttonStartGame);
        showButtonAnimation(buttonRecords);

        Animation turn = AnimationUtils.loadAnimation((Context) this, R.anim.turn_animation);
        imageMyTag.startAnimation(turn);
    }

    public void startGame(View view) {
    Intent intent = new Intent(this, StartActivity.class);
    startActivity(intent);
    MainActivity.this.finish();
    }

    public void showRules(View view) {
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }

    public void showRecords(View view) {
        Intent intent = new Intent(this,RecordsActivity.class);
        startActivity(intent);
    }
}