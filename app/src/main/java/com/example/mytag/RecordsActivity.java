package com.example.mytag;

import static android.app.PendingIntent.getActivity;
import static com.example.mytag.WinnerActivity.NUMBER_FACT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytag.support.ButtonsAnimation;

import java.util.ArrayList;
import java.util.List;


public class RecordsActivity extends AppCompatActivity implements ButtonsAnimation {

    TextView fact1, fact2, fact3, fact4, fact5, fact6, fact7, fact8,
            fact9, fact10, fact11, fact12, fact13, fact14, fact15, fact16, fact17, fact18, fact19, fact20, noFacts;


    //   SharedPreferences sharedPreferences = getSharedPreferences("numberFact", MODE_PRIVATE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        SharedPreferences sharedPreferences = getSharedPreferences(NUMBER_FACT, Context.MODE_PRIVATE);

        noFacts = findViewById(R.id.t_noFacts);
        Button ok = findViewById(R.id.b_ok);
        showButtonAnimation(ok);

        List<TextView> listTextView = new ArrayList<>();
        listTextView.add(fact1 = findViewById(R.id.t_fact1));
        listTextView.add(fact2 = findViewById(R.id.t_fact2));
        listTextView.add(fact3 = findViewById(R.id.t_fact3));
        listTextView.add(fact4 = findViewById(R.id.t_fact4));
        listTextView.add(fact5 = findViewById(R.id.t_fact5));
        listTextView.add(fact6 = findViewById(R.id.t_fact6));
        listTextView.add(fact7 = findViewById(R.id.t_fact7));
        listTextView.add(fact8 = findViewById(R.id.t_fact8));
        listTextView.add(fact9 = findViewById(R.id.t_fact9));
        listTextView.add(fact10 = findViewById(R.id.t_fact10));
        listTextView.add(fact11 = findViewById(R.id.t_fact11));
        listTextView.add(fact12 = findViewById(R.id.t_fact12));
        listTextView.add(fact13 = findViewById(R.id.t_fact13));
        listTextView.add(fact14 = findViewById(R.id.t_fact14));
        listTextView.add(fact15 = findViewById(R.id.t_fact15));
        listTextView.add(fact16 = findViewById(R.id.t_fact16));
        listTextView.add(fact17 = findViewById(R.id.t_fact17));
        listTextView.add(fact18 = findViewById(R.id.t_fact18));
        listTextView.add(fact19 = findViewById(R.id.t_fact19));
        listTextView.add(fact20 = findViewById(R.id.t_fact20));


        List<String> listNumbersFacts = new ArrayList<>();
        listNumbersFacts.add("numberFact0");
        listNumbersFacts.add("numberFact1");
        listNumbersFacts.add("numberFact2");
        listNumbersFacts.add("numberFact3");
        listNumbersFacts.add("numberFact4");
        listNumbersFacts.add("numberFact5");
        listNumbersFacts.add("numberFact6");
        listNumbersFacts.add("numberFact7");
        listNumbersFacts.add("numberFact8");
        listNumbersFacts.add("numberFact9");
        listNumbersFacts.add("numberFact10");
        listNumbersFacts.add("numberFact11");
        listNumbersFacts.add("numberFact12");
        listNumbersFacts.add("numberFact13");
        listNumbersFacts.add("numberFact14");
        listNumbersFacts.add("numberFact15");
        listNumbersFacts.add("numberFact16");
        listNumbersFacts.add("numberFact17");
        listNumbersFacts.add("numberFact18");
        listNumbersFacts.add("numberFact19");

        //возвращаем факт если он был доступен при выигрыше
        for (int i = 0; i < listNumbersFacts.size(); i++) {
            if (sharedPreferences.contains(listNumbersFacts.get(i))) {
                listTextView.get(i).setText(sharedPreferences.getString(listNumbersFacts.get(i), ""));
                listTextView.get(i).setVisibility(View.VISIBLE);
                noFacts.setVisibility(View.GONE);

            }
        }
    }


    public void getOK(View view) {
        finish();
    }
}