package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */


/**
 * Logs messages.
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {

    public static int buffer = 0;

    private static String fullStr = "";
    private static String lastStr = "";

    public static void log(int message) {
        //region output
        //flushStr();
        buffer = checkOwerflowSum(message);
        //endregion
    }

    private static int checkOwerflowSum(int message){
        int sum = message + buffer;
        if((sum < message || sum < buffer) && sum != message && sum != buffer){
            print(buffer);
        } else {
            return sum;
        }
        return Integer.MAX_VALUE;
    }

    public static void log(byte message) {
        //region output
        
        print(message,"primitive");
        //print(message);
        //endregion
    }

    public static void log(char message) {
        //region output
        print(message,"char");
        //print(message);
        //endregion
    }

    public static void log(String message) {
        //region output
        flushInt();
        print(message,"string");
        //aaa(message);
        //endregion
    }

    private static void aaa(String message){
        if(message.equals(lastStr)){
            buffer++;
        } else {
            fullStr = bbb(buffer+1);
            fullStr += message + "\r\n";
        }
        lastStr = message;
    }

    private static String bbb(int buffer){
        StringBuilder stringBuilder = new StringBuilder();
        if(buffer > 1){
            stringBuilder.append("(x").append(buffer).append(")");
        }
        return stringBuilder.toString();
    }

    public static void log(boolean message) {
        //region output
        print(message,"primitive");
        //endregion
    }

    public static void log(Object message) {
        //region output
        print(message,"reference");
        //print(message);
        //endregion
    }

    public static void log(int[] arr){
        StringBuilder stringBuilder = new StringBuilder("primitives array: {");
        stringBuilder = arrToString(arr, stringBuilder);
        stringBuilder.append("}");
        print(stringBuilder.toString());
    }

    private static StringBuilder arrToString(int[] arr, StringBuilder stringBuilder){
        for (int item : arr){
            stringBuilder.append(item+", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return  stringBuilder;
    }

    public static void log(int[][] arr){
        StringBuilder stringBuilder = new StringBuilder("primitives matrix: {\r\n");
        for (int[] item : arr){
            stringBuilder.append("{");
            stringBuilder = arrToString(item,stringBuilder);
            stringBuilder.append("}\r\n");
        }
        stringBuilder.append("}");
        print(stringBuilder.toString());
    }



    private static void print(Object message, String type) {
        System.out.println(type + ": " + message);
    }

    private static void print(Object message) {
        System.out.println(message);
    }

    public static void flushInt() {
        print(buffer,"primitive");
        buffer = 0;
    }

    public static void flushStr(){
        print(fullStr);
        fullStr = "";
        lastStr = "";
        buffer = 0;
    }
}

