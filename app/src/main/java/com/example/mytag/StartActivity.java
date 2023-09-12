package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.mytag.support.ButtonsAnimation;
import com.example.mytag.support.Methods;

import java.util.Arrays;
import java.util.List;


public class StartActivity extends AppCompatActivity implements ButtonsAnimation, Methods {
    private static final String FON_START = "fonStartValue";
    public String level = "";
    public String type = "";

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        StartActivity.this.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageView image_title_game = findViewById(R.id.image_title_game);
        Spinner spinner1 = findViewById(R.id.spinner_1);
        Spinner spinner2 = findViewById(R.id.spinner_2);

        Button buttonStart = findViewById(R.id.b_start_game);
        Button buttonStop = findViewById(R.id.b_stop_game);

        TextView typeGame = findViewById(R.id.t_type_game);

        showButtonAnimation(buttonStart);
        showButtonAnimation(buttonStop);

        //меняем в памяти фон после выбора в сеттинге
        SharedPreferences sharedPreferences = getSharedPreferences(FON_START, Context.MODE_PRIVATE);
        String valueFon = sharedPreferences.getString("fonStartValue", "");

        LinearLayout layoutBackground = findViewById(R.id.layout_background);
        layoutBackground.setBackground(getDrawable(changeBackground(valueFon)));


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
                if (position == 0) {
                    level = "3x3";
                } else {
                    level = "4x4";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    image_title_game.setImageResource(R.drawable.image_classic);
                    type = "classic";
                    typeGame.setText(R.string.text_classic);
                } else {
                    image_title_game.setImageResource(R.drawable.image_snake);
                    type = "snake";
                    typeGame.setText(R.string.text_snake);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void startGame(View view) {
        Class<?> destination = MainActivity.class;
        Intent intent = new Intent();

        if (level.equals("4x4")) {
            if (type.equals("classic")) {
                intent.putExtra(NormalActivity.TYPE_GAME, "classic");
            } else {
                intent.putExtra(NormalActivity.TYPE_GAME, "snake");
            }
            destination = NormalActivity.class;

        } else if (level.equals("3x3")) {
            if (type.equals("snake")) {
                intent.putExtra(EasyActivity.TYPE_GAME, "snake");
            } else {
                intent.putExtra(EasyActivity.TYPE_GAME, "classic");
            }
            destination = EasyActivity.class;
        }
        intent.setClass(this, destination);
        startActivity(intent);
        StartActivity.this.finish();
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        StartActivity.this.finish();
    }
}