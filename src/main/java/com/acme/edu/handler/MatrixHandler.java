package com.acme.edu.handler;

import com.acme.edu.printer.Printer;

public class MatrixHandler implements Handler {
    private int[][] matrixMessage;
    private Printer printer;

    public MatrixHandler(int[][] message, Printer printer) {
        matrixMessage = message;
        this.printer = printer;
    }

    @Override
    public void handle() {
        StringBuilder stringBuilder = new StringBuilder("primitives matrix: {"+"\r\n");
        for (int[] item : matrixMessage){
            stringBuilder.append("{");
            stringBuilder = arrToString(item,stringBuilder);
            stringBuilder.append("}\r\n");
        }
        stringBuilder.append("}");
        printer.print(stringBuilder.toString());
    }

    @Override
    public void flush() {

    }

    @Override
    public void setBuffer(String buffer) {

    }

    @Override
    public String getBuffer() {
        return null;
    }

    private StringBuilder arrToString(int[] arr, StringBuilder stringBuilder){
        for (int item : arr){
            stringBuilder.append(item+", ");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        return  stringBuilder;
    }
}
