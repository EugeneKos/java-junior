package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс ArrayCommand предназначен для получения новой команды с сообщением типа int[] и
 * передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class ArrayCommand implements Command {
    private int[] arrayMessage;
    private String result;
    private boolean readyFlush;

    public ArrayCommand(int[] message) {
        arrayMessage = message;
    }

    public int[] getArrayMessage() {
        return arrayMessage;
    }

    public String getResult() {
        return result;
    }

    private void buildArrayString(){
        result = ArrayUtils.arrayToString(arrayMessage);
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof ArrayCommand){
            arrayMessage = ((ArrayCommand)command).getArrayMessage();
            buildArrayString();
            readyFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result = formatVisitor.formatArray(this);
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
