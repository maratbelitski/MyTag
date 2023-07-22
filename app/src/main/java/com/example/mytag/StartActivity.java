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
    //массив победы
//    Tag[][] matrixWin = new Tag[][]{
//            {new Tag(R.string.number1, R.drawable.hex_tag), new Tag(R.string.number2, R.drawable.hex_tag), new Tag(R.string.number3, R.drawable.hex_tag), new Tag(R.string.number4, R.drawable.hex_tag)},
//            {new Tag(R.string.number5, R.drawable.hex_tag), new Tag(R.string.number6, R.drawable.hex_tag), new Tag(R.string.number7, R.drawable.hex_tag), new Tag(R.string.number8, R.drawable.hex_tag)},
//            {new Tag(R.string.number9, R.drawable.hex_tag), new Tag(R.string.number10, R.drawable.hex_tag), new Tag(R.string.number11, R.drawable.hex_tag), new Tag(R.string.number12, R.drawable.hex_tag)},
//            {new Tag(R.string.number13, R.drawable.hex_tag), new Tag(R.string.number14, R.drawable.hex_tag), new Tag(R.string.number15, R.drawable.hex_tag), new Tag(R.string.numberEmpty, R.drawable.logo_nut)}
//    };

//    Tag[][] matrixWin = new Tag[][]{
//            {new Tag("1", R.drawable.hex_tag), new Tag("2", R.drawable.hex_tag), new Tag("3", R.drawable.hex_tag), new Tag("4", R.drawable.hex_tag)},
//            {new Tag("5", R.drawable.hex_tag), new Tag("6", R.drawable.hex_tag), new Tag("7", R.drawable.hex_tag), new Tag("8", R.drawable.hex_tag)},
//            {new Tag("9", R.drawable.hex_tag), new Tag("10", R.drawable.hex_tag), new Tag("11", R.drawable.hex_tag), new Tag("12", R.drawable.hex_tag)},
//            {new Tag("13", R.drawable.hex_tag), new Tag("14", R.drawable.hex_tag), new Tag("15", R.drawable.hex_tag), new Tag(" ", R.drawable.logo_nut)}
//    };

    String[][] matrixWin = new String[][]{
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", " "}
    };

    int[][] matrixSearch = new int[][]{
            {0,0, 0, 0, 0,0},
            {0,1, 2, 3, 4,0},
            {0,5, 6, 7, 8,0},
            {0,9, 10, 11, 12,0},
            {0,13, 14, 15, 16,0},
            {0,0, 0, 0, 0,0}
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
    public int positionNewEmpty=-1;
    public int positionNewValue=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startGame = findViewById(R.id.b_start_game);
        stopGame = findViewById(R.id.b_stop_game);
        stopGame.setVisibility(View.INVISIBLE);

//        frameLayout1 = findViewById(R.id.id_frameLayout1);
//        frameLayout2 = findViewById(R.id.id_frameLayout2);
//        frameLayout3 = findViewById(R.id.id_frameLayout3);
//        frameLayout4 = findViewById(R.id.id_frameLayout4);
//        frameLayout5 = findViewById(R.id.id_frameLayout5);
//        frameLayout6 = findViewById(R.id.id_frameLayout6);
//        frameLayout7 = findViewById(R.id.id_frameLayout7);
//        frameLayout8 = findViewById(R.id.id_frameLayout8);
//        frameLayout9 = findViewById(R.id.id_frameLayout9);
//        frameLayout10 = findViewById(R.id.id_frameLayout10);
//        frameLayout11 = findViewById(R.id.id_frameLayout11);
//        frameLayout12 = findViewById(R.id.id_frameLayout12);
//        frameLayout13 = findViewById(R.id.id_frameLayout13);
//        frameLayout14 = findViewById(R.id.id_frameLayout14);
//        frameLayout15 = findViewById(R.id.id_frameLayout15);
//        frameLayout16 = findViewById(R.id.id_frameLayout16);

//        valuesTagList = new ArrayList<>();
//        valuesTagList.add(new Tag(R.string.number1, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number2, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number3, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number4, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number5, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number6, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number7, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number8, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number9, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number10, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number11, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number12, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number13, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number14, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.number15, R.drawable.hex_tag));
//        valuesTagList.add(new Tag(R.string.numberEmpty, R.drawable.logo_transparante));


//        valuesTagList = new ArrayList<>();
//        valuesTagList.add(new Tag("1", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("2", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("3", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("4", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("5", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("6", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("7", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("8", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("9", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("10", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("11", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("12", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("13", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("14", R.drawable.hex_tag));
//        valuesTagList.add(new Tag("15", R.drawable.hex_tag));
//        valuesTagList.add(new Tag(" ", R.drawable.logo_transparante));


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


//        textViewsList = new ArrayList<>();
//        textViewsList.add(text1 = findViewById(R.id.id_text1));
//        textViewsList.add(text2 = findViewById(R.id.id_text2));
//        textViewsList.add(text3 = findViewById(R.id.id_text3));
//        textViewsList.add(text4 = findViewById(R.id.id_text4));
//        textViewsList.add(text5 = findViewById(R.id.id_text5));
//        textViewsList.add(text6 = findViewById(R.id.id_text6));
//        textViewsList.add(text7 = findViewById(R.id.id_text7));
//        textViewsList.add(text8 = findViewById(R.id.id_text8));
//        textViewsList.add(text9 = findViewById(R.id.id_text9));
//        textViewsList.add(text10 = findViewById(R.id.id_text10));
//        textViewsList.add(text11 = findViewById(R.id.id_text11));
//        textViewsList.add(text12 = findViewById(R.id.id_text12));
//        textViewsList.add(text13 = findViewById(R.id.id_text13));
//        textViewsList.add(text14 = findViewById(R.id.id_text14));
//        textViewsList.add(text15 = findViewById(R.id.id_text15));
//        textViewsList.add(text16 = findViewById(R.id.id_text16));
//
//        imageViewsList = new ArrayList<>();
//        imageViewsList.add(image1 = findViewById(R.id.id_image1));
//        imageViewsList.add(image2 = findViewById(R.id.id_image2));
//        imageViewsList.add(image3 = findViewById(R.id.id_image3));
//        imageViewsList.add(image4 = findViewById(R.id.id_image4));
//        imageViewsList.add(image5 = findViewById(R.id.id_image5));
//        imageViewsList.add(image6 = findViewById(R.id.id_image6));
//        imageViewsList.add(image7 = findViewById(R.id.id_image7));
//        imageViewsList.add(image8 = findViewById(R.id.id_image8));
//        imageViewsList.add(image9 = findViewById(R.id.id_image9));
//        imageViewsList.add(image10 = findViewById(R.id.id_image10));
//        imageViewsList.add(image11 = findViewById(R.id.id_image11));
//        imageViewsList.add(image12 = findViewById(R.id.id_image12));
//        imageViewsList.add(image13 = findViewById(R.id.id_image13));
//        imageViewsList.add(image14 = findViewById(R.id.id_image14));
//        imageViewsList.add(image15 = findViewById(R.id.id_image15));
//        imageViewsList.add(image16 = findViewById(R.id.id_image16));

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
            findPosition();
            changePositionView(positionNewEmpty, positionNewValue);
        }
    }

    public void startGame(View view) {

        goNoGo = true;
       // Collections.shuffle(valuesTagList);
        setAllViewMatrix(valuesViewList, valuesTagList);
        valuesTagArray = listToArray(valuesTagList);

        startGame.setVisibility(View.GONE);
        stopGame.setVisibility(View.VISIBLE);
    }

    public void finishGame(View view) {
        finish();
    }


