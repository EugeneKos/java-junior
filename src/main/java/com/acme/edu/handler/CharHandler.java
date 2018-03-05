package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class CharHandler implements Handler {
    private char charMessage;
    private Printer printer;

    public CharHandler(char message, Printer printer) {
        charMessage = message;
        this.printer = printer;
    }

    @Override
    public void handle() {
        flush();
    }

    @Override
    public void flush() {
        printer.print("char: "+charMessage);
    }

    @Override
    public void setBuffer(String buffer) {

    }

    @Override
    public String getBuffer() {
        return null;
    }
}
