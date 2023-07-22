package com.example.mytag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Belitski Marat
 * @date 22.07.2023
 */
public interface Methods {
    default String[][] listToArray(List<String> list) {

        String[][] matrix = new String[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == 0 || i == matrix.length - 1 || j == 0 || j == matrix.length - 1) {
                    matrix[i][j] = "*";
                }
                if (i > 0 && i < matrix.length - 1 && j > 0 && j < matrix.length - 1) {
                    for (String item : list) {
                        matrix[i][j] = item;
                        list.remove(item);
                        break;
                    }
                }
            }
        }
        return matrix;
    }

//
//        String[][] array = new String[4][4];
//        int count = 0;
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                array[i][j]=list.get(count);
//                count++;
//            }
//        }
//        return array;
//      }

    default void setAllViewMatrix(List<MyView> listView, List<String> list) {
        for (int i = 0; i < 16; i++) {
            listView.get(i).getMyTextView().setText(list.get(i));
            if(list.get(i).equals(" ")) {
                listView.get(i).getMyImageView().setImageResource(R.drawable.logo_transparante);
            }else{
                listView.get(i).getMyImageView().setImageResource(R.drawable.hex_tag);
            }
        }
    }
}
