package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mytag.support.ButtonsAnimation;

public class RulesActivity extends AppCompatActivity implements ButtonsAnimation {
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        RulesActivity.this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        Button buttonOk = findViewById(R.id.b_ok);
        showButtonAnimation(buttonOk);
    }
public void getOK(View view){
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
    RulesActivity.this.finish();
    }
}