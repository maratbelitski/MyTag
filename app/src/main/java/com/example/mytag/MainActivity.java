package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytag.support.ButtonsAnimation;


public class MainActivity extends AppCompatActivity implements ButtonsAnimation {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonRules = findViewById(R.id.b_rules);
        Button buttonStartGame = findViewById(R.id.b_start_game);

        showButtonAnimation(buttonRules);
        showButtonAnimation(buttonStartGame);
    }

    public void startGame(View view) {
    Intent intent = new Intent(this, StartActivity.class);
    startActivity(intent);
    }

    public void showRules(View view) {
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }
}