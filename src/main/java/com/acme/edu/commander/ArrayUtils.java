package com.acme.edu.commander;

public class ArrayUtils {

    public static String arrayToString(int[] array){
        StringBuilder stringBuilder = new StringBuilder("{");
        for (int item : array){
            stringBuilder.append(item+", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("}");
        return  stringBuilder.toString();
    }

    public static String arrayToString(int[][] array){
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (int[] item : array){
            stringBuilder.append(arrayToString(item)).append("\n");
        }
        //stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append("}");
        return  stringBuilder.toString();
    }
}
