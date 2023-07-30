package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytag.support.ButtonsAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinnerActivity extends AppCompatActivity implements ButtonsAnimation {


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        WinnerActivity.this.finish();
    }

    public static final String COUNT = "countStep";
    public static String NUMBER_FACT = "numberFact";
    public  static List<String> LIST_FACTS;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        int countStep = (int) getIntent().getExtras().get(COUNT);

        TextView fact = findViewById(R.id.b_fact);
        TextView textSquirrel = findViewById(R.id.b_text_squirrel);
        TextView textCountStep = findViewById(R.id.text_count_step);
        textCountStep.setText("Ходов сделано: " + countStep);

        Button start = findViewById(R.id.b_start_game);
        Button stop = findViewById(R.id.b_stop_game);

        showButtonAnimation(start);
        showButtonAnimation(stop);


        List<String> listTextSquirrel = Arrays.asList(getResources().getStringArray(R.array.text_angry_squirrel));
        textSquirrel.setText(listTextSquirrel.get((int) (Math.random() * 10 + 0)));

        List<String> listFacts = Arrays.asList(getResources().getStringArray(R.array.facts_about_squirrel));
        int random = (int) (Math.random() * 20 + 0);
        fact.setText(listFacts.get(random));


        //сохраняем номер факта в сшаред
        SharedPreferences sharedPreferences = getSharedPreferences(NUMBER_FACT, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //так появляется каждый раз новая переменная для сохранения
        editor.putString(NUMBER_FACT + random, listFacts.get(random));
        editor.apply();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        WinnerActivity.this.finish();
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        WinnerActivity.this.finish();
    }
}