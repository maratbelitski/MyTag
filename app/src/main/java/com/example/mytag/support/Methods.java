package com.example.mytag.support;
import com.example.mytag.EasyActivity;
import com.example.mytag.NormalActivity;
import com.example.mytag.R;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 22.07.2023
 */
public interface Methods {

    default List<String> arrayToList(String[][] array) {
        List<String> list = new ArrayList<>();
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


    default void changePositionView(String string, int positionNewEmpty, int positionNewValue) {

        List<MyView> listView;
        String valueTextNow;
        int countSteps;

        if (string.equals("easy")) {
            listView = EasyActivity.viewList;
            valueTextNow = EasyActivity.valueTextNow;
            countSteps = EasyActivity.countSteps;
        } else {
            listView = NormalActivity.viewList;
            valueTextNow = NormalActivity.valueTextNow;
            countSteps = NormalActivity.countSteps;
        }


        if ((positionNewValue != -1) || (positionNewEmpty != -1)) {
            listView.get(positionNewEmpty - 1).getMyImageView().setImageResource(R.drawable.logo_transparante);
            listView.get(positionNewEmpty - 1).getMyTextView().setText(R.string.numberEmpty);

            listView.get(positionNewValue - 1).getMyImageView().setImageResource(R.drawable.logo_hex);
            listView.get(positionNewValue - 1).getMyTextView().setText(valueTextNow);

            countSteps++;

            if (string.equals("easy")) {
                EasyActivity.countSteps = countSteps;
            } else {
                NormalActivity.countSteps = countSteps;
            }

        }
    }

    default void findPosition(String string) {
        String[][] array;
        int[][] arrayMatrix;
        String valueTextNow;
        int positionNewEmpty;
        int positionNewValue;


        if (string.equals("easy")) {
            valueTextNow = EasyActivity.valueTextNow;
            array = EasyActivity.valuesTagArrayEasy;
            arrayMatrix = EasyActivity.matrixSearch;
            positionNewValue = EasyActivity.positionNewValue;
            positionNewEmpty = EasyActivity.positionNewEmpty;
        } else {
            valueTextNow = NormalActivity.valueTextNow;
            array = NormalActivity.valuesTagArrayNormal;
            arrayMatrix = NormalActivity.matrixSearch;
            positionNewValue = NormalActivity.positionNewValue;
            positionNewEmpty = NormalActivity.positionNewEmpty;
        }

        String temp;
        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < arrayMatrix.length - 1 && !exit; i++) {
            for (int j = 1; j < arrayMatrix[i].length - 1 && !exit; j++) {

                if (valueTextNow.equals(array[i][j])) {

                    if (empty.equals(array[i][j - 1])) {
                        temp = array[i][j - 1];
                        array[i][j - 1] = valueTextNow;
                        array[i][j] = temp;

                        positionNewEmpty = arrayMatrix[i][j];
                        positionNewValue = arrayMatrix[i][j - 1];
                        exit = true;

                    } else if (empty.equals(array[i][j + 1])) {
                        temp = array[i][j + 1];
                        array[i][j + 1] = valueTextNow;
                        array[i][j] = temp;

                        positionNewEmpty = arrayMatrix[i][j];
                        positionNewValue = arrayMatrix[i][j + 1];
                        exit = true;

                    } else if (empty.equals(array[i - 1][j])) {
                        temp = array[i - 1][j];
                        array[i - 1][j] = valueTextNow;
                        array[i][j] = temp;

                        positionNewEmpty = arrayMatrix[i][j];
                        positionNewValue = arrayMatrix[i - 1][j];
                        exit = true;

                    } else {
                        temp = array[i + 1][j];
                        array[i + 1][j] = valueTextNow;
                        array[i][j] = temp;

                        positionNewEmpty = arrayMatrix[i][j];
                        positionNewValue = arrayMatrix[i + 1][j];
                        exit = true;
                    }
                }
            }
        }
        if (string.equals("easy")) {

            EasyActivity.positionNewValue = positionNewValue;
            EasyActivity.positionNewEmpty = positionNewEmpty;
        } else {

            NormalActivity.positionNewValue = positionNewValue;
            NormalActivity.positionNewEmpty = positionNewEmpty;
        }
    }


    default void ClickOnTag(String string) {
        String[][] array;
        int positionNewEmpty;
        int positionNewValue;
        String valueTextNow;

        if (string.equals("easy")) {
            array = EasyActivity.valuesTagArrayEasy;
            valueTextNow = EasyActivity.valueTextNow;
        } else {
            array = NormalActivity.valuesTagArrayNormal;
            valueTextNow = NormalActivity.valueTextNow;
        }

        boolean exit = false;
        String empty = " ";

        for (int i = 1; i < array.length - 1 && !exit; i++) {
            for (int j = 1; j < array[i].length - 1 && !exit; j++) {

                if (valueTextNow.equals(array[i][j])) {
                    if (empty.equals(array[i][j - 1])
                            || empty.equals(array[i][j + 1])
                            || empty.equals(array[i - 1][j])
                            || empty.equals(array[i + 1][j])) {

                        findPosition(string);
                        if (string.equals("easy")) {
                            positionNewValue = EasyActivity.positionNewValue;
                            positionNewEmpty = EasyActivity.positionNewEmpty;
                        } else {
                            positionNewValue = NormalActivity.positionNewValue;
                            positionNewEmpty = NormalActivity.positionNewEmpty;
                        }

                        changePositionView(string, positionNewEmpty, positionNewValue);
                        exit = true;
                    }
                }
            }
        }
    }

    default String[][] shuffleTag(String[][] array) {
        //метод правильной тасовки
        String empty = " ";
        String temp;
        int count = 200;

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

    default int changeBackground(String valueFon){
        int result=0;

        switch (valueFon) {
            case  "fonStart" -> result = R.drawable.fon_start;
            case  "fonStart2" -> result = R.drawable.fon_start2;
            case  "fonStart3" -> result = R.drawable.fon_start3;
            case  "fonStart4" -> result = R.color.material_100;
            case  "fonStart5" -> result = R.color.black;
        }
        return result;
    }
}
