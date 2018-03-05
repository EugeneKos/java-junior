package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class BooleanHandler implements Handler {
    private boolean booleanMessage;
    private Printer printer;

    public BooleanHandler(boolean message, Printer printer) {
        booleanMessage = message;
        this.printer = printer;
    }

    @Override
    public void handle() {
        flush();
    }

    @Override
    public void flush() {
        printer.print("primitive: "+booleanMessage);
    }

    @Override
    public void setBuffer(String buffer) {

    }

    @Override
    public String getBuffer() {
        return null;
    }
}
