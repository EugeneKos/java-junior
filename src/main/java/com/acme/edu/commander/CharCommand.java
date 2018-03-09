package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class CharCommand implements Command {
    private char charMessage;
    private String forPrint;
    private boolean isFlush;

    public CharCommand(char message) {
        charMessage = message;
    }

    public char getCharMessage() {
        return charMessage;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof CharCommand){
            charMessage = ((CharCommand)command).getCharMessage();
            isFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatChar(this);
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
