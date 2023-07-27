package com.example.mytag;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
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

public class NormalActivity extends AppCompatActivity implements Methods, ButtonsAnimation {
    public static int countSteps;

    public static String valueTextNow;
    public static int positionNewEmpty = -1;
    public static int positionNewValue = -1;
    public static List<String> valuesTagList;
    public static List<MyView> valuesViewList;
    public static List<FrameLayout> valuesLayoutList;

    public static String[][] matrixWin = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "5", "6", "7", "8", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", "13", "14", "15", " ", "*"},
            {"*", "*", "*", "*", "*", "*"}};

    public static String[][] valuesTagArray = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "5", "6", "7", "8", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", "13", "14", "15", " ", "*"},
            {"*", "*", "*", "*", "*", "*"}};
    public static int[][] matrixSearch = new int[][]{
            {0, 0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4, 0},
            {0, 5, 6, 7, 8, 0},
            {0, 9, 10, 11, 12, 0},
            {0, 13, 14, 15, 16, 0},
            {0, 0, 0, 0, 0, 0}};

    Button stopGame,shuffleTags;

    ImageView image1, image2, image3, image4, image5, image6, image7, image8,
            image9, image10, image11, image12, image13, image14, image15, image16;
    TextView text1, text2, text3, text4, text5, text6, text7, text8,
            text9, text10, text11, text12, text13, text14, text15, text16,text_step2;

    FrameLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8,
            layout9, layout10, layout11, layout12, layout13, layout14, layout15, layout16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        stopGame = findViewById(R.id.b_stop_game);
        shuffleTags = findViewById(R.id.b_shuffle);
        text_step2 = findViewById(R.id.text_step2);

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
        layout10 = findViewById(R.id.id_frameLayout10);
        layout11 = findViewById(R.id.id_frameLayout11);
        layout12 = findViewById(R.id.id_frameLayout12);
        layout13 = findViewById(R.id.id_frameLayout13);
        layout14 = findViewById(R.id.id_frameLayout14);
        layout15 = findViewById(R.id.id_frameLayout15);
        layout16 = findViewById(R.id.id_frameLayout16);


        valuesLayoutList = new ArrayList<>();
        valuesLayoutList.add(layout1 = findViewById(R.id.id_frameLayout1));
        valuesLayoutList.add(layout2 = findViewById(R.id.id_frameLayout2));
        valuesLayoutList.add(layout3 = findViewById(R.id.id_frameLayout3));
        valuesLayoutList.add(layout4 = findViewById(R.id.id_frameLayout4));
        valuesLayoutList.add(layout5 = findViewById(R.id.id_frameLayout5));
        valuesLayoutList.add(layout6 = findViewById(R.id.id_frameLayout6));
        valuesLayoutList.add(layout7 = findViewById(R.id.id_frameLayout7));
        valuesLayoutList.add(layout8 = findViewById(R.id.id_frameLayout8));
        valuesLayoutList.add(layout9 = findViewById(R.id.id_frameLayout9));
        valuesLayoutList.add(layout10 = findViewById(R.id.id_frameLayout10));
        valuesLayoutList.add(layout11 = findViewById(R.id.id_frameLayout11));
        valuesLayoutList.add(layout12 = findViewById(R.id.id_frameLayout12));
        valuesLayoutList.add(layout13 = findViewById(R.id.id_frameLayout13));
        valuesLayoutList.add(layout14 = findViewById(R.id.id_frameLayout14));
        valuesLayoutList.add(layout15 = findViewById(R.id.id_frameLayout15));
        valuesLayoutList.add(layout16 = findViewById(R.id.id_frameLayout16));


        valuesViewList = new ArrayList<>();
        valuesViewList.add(new MyView(text1 = findViewById(R.id.id_text1), image1 = findViewById(R.id.id_image1)));
        valuesViewList.add(new MyView(text2 = findViewById(R.id.id_text2), image2 = findViewById(R.id.id_image2)));
        valuesViewList.add(new MyView(text3 = findViewById(R.id.id_text3), image3 = findViewById(R.id.id_image3)));
        valuesViewList.add(new MyView(text4 = findViewById(R.id.id_text4), image4 = findViewById(R.id.id_image4)));
        valuesViewList.add(new MyView(text5 = findViewById(R.id.id_text5), image5 = findViewById(R.id.id_image5)));
        valuesViewList.add(new MyView(text6 = findViewById(R.id.id_text6), image6 = findViewById(R.id.id_image6)));
        valuesViewList.add(new MyView(text7 = findViewById(R.id.id_text7), image7 = findViewById(R.id.id_image7)));
        valuesViewList.add(new MyView(text8 = findViewById(R.id.id_text8), image8 = findViewById(R.id.id_image8)));
        valuesViewList.add(new MyView(text9 = findViewById(R.id.id_text9), image9 = findViewById(R.id.id_image9)));
        valuesViewList.add(new MyView(text10 = findViewById(R.id.id_text10), image10 = findViewById(R.id.id_image10)));
        valuesViewList.add(new MyView(text11 = findViewById(R.id.id_text11), image11 = findViewById(R.id.id_image11)));
        valuesViewList.add(new MyView(text12 = findViewById(R.id.id_text12), image12 = findViewById(R.id.id_image12)));
        valuesViewList.add(new MyView(text13 = findViewById(R.id.id_text13), image13 = findViewById(R.id.id_image13)));
        valuesViewList.add(new MyView(text14 = findViewById(R.id.id_text14), image14 = findViewById(R.id.id_image14)));
        valuesViewList.add(new MyView(text15 = findViewById(R.id.id_text15), image15 = findViewById(R.id.id_image15)));
        valuesViewList.add(new MyView(text16 = findViewById(R.id.id_text16), image16 = findViewById(R.id.id_image16)));


        countSteps=0;
        valuesTagArray=shuffleTag(valuesTagArray);

        valuesTagList = arrayToList(valuesTagArray);

        shuffleAnimation(valuesLayoutList);

        setAllViewMatrix(valuesViewList, valuesTagList);


    }

    public void showMove2(View view) {
        valueTextNow = findValueTextNow(view);

        ClickOnTag();
        text_step2.setText(String.valueOf(countSteps));

        if(Arrays.deepEquals(valuesTagArray,matrixWin)){
            Intent intent = new Intent(this, WinnerActivity.class);
            intent.putExtra(WinnerActivity.COUNT, countSteps);
            startActivity(intent);
        }
    }

    public void shuffleTags(View view) {

       shuffleAnimation(valuesLayoutList);

        valuesTagArray = shuffleTag(valuesTagArray);
        valuesTagList = arrayToList(valuesTagArray);

        setAllViewMatrix(valuesViewList, valuesTagList);
        countSteps=0;
        text_step2.setText(String.valueOf(countSteps));
    }
    public void finishGame(View view) {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
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
        } else if (view1 == image10) {
            valueTextNow = (String) text10.getText();
        } else if (view1 == image11) {
            valueTextNow = (String) text11.getText();
        } else if (view1 == image12) {
            valueTextNow = (String) text12.getText();
        } else if (view1 == image13) {
            valueTextNow = (String) text13.getText();
        } else if (view1 == image14) {
            valueTextNow = (String) text14.getText();
        } else if (view1 == image15) {
            valueTextNow = (String) text15.getText();
        } else if (view1 == image16) {
            valueTextNow = (String) text16.getText();
        }
        return valueTextNow;
    }
}