//    public void doGame(String[][] valuesTagArray, View view) {
//        ImageView view1 = findViewById(view.getId());
//
//        //String valueTextNow = (String) view1.getText();
//        boolean exit = false;
//        String empty = " ";
//        String temp;
//
//
//        //   while (!Arrays.deepEquals(valuesTagArray, matrixWin)) {
//
//        for (int i = 0; i < matrixSearch.length && i < valuesTagArray.length && !exit; i++) {
//            for (int j = 0; j < matrixSearch[i].length && i < valuesTagArray[i].length && !exit; j++) {
//                if (valueTextNow.equals(valuesTagArray[i][j])) {
//
//
//                    if (empty.equals(valuesTagArray[i][j - 1])
//                            || empty.equals(valuesTagArray[i][j + 1])
//                            || empty.equals(valuesTagArray[i - 1][j])
//                            || empty.equals(valuesTagArray[i + 1][j])) {
//
//                        if (empty.equals(valuesTagArray[i][j - 1])) {
//                            temp = valueTextNow;
//                            view1.setText(valuesTagArray[i][j - 1]);
//                            valuesTagArray[i][j - 1] = temp;
//
//                            valuesViewList.get(matrixSearch[i][j]).getMyImageView().setImageResource(R.drawable.logo_transparante);
//                            valuesViewList.get(matrixSearch[i][j]).getMyTextView().setText(R.string.numberEmpty);
//                            valuesViewList.get(matrixSearch[i][j - 1]).getMyImageView().setImageResource(R.drawable.hex_tag);
//                            valuesViewList.get(matrixSearch[i][j - 1]).getMyTextView().setText(valueTextNow);
//
//
//                            exit = true;
//                        } else if (empty.equals(valuesTagArray[i][j + 1])) {
//                            temp = valueTextNow;
//                            view1.setText(valuesTagArray[i][j + 1]);
//                            valuesTagArray[i][j + 1] = temp;
//                            valuesViewList.get(matrixSearch[i][j]).getMyImageView().setImageResource(R.drawable.logo_transparante);
//                            valuesViewList.get(matrixSearch[i][j]).getMyTextView().setText(R.string.numberEmpty);
//                            valuesViewList.get(matrixSearch[i][j + 1]).getMyImageView().setImageResource(R.drawable.hex_tag);
//                            valuesViewList.get(matrixSearch[i][j + 1]).getMyTextView().setText(valueTextNow);
//
//                            exit = true;
//
//                        } else if (empty.equals(valuesTagArray[i - 1][j])) {
//
//                            temp = valueTextNow;
//                            view1.setText(valuesTagArray[i - 1][j]);
//                            valuesTagArray[i - 1][j] = temp;
//                            valuesViewList.get(matrixSearch[i][j]).getMyImageView().setImageResource(R.drawable.logo_transparante);
//                            valuesViewList.get(matrixSearch[i][j]).getMyTextView().setText(R.string.numberEmpty);
//                            valuesViewList.get(matrixSearch[i - 1][j]).getMyImageView().setImageResource(R.drawable.hex_tag);
//                            valuesViewList.get(matrixSearch[i - 1][j]).getMyTextView().setText(valueTextNow);
//
//                            exit = true;
//                        } else {
//                            temp = valueTextNow;
//                            view1.setText(valuesTagArray[i + 1][j]);
//                            valuesTagArray[i + 1][j] = temp;
//                            valuesViewList.get(matrixSearch[i][j]).getMyImageView().setImageResource(R.drawable.logo_transparante);
//                            valuesViewList.get(matrixSearch[i][j]).getMyTextView().setText(R.string.numberEmpty);
//                            valuesViewList.get(matrixSearch[i + 1][j]).getMyImageView().setImageResource(R.drawable.hex_tag);
//                            valuesViewList.get(matrixSearch[i + 1][j]).getMyTextView().setText(valueTextNow);
//
//                            exit = true;
//
//
//                        }
//                    }
//                }
//            }
//        }
//    }


    public String findValueTextNow(View view) {
        ImageView view1 = findViewById(view.getId());

        if (view1 == image1) {
            valueTextNow = "1";
        } else if (view1 == image2) {
            valueTextNow = "2";
        } else if (view1 == image3) {
            valueTextNow = "3";
        } else if (view1 == image4) {
            valueTextNow = "4";
        } else if (view1 == image5) {
            valueTextNow = "5";
        } else if (view1 == image6) {
            valueTextNow = "6";
        } else if (view1 == image7) {
            valueTextNow = "7";
        } else if (view1 == image8) {
            valueTextNow = "8";
        } else if (view1 == image9) {
            valueTextNow = "9";
        } else if (view1 == image10) {
            valueTextNow = "10";
        } else if (view1 == image11) {
            valueTextNow = "11";
        } else if (view1 == image12) {
            valueTextNow = "12";
        } else if (view1 == image13) {
            valueTextNow = "13";
        } else if (view1 == image14) {
            valueTextNow = "14";
        } else if (view1 == image15) {
            valueTextNow = "15";
        }else if (view1 == image16) {
            valueTextNow = " ";
        }
        return valueTextNow;
    }

    public void findPosition(){
        boolean exit = false;
        String empty = " ";
        String temp;

        for (int i = 1; i < matrixSearch.length-1 && !exit; i++) {
            for (int j = 1; j < matrixSearch[i].length-1 && !exit; j++) {


                if (valueTextNow.equals(valuesTagArray[i][j])) {

                    if (empty.equals(valuesTagArray[i][j - 1])
                            || empty.equals(valuesTagArray[i][j + 1])
                            || empty.equals(valuesTagArray[i - 1][j])
                            || empty.equals(valuesTagArray[i + 1][j])) {

                        if (empty.equals(valuesTagArray[i][j - 1])) {
                            temp = valuesTagArray[i][j - 1];
                            valuesTagArray[i][j - 1]=valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty=matrixSearch[i][j];
                            positionNewValue=matrixSearch[i][j - 1];
                            exit = true;

                        } else if (empty.equals(valuesTagArray[i][j + 1])) {
                            temp = valuesTagArray[i][j + 1];
                            valuesTagArray[i][j + 1]=valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty=matrixSearch[i][j];
                            positionNewValue=matrixSearch[i][j + 1];
                            exit = true;

                        } else if (empty.equals(valuesTagArray[i - 1][j])) {
                            temp = valuesTagArray[i-1][j];
                            valuesTagArray[i-1][j]=valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty=matrixSearch[i][j];
                            positionNewValue=matrixSearch[i-1][j];
                            exit = true;
                        } else {
                            temp = valuesTagArray[i+1][j];
                            valuesTagArray[i+1][j]=valuesTagArray[i][j];
                            valuesTagArray[i][j] = temp;

                            positionNewEmpty=matrixSearch[i][j];
                            positionNewValue=matrixSearch[i+1][j];
                            exit = true;

                        }
                    }
                }
            }
        }
    }


    public void changePositionView(int positionNewEmpty,int positionNewValue ){
        if((positionNewValue !=-1) ||(positionNewEmpty!=-1)) {
            valuesViewList.get(positionNewEmpty).getMyImageView().setImageResource(R.drawable.logo_transparante);
            valuesViewList.get(positionNewEmpty).getMyTextView().setText(R.string.numberEmpty);
            valuesViewList.get(positionNewValue).getMyImageView().setImageResource(R.drawable.hex_tag);
            valuesViewList.get(positionNewValue).getMyTextView().setText(valueTextNow);
            Toast.makeText(this, positionNewEmpty+" пустота"+positionNewValue+" значение", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, positionNewEmpty+" пустота"+positionNewValue+" значение", Toast.LENGTH_SHORT).show();
        }

    }


}