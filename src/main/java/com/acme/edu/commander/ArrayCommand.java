package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class ArrayCommand implements Command {
    private int[] arrayMessage;
    private String forPrint;
    private boolean isFlush;

    public ArrayCommand(int[] message) {
        arrayMessage = message;
    }

    public int[] getArrayMessage() {
        return arrayMessage;
    }

    public String getForPrint() {
        return forPrint;
    }

    private void buildArrayString(){
        forPrint = ArrayUtils.arrayToString(arrayMessage);
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof ArrayCommand){
            arrayMessage = ((ArrayCommand)command).getArrayMessage();
            buildArrayString();
            isFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatArray(this);
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
