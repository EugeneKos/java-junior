package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class ObjectCommand implements Command {
    private Object objectMessage;
    private boolean isFlush;
    private String forPrint;

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
            isFlush = true;
        }
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        forPrint = formatVisitor.formatObject(this);
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
