package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class IntegerHandler implements Handler {
    private int buffer;
    private int intMessage;

    private Printer printer;

    public IntegerHandler(int message, Printer printer) {
        intMessage = message;
        this.printer = printer;
    }


    private void summer(int intMessage) {
        if(!checkOwerflow(intMessage)){
            buffer += intMessage;

        }
    }

    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - buffer;
        if (intMessage > delta) {
            buffer = Integer.MAX_VALUE;
            flush();
            buffer = intMessage - delta;
            return  true;
        }
        return false;
    }

    @Override
    public void handle() {
        summer(intMessage);
    }

    @Override
    public void flush() {
        printer.print(/*design.getType()*/"primitive: "+buffer);
        buffer = 0;
    }

    @Override
    public void setBuffer(String buffer) {
        this.buffer = Integer.parseInt(buffer);
    }

    @Override
    public String getBuffer() {
        return ""+buffer;
    }

}
