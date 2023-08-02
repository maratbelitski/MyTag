package com.example.mytag;

import static com.example.mytag.WinnerActivity.getCOUNT;
import static com.example.mytag.WinnerActivity.getLastGame;
import static com.example.mytag.WinnerActivity.getLevelGame;
import static com.example.mytag.WinnerActivity.getTypeGame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytag.support.ButtonsAnimation;

public class RecordsFragment extends Fragment implements ButtonsAnimation, View.OnClickListener {
    private static final String NEW_RECORDS = "new_records";
    private static final String COUNT_EASY_CLASSIC = "easy_classic";
    private static final String COUNT_NORMAL_CLASSIC = "normal_classic";
    private static final String COUNT_EASY_SNAKE = "easy_snake";
    private static final String COUNT_NORMAL_SNAKE = "normal_snake";


    private String oldTypeGame, oldLevelGame;
    private int oldCountStep, countStepEasyClassic, countStepNormalClassic, countStepEasySnake, newCountStepNormalSnake;

    TextView step3x3_classic, step4x4_classic, step3x3_snake, step4x4_snake;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_records, container, false);
        SharedPreferences oldRecords = this.getActivity().getSharedPreferences(getLastGame(), Context.MODE_PRIVATE);
        SharedPreferences newRecords = this.getActivity().getSharedPreferences(NEW_RECORDS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = newRecords.edit();

        countStepEasyClassic = newRecords.getInt("easy_classic", 1000);
        countStepNormalClassic = newRecords.getInt("easy_normal", 1000);
        countStepEasySnake = newRecords.getInt("easy_snake", 1000);
        newCountStepNormalSnake = newRecords.getInt("normal_snake", 1000);

        Button ok = view.findViewById(R.id.b_ok);
        ok.setOnClickListener(this);
        showButtonAnimation(view.findViewById(R.id.b_ok));

        step3x3_classic = view.findViewById(R.id.step3x3_classic);
        step4x4_classic = view.findViewById(R.id.step4x4_classic);
        step3x3_snake = view.findViewById(R.id.step3x3_snake);
        step4x4_snake = view.findViewById(R.id.step4x4_snake);

        oldCountStep = oldRecords.getInt(getCOUNT(), 0);
        oldTypeGame = oldRecords.getString(getTypeGame(), "");
        oldLevelGame = oldRecords.getString(getLevelGame(), "");

        changeRecord(editor);

        step3x3_classic.setText(String.valueOf(newRecords.getInt("easy_classic", 0)));
        step4x4_classic.setText(String.valueOf(newRecords.getInt("normal_classic", 0)));
        step3x3_snake.setText(String.valueOf(newRecords.getInt("easy_snake", 0)));
        step4x4_snake.setText(String.valueOf(newRecords.getInt("normal_snake", 0)));

        return view;
    }

    @Override
    public void onClick(View v) {
//        Intent intent = new Intent(this.getActivity(), MainActivity.class);
//        startActivity(intent);
//        this.getActivity().finish();
        this.getActivity().finish();
    }

    @Override
    @SuppressLint("ClickableViewAccessibility")
    public void showButtonAnimation(Button button) {
        Animation scaleUp = AnimationUtils.loadAnimation(this.getActivity(), R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation(this.getActivity(), R.anim.scale_down);
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.startAnimation(scaleUp);
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    button.startAnimation(scaleDown);
                }
                return false;
            }
        });
    }

    public void changeRecord(SharedPreferences.Editor editor) {
        if (oldTypeGame.equals("classic")) {
            if (oldLevelGame.equals("easy") && oldCountStep < countStepEasyClassic) {
                editor.putInt(COUNT_EASY_CLASSIC, oldCountStep);
            } else if (oldLevelGame.equals("normal") && oldCountStep < countStepNormalClassic) {
                editor.putInt(COUNT_NORMAL_CLASSIC, oldCountStep);
            }
        } else if (oldTypeGame.equals("snake")) {
            if (oldLevelGame.equals("easy") && oldCountStep < countStepEasySnake) {
                editor.putInt(COUNT_EASY_SNAKE, oldCountStep);
            } else if (oldLevelGame.equals("normal") && oldCountStep < newCountStepNormalSnake) {
                editor.putInt(COUNT_NORMAL_SNAKE, oldCountStep);
            }
        }
        editor.apply();
    }
}