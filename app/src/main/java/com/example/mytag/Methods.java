package com.example.mytag;
import static com.example.mytag.NormalActivity.matrixSearch;
import static com.example.mytag.NormalActivity.valueTextNow;
import static com.example.mytag.NormalActivity.valuesTagArray;
import static com.example.mytag.NormalActivity.valuesViewList;
import static com.example.mytag.NormalActivity.positionNewEmpty;
import static com.example.mytag.NormalActivity.positionNewValue;
import static com.example.mytag.NormalActivity.countSteps;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 22.07.2023
 */
public interface Methods {
    default String[][] listToArray(List<String> list) {
    int count=0;
        String[][] matrix = new String[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix.length - 1) {
                    matrix[i][j] = "*";
                }
                if (i > 0 && i < matrix.length - 1 && j > 0 && j < matrix.length - 1) {
                    matrix[i][j] =list.get(count);
                    count++;
                }
            }
        }
        return matrix;
    }


    default void setAllViewMatrix(List<MyView> listView, List<String> list) {
        for (int i = 0; i < 16; i++) {
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
}
