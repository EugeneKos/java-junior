package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class BooleanCommand implements Command {
    private boolean booleanMessage;
    private String forPrint;
    private boolean isFlush;

    public BooleanCommand(boolean message) {
        booleanMessage = message;
    }

    public boolean getBooleanMessage() {
        return booleanMessage;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof BooleanCommand){
            booleanMessage = ((BooleanCommand)command).getBooleanMessage();
            isFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatBoolean(this);
    }

    @Override
    public void flush() {
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
