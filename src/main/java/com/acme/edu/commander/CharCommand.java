package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс CharCommand предназначен для получения новой команды с сообщением типа char и
 * передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class CharCommand implements Command {
    private char charMessage;
    private String result;
    private boolean readyFlush;

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
            readyFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result = formatVisitor.formatChar(this);
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
