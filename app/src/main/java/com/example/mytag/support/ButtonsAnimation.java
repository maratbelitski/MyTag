package com.example.mytag.support;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.mytag.R;

import java.util.List;

/**
 * @author Belitski Marat
 * @date 25.07.2023
 */
public interface ButtonsAnimation {

    @SuppressLint("ClickableViewAccessibility")
    default void showButtonAnimation(Button button) {
        Animation scaleUp = AnimationUtils.loadAnimation((Context) this, R.anim.scale_up);
        Animation scaleDown = AnimationUtils.loadAnimation((Context) this, R.anim.scale_down);

        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
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

    default void shuffleAnimation(List<FrameLayout> list) {

        int size = list.size();
        Animation falling = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation);
        Animation falling2 = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation2);
        Animation falling3 = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation3);
        Animation falling4 = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation4);
        Animation falling2easy = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation2_easy);
        Animation falling3easy = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation3_easy);
        Animation falling4easy = AnimationUtils.loadAnimation((Context) this, R.anim.down_animation4_easy);


        for (int i = 0; i < size; i++) {
            list.get(i).setVisibility(View.INVISIBLE);
        }

        if (size > 9) {
            for (int i = 0; i < size; i++) {
                if (i == 0 || i == 4 || i == 8 || i == 12) {
                    list.get(i).startAnimation(falling4);
                } else if (i == 1 || i == 5 || i == 9 || i == 13) {
                    list.get(i).startAnimation(falling3);
                } else if (i == 2 || i == 6 || i == 10 || i == 14) {
                    list.get(i).startAnimation(falling2);
                } else {
                    list.get(i).startAnimation(falling);
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (i == 0 || i == 3 || i == 6) {
                    list.get(i).startAnimation(falling4easy);
                } else if (i == 1 || i == 4 || i == 7) {
                    list.get(i).startAnimation(falling3easy);
                } else {
                    list.get(i).startAnimation(falling2easy);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            list.get(i).setVisibility(View.VISIBLE);
        }
    }

    default void winnerAnimation(List<FrameLayout> list) {

        int size = list.size();
        Animation shake = AnimationUtils.loadAnimation((Context) this, R.anim.shake_animation);
        for (int i = 0; i < size; i++) {
            list.get(i).startAnimation(shake);
        }
    }

}
