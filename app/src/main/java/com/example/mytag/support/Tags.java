package com.example.mytag.support;

/**
 * @author Belitski Marat
 * @date 28.07.2023
 */
public class Tags {
    public static String[][] matrixWinEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "4", "5", "6", "*"},
            {"*", "7", "8", " ", "*"},
            {"*", "*", "*", "*", "*"}};

    public static String[][] matrixWinNormal = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "5", "6", "7", "8", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", "13", "14", "15", " ", "*"},
            {"*", "*", "*", "*", "*", "*"}};

    public static String[][] matrixWinSnakeEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "6", "5", "4", "*"},
            {"*", "7", "8", " ", "*"},
            {"*", "*", "*", "*", "*"}};

    public static String[][] matrixWinSnakeNormal = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "8", "7", "6", "5", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", " ", "15", "14", "13", "*"},
            {"*", "*", "*", "*", "*", "*"}};



   private static final String[][] valuesTagArrayEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "4", "5", "6", "*"},
            {"*", "7", "8", " ", "*"},
            {"*", "*", "*", "*", "*"}};
    private static final String[][] valuesTagArrayNormal = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "5", "6", "7", "8", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", "13", "14", "15", " ", "*"},
            {"*", "*", "*", "*", "*", "*"}};
    public static String[][] valuesTagArraySnakeEasy = new String[][]{
            {"*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "*"},
            {"*", "6", "5", "4", "*"},
            {"*", "7", "8", " ", "*"},
            {"*", "*", "*", "*", "*"}};
    public static String[][] valuesTagArraySnakeNormal = new String[][]{
            {"*", "*", "*", "*", "*", "*"},
            {"*", "1", "2", "3", "4", "*"},
            {"*", "8", "7", "6", "5", "*"},
            {"*", "9", "10", "11", "12", "*"},
            {"*", " ", "15", "14", "13", "*"},
            {"*", "*", "*", "*", "*", "*"}};

    public static int[][] matrixSearchEasy = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 2, 3, 0},
            {0, 4, 5, 6, 0},
            {0, 7, 8, 9, 0},
            {0, 0, 0, 0, 0}};


    public static int[][] matrixSearchNormal = new int[][]{
            {0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4, 0},
            {0, 5, 6, 7, 8, 0},
            {0, 9, 10, 11, 12, 0},
            {0, 13, 14, 15, 16, 0},
            {0, 0, 0, 0, 0, 0}};

    public static String[][] getValuesTagArrayNormal() {
        return valuesTagArrayNormal;
    }

    public static String[][] getValuesTagArrayEasy() {
        return valuesTagArrayEasy;
    }
}