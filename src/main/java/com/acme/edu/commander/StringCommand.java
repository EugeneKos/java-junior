package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class StringCommand implements Command {
    private String stringMessage;
    private String lastStr = "";
    private String fullStr = "";
    private int buffer;
    private boolean isFlush;

    public StringCommand(String message) {
        stringMessage = message;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof StringCommand){
            stringMessage = ((StringCommand)command).getStringMessage();
        }
        buildStr(stringMessage);
        return this;
    }

    private void buildStr(String stringMessage){
        if(stringMessage.equals(lastStr)){
            buffer++;
        } else {
            indexingStr();
            fullStr += stringMessage + "\n";
        }
        lastStr = stringMessage;
        isFlush = true;
    }

    private void indexingStr(){
        if(buffer > 0){
            deleteLastSymStr();
            fullStr += " (x" + (buffer + 1) + ")\n";
            buffer = 0;
        }
    }

    private void deleteLastSymStr() {
        if(!fullStr.equals("")){
            StringBuilder stringBuilder = new StringBuilder(fullStr);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            fullStr = stringBuilder.toString();
        }
    }

    public String getStringMessage(){
        return stringMessage;
    }

    public String getFullStr(){
        return fullStr;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        indexingStr();
        deleteLastSymStr();
        fullStr = formatVisitor.formatString(this);
    }

    @Override
    public void flush() {
        fullStr = "";
        lastStr = "";
        isFlush = false;
    }

    @Override
    public boolean isFlush() {
        return isFlush;
    }

    @Override
    public String toString(){
        return fullStr;
    }

}
