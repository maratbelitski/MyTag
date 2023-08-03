package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.example.mytag.support.ButtonsAnimation;
import java.util.Arrays;
import java.util.List;

public class WinnerActivity extends AppCompatActivity implements ButtonsAnimation {

    private static final String COUNT = "count_step";
    private static final String TYPE_GAME = "type_game";
    private static final String LEVEL_GAME = "level_game";
    private static final String NUMBER_FACT = "number_fact";
    private static final String LAST_GAME = "last_game";

    private static int countStep,random;
    private static String typeGame;
    private static String levelGame;
    FrameLayout layoutAnswerSquirrel;
    TextView fact, textSquirrel, textCountStep,angryAnswer;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);


        countStep = (int) getIntent().getExtras().get(COUNT);
        typeGame = (String) getIntent().getExtras().get(TYPE_GAME);
        levelGame = (String) getIntent().getExtras().get(LEVEL_GAME);

        //формируем записи по последней партии
        SharedPreferences sharedPreferences2 = getSharedPreferences(LAST_GAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences2.edit();

        editor2.putInt(COUNT, countStep);
        editor2.putString(TYPE_GAME, typeGame);
        editor2.putString(LEVEL_GAME, levelGame);
        editor2.apply();

        fact = findViewById(R.id.t_fact);
        layoutAnswerSquirrel = findViewById(R.id.l_answer_squirrel);
        angryAnswer = findViewById(R.id.t_angry_answer);
        textSquirrel = findViewById(R.id.b_text_squirrel);
        textCountStep = findViewById(R.id.text_count_step);
        textCountStep.setText(getResources().getString(R.string.text_steps_winner) + " " + countStep);

        Button start = findViewById(R.id.b_start_game);
        Button stop = findViewById(R.id.b_stop_game);

        showButtonAnimation(start);
        showButtonAnimation(stop);

        makeFacts();
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

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        WinnerActivity.this.finish();
    }

    public static String getCOUNT() {
        return COUNT;
    }

    public static String getTypeGame() {
        return TYPE_GAME;
    }

    public static String getLevelGame() {
        return LEVEL_GAME;
    }

    public static String getNumberFact() {
        return NUMBER_FACT;
    }

    public static String getLastGame() {
        return LAST_GAME;
    }

    public void makeFacts(){
        if (levelGame.equals("easy")){
            fact.setVisibility(View.GONE);
            layoutAnswerSquirrel.setVisibility(View.VISIBLE);
            textSquirrel.setVisibility(View.VISIBLE);
            angryAnswer.setVisibility(View.VISIBLE);

            List<String> listTextSquirrel = Arrays.asList(getResources().getStringArray(R.array.text_angry_squirrel));
            textSquirrel.setText(listTextSquirrel.get((int) (Math.random() * 10 + 0)));
        }else if(levelGame.equals("normal")){
            fact.setVisibility(View.VISIBLE);
            layoutAnswerSquirrel.setVisibility(View.GONE);
            textSquirrel.setVisibility(View.GONE);
            angryAnswer.setVisibility(View.GONE);

            List<String> listFacts = Arrays.asList(getResources().getStringArray(R.array.facts_about_squirrel));
            //создаем нужный сшаред
            SharedPreferences sharedPreferences = getSharedPreferences(NUMBER_FACT, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (typeGame.equals("classic")){
                random = (int) (Math.random() * 10 + 0);
            }else {
                random = (int) (Math.random() * 10 + 10);
            }
            fact.setText(listFacts.get(random));

            //так появляется каждый раз новая переменная для сохранения
            editor.putString(NUMBER_FACT + random, listFacts.get(random));
            editor.apply();
        }
    }
}