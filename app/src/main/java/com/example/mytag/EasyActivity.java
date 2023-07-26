package com.example.mytag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytag.support.ButtonsAnimation;
import com.example.mytag.support.Methods;
import com.example.mytag.support.MyView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EasyActivity extends AppCompatActivity implements Methods, ButtonsAnimation {
    public static int countStepsEasy;
    public static String valueTextNowEasy;
    public static int positionNewEmptyEasy = -1;
    public static int positionNewValueEasy = -1;
    public static List<String> valuesTagListEasy;
    public static List<MyView> valuesViewListEasy;


    public static String[][] matrixWinEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "4", "5", "6", "*"},
            {"*", "7", "8", " ", "*"},
            {"*", "*", "*", "*", "*"}};

    public static String[][] valuesTagArrayEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "4", "5", "6", "*"},
            {"*", "7", " ", "8", "*"},
            {"*", "*", "*", "*", "*"}};
    public static int[][] matrixSearchEasy = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 2, 3, 0},
            {0, 4, 5, 6, 0},
            {0, 7, 8, 9, 0},
            {0, 0, 0, 0, 0}};

    Button stopGame, shuffleTags;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text_step2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        stopGame = findViewById(R.id.b_stop_game);
        shuffleTags = findViewById(R.id.b_shuffle);
        text_step2 = findViewById(R.id.text_step2);

        showButtonAnimation(stopGame);
        showButtonAnimation(shuffleTags);

        valuesViewListEasy = new ArrayList<>();
        valuesViewListEasy.add(new MyView(text1 = findViewById(R.id.id_text1), image1 = findViewById(R.id.id_image1)));
        valuesViewListEasy.add(new MyView(text2 = findViewById(R.id.id_text2), image2 = findViewById(R.id.id_image2)));
        valuesViewListEasy.add(new MyView(text3 = findViewById(R.id.id_text3), image3 = findViewById(R.id.id_image3)));
        valuesViewListEasy.add(new MyView(text4 = findViewById(R.id.id_text4), image4 = findViewById(R.id.id_image4)));
        valuesViewListEasy.add(new MyView(text5 = findViewById(R.id.id_text5), image5 = findViewById(R.id.id_image5)));
        valuesViewListEasy.add(new MyView(text6 = findViewById(R.id.id_text6), image6 = findViewById(R.id.id_image6)));
        valuesViewListEasy.add(new MyView(text7 = findViewById(R.id.id_text7), image7 = findViewById(R.id.id_image7)));
        valuesViewListEasy.add(new MyView(text8 = findViewById(R.id.id_text8), image8 = findViewById(R.id.id_image8)));
        valuesViewListEasy.add(new MyView(text9 = findViewById(R.id.id_text9), image9 = findViewById(R.id.id_image9)));

        countStepsEasy = 0;
        valuesTagArrayEasy = shuffleTag(valuesTagArrayEasy);

        valuesTagListEasy = new ArrayList<>();
        for (int i = 0; i < valuesTagArrayEasy.length; i++) {
            for (int j = 0; j < valuesTagArrayEasy[i].length; j++) {
                if (i == 0 || i == valuesTagArrayEasy.length - 1 || j == 0 || j == valuesTagArrayEasy.length - 1) {
                    valuesTagArrayEasy[i][j] = "*";
                    continue;
                }
                valuesTagListEasy.add(valuesTagArrayEasy[i][j]);
            }
        }

        setAllViewMatrixEasy(valuesViewListEasy, valuesTagListEasy);
    }

    public void showMove2(View view) {
        valueTextNowEasy = findValueTextNow(view);

        ClickOnTagEasy();
        text_step2.setText(String.valueOf(countStepsEasy));

        if (Arrays.deepEquals(valuesTagArrayEasy, matrixWinEasy)) {
            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra(WinnerActivity.COUNT, countStepsEasy);
            startActivity(intent);
        }
    }

    public void shuffleTags(View view) {
        valuesTagArrayEasy = shuffleTag(valuesTagArrayEasy);
        valuesTagListEasy = new ArrayList<>();
        for (int i = 0; i < valuesTagArrayEasy.length; i++) {
            for (int j = 0; j < valuesTagArrayEasy[i].length; j++) {
                if (i == 0 || i == valuesTagArrayEasy.length - 1 || j == 0 || j == valuesTagArrayEasy.length - 1) {
                    valuesTagArrayEasy[i][j] = "*";
                    continue;
                }
                valuesTagListEasy.add(valuesTagArrayEasy[i][j]);
            }
        }
        setAllViewMatrixEasy(valuesViewListEasy, valuesTagListEasy);

        countStepsEasy = 0;
        text_step2.setText(String.valueOf(countStepsEasy));
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }


    public String findValueTextNow(View view) {
        ImageView view1 = findViewById(view.getId());

        if (view1 == image1) {
            valueTextNowEasy = (String) text1.getText();
        } else if (view1 == image2) {
            valueTextNowEasy = (String) text2.getText();
        } else if (view1 == image3) {
            valueTextNowEasy = (String) text3.getText();
        } else if (view1 == image4) {
            valueTextNowEasy = (String) text4.getText();
        } else if (view1 == image5) {
            valueTextNowEasy = (String) text5.getText();
        } else if (view1 == image6) {
            valueTextNowEasy = (String) text6.getText();
        } else if (view1 == image7) {
            valueTextNowEasy = (String) text7.getText();
        } else if (view1 == image8) {
            valueTextNowEasy = (String) text8.getText();
        } else if (view1 == image9) {
            valueTextNowEasy = (String) text9.getText();
        }
        return valueTextNowEasy;
    }
}