package com.example.mytag.support;

import static android.content.Intent.ACTION_VIEW;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.mytag.R;

public class InfoActivity extends AppCompatActivity implements ButtonsAnimation{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Button b_rateApp = findViewById(R.id.b_rate_app);
        showButtonAnimation(b_rateApp);
    }

    public void goToPage(View view) {
       String id = "https://play.google.com/store/apps/dev?id=5651473701290024308";
    Intent intent = new Intent(ACTION_VIEW, Uri.parse(id));
    startActivity(intent);
    }
}