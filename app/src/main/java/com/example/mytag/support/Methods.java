package com.example.mytag.support;
import static com.example.mytag.NormalActivity.matrixSearch;
import static com.example.mytag.NormalActivity.positionNewEmpty;
import static com.example.mytag.NormalActivity.positionNewValue;
import static com.example.mytag.NormalActivity.valueTextNow;
import static com.example.mytag.NormalActivity.countSteps;
import static com.example.mytag.NormalActivity.valuesTagArray;
import static com.example.mytag.NormalActivity.valuesViewList;

import static com.example.mytag.EasyActivity.matrixSearchEasy;
import static com.example.mytag.EasyActivity.positionNewEmptyEasy;
import static com.example.mytag.EasyActivity.positionNewValueEasy;
import static com.example.mytag.EasyActivity.valueTextNowEasy;
import static com.example.mytag.EasyActivity.countStepsEasy;
import static com.example.mytag.EasyActivity.valuesTagArrayEasy;
import static com.example.mytag.EasyActivity.valuesViewListEasy;


import com.example.mytag.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 22.07.2023
 */
public interface Methods {

    default List<String> arrayToList(String[][] array) {
       List<String> list= new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 || i == array.length - 1 || j == 0 || j == array.length - 1) {
                    array[i][j] = "*";
                    continue;
                }
                list.add(array[i][j]);
            }
        }
        return list;
    }


    default void setAllViewMatrix(List<MyView> listView, List<String> list) {
        for (int i = 0; i < listView.size(); i++) {
            listView.get(i).getMyTextView().setText(list.get(i));
            if (list.get(i).equals(" ")) {
                listView.get(i).getMyImageView().setImageResource(R.drawable.logo_transparante);
            } else {
                listView.get(i).getMyImageView().setImageResource(R.drawable.logo_hex);
            }
        }
    }

    default void setAllViewMatrixEasy(List<MyView> listView, List<String> list) {
        for (int i = 0; i < listView.size(); i++) {
            listView.get(i).getMyTextView().setText(list.get(i));
            if (list.get(i).equals(" ")) {
                listView.get(i).getMyImageView().setImageResource(R.drawable.logo_transparante);
            } else {
                listView.get(i).getMyImageView().setImageResource(R.drawable.logo_hex);
            }
        }
    }

    default void changePositionView(int positionNewEmpty, int positionNewValue) {
        if ((positionNewValue != -1) || (positionNewEmpty != -1)) {
            valuesViewList.get(positionNewEmpty - 1).getMyImageView().setImageResource(R.drawable.logo_transparante);
            valuesViewList.get(positionNewEmpty - 1).getMyTextView().setText(R.string.numberEmpty);

            valuesViewList.get(positionNewValue - 1).getMyImageView().setImageResource(R.drawable.logo_hex);
            valuesViewList.get(positionNewValue - 1).getMyTextView().setText(valueTextNow);

            countSteps++;
        }
    }

    default void changePositionViewEasy(int positionNewEmptyEasy, int positionNewValueEasy) {
        if ((positionNewValueEasy != -1) || (positionNewEmptyEasy != -1)) {
            valuesViewListEasy.get(positionNewEmptyEasy - 1).getMyImageView().setImageResource(R.drawable.logo_transparante);
            valuesViewListEasy.get(positionNewEmptyEasy - 1).getMyTextView().setText(R.string.numberEmpty);

            valuesViewListEasy.get(positionNewValueEasy - 1).getMyImageView().setImageResource(R.drawable.logo_hex);
            valuesViewListEasy.get(positionNewValueEasy - 1).getMyTextView().setText(valueTextNowEasy);

            countStepsEasy++;
        }
    }

    default void findPosition() {
        String temp;
        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < matrixSearch.length - 1 && !exit; i++) {
            for (int j = 1; j < matrixSearch[i].length - 1 && !exit; j++) {

                if (valueTextNow.equals(valuesTagArray[i][j])) {

                    if (empty.equals(valuesTagArray[i][j - 1])) {
                        temp = valuesTagArray[i][j - 1];
                        valuesTagArray[i][j - 1] = valueTextNow;
                        valuesTagArray[i][j] = temp;

                        positionNewEmpty = matrixSearch[i][j];
                        positionNewValue = matrixSearch[i][j - 1];
                        exit = true;

                    } else if (empty.equals(valuesTagArray[i][j + 1])) {
                        temp = valuesTagArray[i][j + 1];
                        valuesTagArray[i][j + 1] = valueTextNow;
                        valuesTagArray[i][j] = temp;

                        positionNewEmpty = matrixSearch[i][j];
                        positionNewValue = matrixSearch[i][j + 1];
                        exit = true;

                    } else if (empty.equals(valuesTagArray[i - 1][j])) {
                        temp = valuesTagArray[i - 1][j];
                        valuesTagArray[i - 1][j] = valueTextNow;
                        valuesTagArray[i][j] = temp;

                        positionNewEmpty = matrixSearch[i][j];
                        positionNewValue = matrixSearch[i - 1][j];
                        exit = true;

                    } else {
                        temp = valuesTagArray[i + 1][j];
                        valuesTagArray[i + 1][j] = valueTextNow;
                        valuesTagArray[i][j] = temp;

                        positionNewEmpty = matrixSearch[i][j];
                        positionNewValue = matrixSearch[i + 1][j];
                        exit = true;
                    }
                }
            }
        }
    }

    default void findPositionEasy() {
        String temp;
        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < matrixSearchEasy.length - 1 && !exit; i++) {
            for (int j = 1; j < matrixSearchEasy[i].length - 1 && !exit; j++) {

                if (valueTextNowEasy.equals(valuesTagArrayEasy[i][j])) {

                    if (empty.equals(valuesTagArrayEasy[i][j - 1])) {
                        temp = valuesTagArrayEasy[i][j - 1];
                        valuesTagArrayEasy[i][j - 1] = valueTextNowEasy;
                        valuesTagArrayEasy[i][j] = temp;

                        positionNewEmptyEasy = matrixSearchEasy[i][j];
                        positionNewValueEasy = matrixSearchEasy[i][j - 1];
                        exit = true;

                    } else if (empty.equals(valuesTagArrayEasy[i][j + 1])) {
                        temp = valuesTagArrayEasy[i][j + 1];
                        valuesTagArrayEasy[i][j + 1] = valueTextNowEasy;
                        valuesTagArrayEasy[i][j] = temp;

                        positionNewEmptyEasy = matrixSearchEasy[i][j];
                        positionNewValueEasy = matrixSearchEasy[i][j + 1];
                        exit = true;

                    } else if (empty.equals(valuesTagArrayEasy[i - 1][j])) {
                        temp = valuesTagArrayEasy[i - 1][j];
                        valuesTagArrayEasy[i - 1][j] = valueTextNowEasy;
                        valuesTagArrayEasy[i][j] = temp;

                        positionNewEmptyEasy = matrixSearchEasy[i][j];
                        positionNewValueEasy = matrixSearchEasy[i - 1][j];
                        exit = true;

                    } else {
                        temp = valuesTagArrayEasy[i + 1][j];
                        valuesTagArrayEasy[i + 1][j] = valueTextNowEasy;
                        valuesTagArrayEasy[i][j] = temp;

                        positionNewEmptyEasy = matrixSearchEasy[i][j];
                        positionNewValueEasy = matrixSearchEasy[i + 1][j];
                        exit = true;
                    }
                }
            }
        }
    }

    default void ClickOnTag() {
        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < valuesTagArray.length - 1 && !exit; i++) {
            for (int j = 1; j < valuesTagArray[i].length - 1 && !exit; j++) {

                if (valueTextNow.equals(valuesTagArray[i][j])) {
                    if (empty.equals(valuesTagArray[i][j - 1])
                            || empty.equals(valuesTagArray[i][j + 1])
                            || empty.equals(valuesTagArray[i - 1][j])
                            || empty.equals(valuesTagArray[i + 1][j])) {

                        findPosition();
                        changePositionView(positionNewEmpty, positionNewValue);
                        exit = true;
                    }
                }
            }
        }
    }

    default void ClickOnTagEasy() {
        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < valuesTagArrayEasy.length - 1 && !exit; i++) {
            for (int j = 1; j < valuesTagArrayEasy[i].length - 1 && !exit; j++) {

                if (valueTextNowEasy.equals(valuesTagArrayEasy[i][j])) {
                    if (empty.equals(valuesTagArrayEasy[i][j - 1])
                            || empty.equals(valuesTagArrayEasy[i][j + 1])
                            || empty.equals(valuesTagArrayEasy[i - 1][j])
                            || empty.equals(valuesTagArrayEasy[i + 1][j])) {

                        findPositionEasy();
                        changePositionViewEasy(positionNewEmptyEasy, positionNewValueEasy);
                        exit = true;
                    }
                }
            }
        }
    }

    default  String[][] shuffleTag(String[][] array) {
        //метод правильной тасовки
        String empty = " ";
        String temp;
        int count = 100;

        while (count != 0) {
            for (int i = 1; i < array.length - 1; i++) {
                for (int j = 1; j < array[i].length - 1; j++) {
                    if (empty.equals(array[i][j])) {
                        int random = (int) (Math.random() * 4 + 1);
                        if (!array[i][j - 1].equals("*") && random == 1) {
                            temp = array[i][j - 1];
                            array[i][j - 1] = array[i][j];
                            array[i][j] = temp;

                        } else if (!array[i][j + 1].equals("*") && random == 2) {
                            temp = array[i][j + 1];
                            array[i][j + 1] = array[i][j];
                            array[i][j] = temp;

                        } else if (!array[i - 1][j].equals("*") && random == 3) {
                            temp = array[i - 1][j];
                            array[i - 1][j] = array[i][j];
                            array[i][j] = temp;

                        } else if (!array[i + 1][j].equals("*") && random == 4) {
                            temp = array[i + 1][j];
                            array[i + 1][j] = array[i][j];
                            array[i][j] = temp;
                        }
                    }
                }
            }
            count--;
        }
        return array;
    }
}
