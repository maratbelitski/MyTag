package com.example.mytag;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartActivity extends AppCompatActivity implements Methods {
    private boolean goNoGo = false;
    private final String empty = " ";

    private String temp;
    String[][] matrixWin = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "5", "6", "7", "8", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", "13", "14", "15", " ", "*"},
            {"*", "*", "*", "*", "*", "*"}
    };

    int[][] matrixSearch = new int[][]{
            {0, 0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4, 0},
            {0, 5, 6, 7, 8, 0},
            {0, 9, 10, 11, 12, 0},
            {0, 13, 14, 15, 16, 0},
            {0, 0, 0, 0, 0, 0}
    };

    Button startGame;
    Button stopGame;
    FrameLayout frameLayout1, frameLayout2, frameLayout3, frameLayout4, frameLayout5, frameLayout6,
            frameLayout7, frameLayout8, frameLayout9, frameLayout10, frameLayout11, frameLayout12,
            frameLayout13, frameLayout14, frameLayout15, frameLayout16;

    ImageView image1, image2, image3, image4, image5, image6, image7, image8,
            image9, image10, image11, image12, image13, image14, image15, image16;
    TextView text1, text2, text3, text4, text5, text6, text7, text8,
            text9, text10, text11, text12, text13, text14, text15, text16;

    public List<String> valuesTagList;
    public List<MyView> valuesViewList;
    public String[][] valuesTagArray;

    public String valueTextNow;
    public int positionNewEmpty = -1;
    public int positionNewValue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startGame = findViewById(R.id.b_start_game);
        stopGame = findViewById(R.id.b_stop_game);
        stopGame.setVisibility(View.INVISIBLE);


        valuesTagList = new ArrayList<>();
        valuesTagList.add("1");
        valuesTagList.add("2");
        valuesTagList.add("3");
        valuesTagList.add("4");
        valuesTagList.add("5");
        valuesTagList.add("6");
        valuesTagList.add("7");
        valuesTagList.add("8");
        valuesTagList.add("9");
        valuesTagList.add("10");
        valuesTagList.add("11");
        valuesTagList.add("12");
        valuesTagList.add("13");
        valuesTagList.add("14");
        valuesTagList.add("15");
        valuesTagList.add(" ");


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


    }

    public void showMove2(View view) {
        if (goNoGo) {
            valueTextNow = findValueTextNow(view);
            boolean exit = false;
            for (int i = 1; i < valuesTagArray.length - 1 && !exit; i++) {
                for (int j = 1; j < valuesTagArray[i].length - 1&& !exit; j++) {
                    if (valueTextNow.equals(valuesTagArray[i][j])) {
                        if (empty.equals(valuesTagArray[i][j - 1])
                                || empty.equals(valuesTagArray[i][j + 1])
                                || empty.equals(valuesTagArray[i - 1][j])
                                || empty.equals(valuesTagArray[i + 1][j])) {
                           // if (!valueTextNow.equals("") && !valueTextNow.equals(" ")) {
                                findPosition();
                                changePositionView(positionNewEmpty, positionNewValue);
                                exit=true;
                       // }
                    }
                }
            }



            }
        }
    }

    public void startGame(View view) {

        goNoGo = true;
        Collections.shuffle(valuesTagList);
        setAllViewMatrix(valuesViewList, valuesTagList);
        valuesTagArray = listToArray(valuesTagList);

        startGame.setVisibility(View.GONE);
        stopGame.setVisibility(View.VISIBLE);
    }

    public void finishGame(View view) {
        finish();
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

    public void findPosition() {

        boolean exit = false;
        for (int i = 1; i < matrixSearch.length - 1 && !exit; i++) {
            for (int j = 1; j < matrixSearch[i].length - 1 && !exit; j++) {

                if (valueTextNow.equals(valuesTagArray[i][j])) {

//                    if (empty.equals(valuesTagArray[i][j - 1])
//                            || empty.equals(valuesTagArray[i][j + 1])
//                            || empty.equals(valuesTagArray[i - 1][j])
//                            || empty.equals(valuesTagArray[i + 1][j])) {

                        if (empty.equals(valuesTagArray[i][j - 1])) {
                            temp = valuesTagArray[i][j - 1];
                            valuesTagArray[i][j - 1] = valueTextNow;//valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty = matrixSearch[i][j];
                            positionNewValue = matrixSearch[i][j - 1];
                            exit = true;

                        } else if (empty.equals(valuesTagArray[i][j + 1])) {
                            temp = valuesTagArray[i][j + 1];
                            valuesTagArray[i][j + 1] = valueTextNow;//valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty = matrixSearch[i][j];
                            positionNewValue = matrixSearch[i][j + 1];
                            exit = true;

                        } else if (empty.equals(valuesTagArray[i - 1][j])) {
                            temp = valuesTagArray[i - 1][j];
                            valuesTagArray[i - 1][j] = valueTextNow;// valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty = matrixSearch[i][j];
                            positionNewValue = matrixSearch[i - 1][j];
                            exit = true;

                        } else {
                            temp = valuesTagArray[i + 1][j];
                            valuesTagArray[i + 1][j] = valueTextNow;//valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty = matrixSearch[i][j];
                            positionNewValue = matrixSearch[i + 1][j];
                            exit = true;
                        }
                    }
                }
            }
        }
   // }


    public void changePositionView(int positionNewEmpty, int positionNewValue) {
        if ((positionNewValue != -1) || (positionNewEmpty != -1)) {
            valuesViewList.get(positionNewEmpty - 1).getMyImageView().setImageResource(R.drawable.logo_transparante);
            valuesViewList.get(positionNewEmpty - 1).getMyTextView().setText(R.string.numberEmpty);


            valuesViewList.get(positionNewValue - 1).getMyImageView().setImageResource(R.drawable.hex_tag);
            valuesViewList.get(positionNewValue - 1).getMyTextView().setText(valueTextNow);


        }
    }


}