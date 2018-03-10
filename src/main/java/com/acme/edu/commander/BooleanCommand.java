package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс BooleanCommand предназначен для получения новой команды с сообщением типа boolean и
 * передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class BooleanCommand implements Command {
    private boolean booleanMessage;
    private String result;
    private boolean readyFlush;

    public BooleanCommand(boolean message) {
        booleanMessage = message;
    }

    public BooleanCommand(){

    }

    public boolean getBooleanMessage() {
        return booleanMessage;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof BooleanCommand){
            booleanMessage = ((BooleanCommand)command).getBooleanMessage();
            readyFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result = formatVisitor.formatBoolean(this);
    }

    @Override
    public void flush() {
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
