package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
    Intent intent = new Intent(this, StartActivity.class);
    startActivity(intent);
    }


    public void showControl(View view) {
        Intent intent = new Intent(MainActivity.this, ControlActivity.class);
        startActivity(intent);
    }

    public void showRules(View view) {
        Intent intent = new Intent(MainActivity.this, RulesActivity.class);
        startActivity(intent);
    }
}