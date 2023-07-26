package com.example.mytag;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.mytag.support.ButtonsAnimation;

import java.util.Arrays;
import java.util.List;


public class StartActivity extends AppCompatActivity implements ButtonsAnimation {

    public String level = "";
    public String type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageView image_title_game =findViewById(R.id.image_title_game);
        Spinner spinner1 = findViewById(R.id.spinner_1);
        Spinner spinner2 = findViewById(R.id.spinner_2);

        Button buttonStart = findViewById(R.id.b_start_game);
        Button buttonStop = findViewById(R.id.b_stop_game);

        showButtonAnimation(buttonStart);
        showButtonAnimation(buttonStop);


        List<String> types = Arrays.asList(getResources().getStringArray(R.array.type));
        List<String> levels = Arrays.asList(getResources().getStringArray(R.array.level));
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.spinner_layout, R.id.spinner_text, levels);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,
                R.layout.spinner_layout, R.id.spinner_text, types);

        spinner2.setAdapter(adapter);
        spinner1.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==1){
                image_title_game.setImageResource(R.drawable.image_normal);
                level="4x4";
            }else {
                image_title_game.setImageResource(R.drawable.image_easy);
                level="3x3";
            }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void startGame(View view) {
        Class<?> destination= MainActivity.class;
        if(level.equals("4x4")) {
           destination= NormalActivity.class;
        }else if (level.equals("3x3")){
            destination= EasyActivity.class;
        }
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}