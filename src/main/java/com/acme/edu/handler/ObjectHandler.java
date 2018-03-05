package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class ObjectHandler implements Handler {
    private Object objectMessage;
    private Printer printer;

    public ObjectHandler(Object message, Printer printer) {
        objectMessage = message;
        this.printer = printer;
    }


    @Override
    public void handle() {
        flush();
    }

    @Override
    public void flush() {
        printer.print("reference: "+objectMessage);
    }

    @Override
    public void setBuffer(String buffer) {

    }

    @Override
    public String getBuffer() {
        return null;
    }
}
