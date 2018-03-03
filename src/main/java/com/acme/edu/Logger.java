package com.acme.edu;

//kdjghdfkgjhdfkgjhdfkgj
/*
gkjfhkgjfhg
лоралопралопр
лпораплорапл
 */


import com.acme.edu.disign.Design;
import com.acme.edu.handler.Handler;
import com.acme.edu.handler.IntegerHandler;
import com.acme.edu.handler.StringHandler;
import com.acme.edu.printer.ConsolePrinter;

/**
 * Logs messages.
 *
 * @param
 * @author EK
 * @see
 */
public class Logger {

    private static Handler[] handlers = {new IntegerHandler(new ConsolePrinter(), new Design("primitive: ")),
            new StringHandler(new ConsolePrinter(), new Design("string: "))};

    public static void log(int message) {
        //region output
        handlers[0].perform(message);
        flushStr();
        //endregion
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
        handlers[1].perform(message);
        //buildStr(message);
        //endregion
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
        handlers[0].flush();
    }

    public static void flushStr(){
        handlers[1].flush();
    }
}

