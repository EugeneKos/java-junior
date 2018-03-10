package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс ByteCommand предназначен для получения новой команды с сообщением типа byte и
 * дальнейшего аккумулирования
 */

public class ByteCommand implements Command {
    private byte byteMessage;
    private byte buffer;
    private boolean readyFlush;
    private String result = "";

    public ByteCommand(byte byteMessage) {
        this.byteMessage = byteMessage;
    }

    private void accumulator(byte byteMessage) {
        if(!checkOwerflow(byteMessage)){
            buffer += byteMessage;
            readyFlush = true;
        }
    }

    private boolean checkOwerflow(byte byteMessage) {
        byte delta = (byte) (Byte.MAX_VALUE - buffer);
        if (byteMessage > delta) {
            result += Byte.MAX_VALUE + "\n";
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
        result += formatVisitor.formatByte(this);
    }

    @Override
    public void flush() {
        buffer = 0;
        result = "";
        readyFlush = false;
    }

    @Override
    public boolean isReadyFlush() {
        return readyFlush;
    }

    @Override
    public String toString(){
        return result;
    }
}
