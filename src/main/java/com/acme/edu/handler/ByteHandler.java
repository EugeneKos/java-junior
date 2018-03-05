package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class ByteHandler implements Handler {
    private byte byteMessage;
    private byte buffer;

    private Printer printer;

    public ByteHandler(byte byteMessage, Printer printer) {
        this.byteMessage = byteMessage;
        this.printer = printer;
    }

    private void summer(byte byteMessage) {
        if(!checkOwerflow(byteMessage)){
            buffer += byteMessage;
        }
    }

    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - buffer);
        if (byteMessage > delta) {
            buffer = Byte.MAX_VALUE;
            flush();
            buffer = (byte) (byteMessage - delta);
            return  true;
        }
        return false;
    }

    @Override
    public void handle() {
        summer(byteMessage);
    }

    @Override
    public void flush() {
        printer.print("primitive: "+buffer);
        buffer = 0;
    }

    @Override
    public void setBuffer(String buffer) {
        this.buffer = Byte.parseByte(buffer);
    }

    @Override
    public String getBuffer() {
        return ""+buffer;
    }
}
