package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class IntegerHandler extends Handler {
    private int buffer;

    public IntegerHandler(Printer printer, Design design) {
        super(printer, design);
    }


    private void summer(int message) {
        if(!checkOwerflow(message)){
            buffer += message;
        }
    }

    private boolean checkOwerflow(int message) {
        int delta = Integer.MAX_VALUE - buffer;
        if (message > delta) {
            printer.print(design.getType()+Integer.MAX_VALUE);
            buffer = message - delta;
            return  true;
        }
        return false;
    }

    @Override
    public void perform(Object message) {
        summer((Integer) message);
    }

    @Override
    public void flush() {
        printer.print(design.getType()+buffer);
        buffer = 0;
    }

}
