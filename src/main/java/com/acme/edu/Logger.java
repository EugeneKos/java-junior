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
    public static int bufferStr = 0;

    private static String fullStr = "";
    private static String lastStr = "";

    public static void log(int message) {
        //region output
        flushStr();
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
        //endregion
    }

    public static void log(char message) {
        //region output
        print(message,"char");
        //endregion
    }

    public static void log(String message) {
        //region output
        flushInt();
        buildStr(message);
        //endregion
    }

    private static void buildStr(String message){
        if(message.equals(lastStr)){
            bufferStr++;
        } else {
            indexingStr();
            fullStr += message + "\n";
        }
        lastStr = message;
    }

    private static void indexingStr(){
        if(bufferStr > 0){
            deleteLastSymStr();
            fullStr += " (x" + (bufferStr + 1) + ")\n";
            bufferStr = 0;
        }
    }

    private static void deleteLastSymStr() {
        if(!fullStr.equals("")){
            StringBuilder stringBuilder = new StringBuilder(fullStr);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            fullStr = stringBuilder.toString();
        }
    }


    public static void log(boolean message) {
        //region output
        print(message,"primitive");
        //endregion
    }

    public static void log(Object message) {
        //region output
        print(message,"reference");
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
        StringBuilder stringBuilder = new StringBuilder("primitives matrix: {\n");
        for (int[] item : arr){
            stringBuilder.append("{");
            stringBuilder = arrToString(item,stringBuilder);
            stringBuilder.append("}\n");
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
        indexingStr();
        deleteLastSymStr();
        print(fullStr,"string");
        fullStr = "";
        lastStr = "";
    }
}

