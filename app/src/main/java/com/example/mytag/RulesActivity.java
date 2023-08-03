package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.mytag.support.ButtonsAnimation;

public class RulesActivity extends AppCompatActivity implements ButtonsAnimation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Button buttonOk = findViewById(R.id.b_ok);
        showButtonAnimation(buttonOk);
    }

    public void getOK(View view) {
        finish();
    }
}