package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс StringCommand предназначен для получения новой команды с сообщением типа String,
 * аккумулирования и передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class StringCommand implements Command {
    private String stringMessage;
    private String lastStr = "";
    private String result = "";
    private int buffer;
    private boolean readyFlush;

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
            result += stringMessage + "\n";
        }
        lastStr = stringMessage;
        readyFlush = true;
    }

    private void indexingStr(){
        if(buffer > 0){
            deleteLastSymStr();
            result += " (x" + (buffer + 1) + ")\n";
            buffer = 0;
        }
    }

    private void deleteLastSymStr() {
        if(!result.equals("")){
            StringBuilder stringBuilder = new StringBuilder(result);
            stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
            result = stringBuilder.toString();
        }
    }

    public String getStringMessage(){
        return stringMessage;
    }

    public String getResult(){
        return result;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        indexingStr();
        deleteLastSymStr();
        result = formatVisitor.formatString(this);
    }

    @Override
    public void flush() {
        result = "";
        lastStr = "";
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
