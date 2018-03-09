package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class ByteCommand implements Command {
    private byte byteMessage;
    private byte buffer;
    private boolean isFlush;
    private String forPrint = "";

    public ByteCommand(byte byteMessage) {
        this.byteMessage = byteMessage;
    }

    private void accumulator(byte byteMessage) {
        if(!checkOwerflow(byteMessage)){
            buffer += byteMessage;
            isFlush = true;
        }
    }

    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - buffer);
        if (byteMessage > delta) {
            buffer = Byte.MAX_VALUE;
            forPrint += Byte.MAX_VALUE + "\n";
            buffer = (byte) (byteMessage - delta);
            return  true;
        }
        return false;
    }

    public byte getByteMessage(){
        return byteMessage;
    }

    public byte getBuffer(){
        return buffer;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof ByteCommand){
            byteMessage = ((ByteCommand)command).getByteMessage();
        }
        accumulator(byteMessage);
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint += formatVisitor.formatByte(this);
    }

    @Override
    public void flush() {
        buffer = 0;
        isFlush = false;
    }

    @Override
    public boolean isFlush() {
        return isFlush;
    }

    @Override
    public String toString(){
        return forPrint;
    }
}
