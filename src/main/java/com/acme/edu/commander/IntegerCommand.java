package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

/**
 * @author eugene
 * Класс IntegerCommand предназначен для получения новой команды с сообщением типа int,
 * аккумулирования передачи этого сообщения в Visitor для дальнейшего форматироания.
 */

public class IntegerCommand implements Command {
    private int buffer;
    private int intMessage;
    private String result = "";
    private boolean readyFlush;

    public IntegerCommand(int message) {
        intMessage = message;
    }

    private void accumulator(int intMessage) {
        if(!checkOwerflow(intMessage)){
            buffer += intMessage;
            readyFlush = true;
        }
    }

    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - buffer;
        if (intMessage > delta) {
            result += Integer.MAX_VALUE + "\n";
            buffer = intMessage - delta;
            return  true;
        }
        return false;
    }

    @Override
    public Command perform(Command command) {
        if(command instanceof IntegerCommand){
            intMessage = ((IntegerCommand)command).getIntMessage();
        }
        accumulator(intMessage);
        return this;
    }

    @Override
    public void accept(FormatVisitor formatVisitor) {
        result += formatVisitor.formatInteger(this);
    }

    @Override
    public void flush() {
        buffer = 0;
        result = "";
        readyFlush = false;
    }

    @Override
    public boolean isReadyFlush() {
        return readyFlush;
    }

    public int getIntMessage(){
        return intMessage;
    }

    public int getBuffer(){
        return buffer;
    }

    public String toString(){
        return result;
    }
}
