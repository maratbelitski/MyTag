package com.example.mytag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mytag.support.ButtonsAnimation;
import com.example.mytag.support.Methods;
import com.example.mytag.support.MyView;
import com.example.mytag.support.Tags;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EasyActivity extends AppCompatActivity implements Methods, ButtonsAnimation {

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        EasyActivity.this.finish();
    }
    public static final String TYPE_GAME ="typeGame";
    public static String typeGame;
    public static int countSteps;
    public static String valueTextNow;
    public static int positionNewEmpty = -1;
    public static int positionNewValue = -1;
    public static List<String> tagList;



    public static List<MyView> viewList;
    public static List<FrameLayout> layoutList;

    public static String[][] matrixWin = Tags.matrixWinEasy;
    public static String[][] matrixWinSnake = Tags.matrixWinSnakeEasy;
    public static String[][] valuesTagArray = Tags.valuesTagArrayEasy;

    public static String[][] arraySnake = Tags.valuesTagArraySnakeEasy;
    public static int[][] matrixSearch = Tags.matrixSearchEasy;

    Button stopGame, shuffleTags;
    ImageView image1, image2, image3, image4, image5, image6, image7, image8, image9;
    TextView text1, text2, text3, text4, text5, text6, text7, text8, text9, text_step2,textTypeGame;
    FrameLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy);

        typeGame = (String) getIntent().getExtras().get(TYPE_GAME);

        stopGame = findViewById(R.id.b_stop_game);
        shuffleTags = findViewById(R.id.b_shuffle);
        text_step2 = findViewById(R.id.text_step2);

        textTypeGame = findViewById(R.id.t_type_game);

        showButtonAnimation(stopGame);
        showButtonAnimation(shuffleTags);

        layout1 = findViewById(R.id.id_frameLayout1);
        layout2 = findViewById(R.id.id_frameLayout2);
        layout3 = findViewById(R.id.id_frameLayout3);
        layout4 = findViewById(R.id.id_frameLayout4);
        layout5 = findViewById(R.id.id_frameLayout5);
        layout6 = findViewById(R.id.id_frameLayout6);
        layout7 = findViewById(R.id.id_frameLayout7);
        layout8 = findViewById(R.id.id_frameLayout8);
        layout9 = findViewById(R.id.id_frameLayout9);


        layoutList = new ArrayList<>();
        layoutList.add(layout1 = findViewById(R.id.id_frameLayout1));
        layoutList.add(layout2 = findViewById(R.id.id_frameLayout2));
        layoutList.add(layout3 = findViewById(R.id.id_frameLayout3));
        layoutList.add(layout4 = findViewById(R.id.id_frameLayout4));
        layoutList.add(layout5 = findViewById(R.id.id_frameLayout5));
        layoutList.add(layout6 = findViewById(R.id.id_frameLayout6));
        layoutList.add(layout7 = findViewById(R.id.id_frameLayout7));
        layoutList.add(layout8 = findViewById(R.id.id_frameLayout8));
        layoutList.add(layout9 = findViewById(R.id.id_frameLayout9));


        viewList = new ArrayList<>();
        viewList.add(new MyView(text1 = findViewById(R.id.id_text1), image1 = findViewById(R.id.id_image1)));
        viewList.add(new MyView(text2 = findViewById(R.id.id_text2), image2 = findViewById(R.id.id_image2)));
        viewList.add(new MyView(text3 = findViewById(R.id.id_text3), image3 = findViewById(R.id.id_image3)));
        viewList.add(new MyView(text4 = findViewById(R.id.id_text4), image4 = findViewById(R.id.id_image4)));
        viewList.add(new MyView(text5 = findViewById(R.id.id_text5), image5 = findViewById(R.id.id_image5)));
        viewList.add(new MyView(text6 = findViewById(R.id.id_text6), image6 = findViewById(R.id.id_image6)));
        viewList.add(new MyView(text7 = findViewById(R.id.id_text7), image7 = findViewById(R.id.id_image7)));
        viewList.add(new MyView(text8 = findViewById(R.id.id_text8), image8 = findViewById(R.id.id_image8)));
        viewList.add(new MyView(text9 = findViewById(R.id.id_text9), image9 = findViewById(R.id.id_image9)));

        if(typeGame.equals("classic")){
            valuesTagArray = shuffleTag(valuesTagArray);
            textTypeGame.setText(R.string.text_classic);
        }else {
            valuesTagArray = shuffleTag(arraySnake);
            textTypeGame.setText(R.string.text_snake);
        }

        tagList = arrayToList(valuesTagArray);
        shuffleAnimation(layoutList);
        setAllViewMatrix(viewList, tagList);
        countSteps = 0;
    }


    public void showMove2(View view){
        String string = "easy";
        String[][] matrix;

        if(typeGame.equals("classic")){
            matrix=matrixWin;
        }else {
            matrix=matrixWinSnake;
        }

        valueTextNow = findValueTextNow(view);

        ClickOnTag(string);
        text_step2.setText(String.valueOf(countSteps));


        if (Arrays.deepEquals(valuesTagArray, matrix)) {
            //помогает отработать метод с задержкой
            ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
            //нужно вернуть в исходное значение
            valuesTagArray=Tags.valuesTagArrayEasy;

            winnerAnimation(layoutList);

            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra(WinnerActivity.COUNT, countSteps);

            executorService.schedule(() -> startActivity(intent), 1500, TimeUnit.MILLISECONDS);
        }
    }

    public void shuffleTags(View view) {
        shuffleAnimation(layoutList);

        valuesTagArray = shuffleTag(valuesTagArray);

        tagList = arrayToList(valuesTagArray);
        setAllViewMatrix(viewList, tagList);

        countSteps = 0;
        text_step2.setText(String.valueOf(countSteps));
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
        EasyActivity.this.finish();
    }


    public String findValueTextNow(View view) {
        ImageView view1 = findViewById(view.getId());

        if (view1 == image1) {
            valueTextNow = (String) text1.getText();
        } else if (view1 == image2) {
            valueTextNow = (String) text2.getText();
        } else if (view1 == image3) {
            valueTextNow = (String) text3.getText();
        } else if (view1 == image4) {
            valueTextNow = (String) text4.getText();
        } else if (view1 == image5) {
            valueTextNow = (String) text5.getText();
        } else if (view1 == image6) {
            valueTextNow = (String) text6.getText();
        } else if (view1 == image7) {
            valueTextNow = (String) text7.getText();
        } else if (view1 == image8) {
            valueTextNow = (String) text8.getText();
        } else if (view1 == image9) {
            valueTextNow = (String) text9.getText();
        }
        return valueTextNow;
    }
}