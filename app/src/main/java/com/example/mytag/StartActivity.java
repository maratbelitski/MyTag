package com.example.mytag;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;



public class StartActivity extends AppCompatActivity{

    public String level = "";
    public String type = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ImageView image_title_game =findViewById(R.id.image_title_game);
        Spinner spinner1 = findViewById(R.id.spinner_1);
        Spinner spinner2 = findViewById(R.id.spinner_2);

        ArrayAdapter<CharSequence> adapterArray = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapterArray2 = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterArray);
        spinner1.setAdapter(adapterArray2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            if(position==1){
                image_title_game.setImageResource(R.drawable.image_normal);
                level="normal";
            }else {
                image_title_game.setImageResource(R.drawable.image_easy);
                level="easy";
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
        if(level.equals("normal")) {
           destination= NormalActivity.class;
        }else if (level.equals("easy")){
            destination= EasyActivity.class;
        }
        Intent intent = new Intent(this, destination);
        startActivity(intent);
    }
}