package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс ObjectCommand предназначен для получения новой команды с сообщением типа Object и
 * передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class ObjectCommand implements Command {
    private Object objectMessage;
    private boolean readyFlush;
    private String result;

    public ObjectCommand(Object message) {
        objectMessage = message;
    }

    public Object getObjectMessage() {
        return objectMessage;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof ObjectCommand){
            objectMessage = ((ObjectCommand)command).getObjectMessage();
            readyFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result = formatVisitor.formatObject(this);
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
