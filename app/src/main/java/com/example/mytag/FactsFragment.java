package com.example.mytag;
import static com.example.mytag.WinnerActivity.getNumberFact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytag.support.ButtonsAnimation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FactsFragment extends Fragment implements ButtonsAnimation,View.OnClickListener {

    TextView fact1, fact2, fact3, fact4, fact5, fact6, fact7, fact8,
            fact9, fact10, fact11, fact12, fact13, fact14, fact15, fact16, fact17, fact18, fact19, fact20, noFacts;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //с фрагментами работает метод onClick  для кнопок
        //нужно имплементить  View.OnClickListener и использовать setOnClickListener(this);
        View view = inflater.inflate(R.layout.fragment_facts, container, false);
        Button ok = view.findViewById(R.id.b_ok);
        ok.setOnClickListener(this);
        showButtonAnimation(view.findViewById(R.id.b_ok));

        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(getNumberFact(), Context.MODE_PRIVATE);

        noFacts = view.findViewById(R.id.t_noFacts);

        List<TextView> listTextView = new ArrayList<>();
        listTextView.add(fact1 = view.findViewById(R.id.t_fact1));
        listTextView.add(fact2 = view.findViewById(R.id.t_fact2));
        listTextView.add(fact3 = view.findViewById(R.id.t_fact3));
        listTextView.add(fact4 = view.findViewById(R.id.t_fact4));
        listTextView.add(fact5 = view.findViewById(R.id.t_fact5));
        listTextView.add(fact6 = view.findViewById(R.id.t_fact6));
        listTextView.add(fact7 = view.findViewById(R.id.t_fact7));
        listTextView.add(fact8 = view.findViewById(R.id.t_fact8));
        listTextView.add(fact9 = view.findViewById(R.id.t_fact9));
        listTextView.add(fact10 = view.findViewById(R.id.t_fact10));
        listTextView.add(fact11 = view.findViewById(R.id.t_fact11));
        listTextView.add(fact12 = view.findViewById(R.id.t_fact12));
        listTextView.add(fact13 = view.findViewById(R.id.t_fact13));
        listTextView.add(fact14 = view.findViewById(R.id.t_fact14));
        listTextView.add(fact15 = view.findViewById(R.id.t_fact15));
        listTextView.add(fact16 = view.findViewById(R.id.t_fact16));
        listTextView.add(fact17 = view.findViewById(R.id.t_fact17));
        listTextView.add(fact18 = view.findViewById(R.id.t_fact18));
        listTextView.add(fact19 = view.findViewById(R.id.t_fact19));
        listTextView.add(fact20 = view.findViewById(R.id.t_fact20));

        List<String> listNumbersFacts =new ArrayList<>();
        listNumbersFacts.add("number_fact0");
        listNumbersFacts.add("number_fact1");
        listNumbersFacts.add("number_fact2");
        listNumbersFacts.add("number_fact3");
        listNumbersFacts.add("number_fact4");
        listNumbersFacts.add("number_fact5");
        listNumbersFacts.add("number_fact6");
        listNumbersFacts.add("number_fact7");
        listNumbersFacts.add("number_fact8");
        listNumbersFacts.add("number_fact9");
        listNumbersFacts.add("number_fact10");
        listNumbersFacts.add("number_fact11");
        listNumbersFacts.add("number_fact12");
        listNumbersFacts.add("number_fact13");
        listNumbersFacts.add("number_fact14");
        listNumbersFacts.add("number_fact15");
        listNumbersFacts.add("number_fact16");
        listNumbersFacts.add("number_fact17");
        listNumbersFacts.add("number_fact18");
        listNumbersFacts.add("number_fact19");

        //возвращаем факт если он был доступен при выигрыше
        for (int i = 0; i < listNumbersFacts.size(); i++) {
            if (sharedPreferences.contains(listNumbersFacts.get(i))) {
                listTextView.get(i).setText(sharedPreferences.getString(listNumbersFacts.get(i), ""));
                listTextView.get(i).setVisibility(View.VISIBLE);
                noFacts.setVisibility(View.GONE);
            }
        }
        return view;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this.getActivity(), MainActivity.class);
        startActivity(intent);
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
}