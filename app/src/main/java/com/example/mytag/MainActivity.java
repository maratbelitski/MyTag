package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.mytag.advance.AdvanceActivity;
import com.example.mytag.settings.SettingsActivity;
import com.example.mytag.support.ButtonsAnimation;
import com.example.mytag.support.InfoActivity;
import com.example.mytag.support.Language;
import com.example.mytag.support.MyAdapter;

import java.util.ArrayList;
import java.util.List;


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
        Button buttonInfo = findViewById(R.id.b_info);
        Button buttonStartGame = findViewById(R.id.b_start_game);
        Button buttonRecords = findViewById(R.id.b_records);
        Button buttonSettings = findViewById(R.id.b_settings);
        ImageView imageMyTag = findViewById(R.id.image_mytag);
        Spinner spinner = findViewById(R.id.s_spinner);

        showButtonAnimation(buttonRules);
        showButtonAnimation(buttonInfo);
        showButtonAnimation(buttonStartGame);
        showButtonAnimation(buttonRecords);
        showButtonAnimation(buttonSettings);

        Animation turn = AnimationUtils.loadAnimation((Context) this, R.anim.turn_animation);
        imageMyTag.startAnimation(turn);

        List<Language> languagesList = new ArrayList<>();
        String rus = getResources().getString(R.string.spinner_ru);
        String eng = getResources().getString(R.string.spinner_en);
        String pt = getResources().getString(R.string.spinner_pt);
        String def = getResources().getString(R.string.spinner_default);

        languagesList.add(new Language(def, R.drawable.ic_language));
        languagesList.add(new Language(eng, R.drawable.ic_usa));
        languagesList.add(new Language(rus, R.drawable.ic_russia));
        languagesList.add(new Language(pt, R.drawable.ic_portugal));

        MyAdapter spinnerAdapter = new MyAdapter(this, R.layout.layout_spinner_language, languagesList);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0) {
                    Language selectedItem = (Language) spinner.getSelectedItem();
                    String s = selectedItem.getName();

                    if (s.equalsIgnoreCase("английский") || s.equalsIgnoreCase("Inglês")) {
                        changeLanguage("en");
                    } else if (s.equalsIgnoreCase("russian")|| s.equalsIgnoreCase("Russo")) {
                        changeLanguage("ru");
                    }else if (s.equalsIgnoreCase("portuguese")|| s.equalsIgnoreCase("Португальский")) {
                        changeLanguage("pt ");
                    }
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
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
        Intent intent = new Intent(this, AdvanceActivity.class);
        startActivity(intent);
    }

    public void showInfo(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void showSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void changeLanguage(String lang) {
        LocaleListCompat localeListCompat = androidx.core.os.LocaleListCompat.forLanguageTags(lang);
        AppCompatDelegate.setApplicationLocales(localeListCompat);
        recreate();
    }
}