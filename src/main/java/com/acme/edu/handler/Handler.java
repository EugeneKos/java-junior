package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public abstract class Handler {
    protected Printer printer;
    protected Design design;

    public Handler(Printer printer, Design design) {
        this.printer = printer;
        this.design = design;
    }

    public abstract void perform(Object message);
    public abstract void flush();
}
