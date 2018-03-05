package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class ArrayHandler implements Handler {
    private int[] arrayMessage;
    private Printer printer;

    public ArrayHandler(int[] message, Printer printer) {
        arrayMessage = message;
        this.printer = printer;
    }

    @Override
    public void handle() {
        StringBuilder stringBuilder = new StringBuilder("primitives array: {");
        //stringBuilder.append("{");
        stringBuilder = arrToString(arrayMessage, stringBuilder);
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
