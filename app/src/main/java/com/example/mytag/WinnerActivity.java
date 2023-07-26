package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.mytag.support.ButtonsAnimation;
import java.util.Arrays;
import java.util.List;

public class WinnerActivity extends AppCompatActivity implements ButtonsAnimation {
    public static final String COUNT = "countStep";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

       int countStep = (int) getIntent().getExtras().get(COUNT);

        TextView fact = findViewById(R.id.b_fact);
        TextView textSquirrel= findViewById(R.id.b_text_squirrel);
        TextView textCountStep = findViewById(R.id.text_count_step);
        textCountStep.setText("Ходов совершено: "+ countStep);

        Button start = findViewById(R.id.b_start_game);
        Button stop = findViewById(R.id.b_stop_game);

        showButtonAnimation(start);
        showButtonAnimation(stop);

        List<String> listTextSquirrel = Arrays.asList(getResources().getStringArray(R.array.text_angry_squirrel));
        textSquirrel.setText(listTextSquirrel.get((int) (Math.random() * 9 + 0)));

        List<String> listFacts = Arrays.asList(getResources().getStringArray(R.array.facts_about_squirrel));
        fact.setText(listFacts.get((int) (Math.random() * 19 + 0)));


    }

    public void startGame(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}