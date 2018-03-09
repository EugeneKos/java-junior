package com.acme.edu.commander;

import com.acme.edu.formatter.FormatVisitor;

public class IntegerCommand implements Command {
    private int buffer;
    private int intMessage;
    private String forPrint = "";
    private boolean isFlush;

    public IntegerCommand(int message) {
        intMessage = message;
    }

    private void accumulator(int intMessage) {
        if(!checkOwerflow(intMessage)){
            buffer += intMessage;
            isFlush = true;
        }
    }

    private boolean checkOwerflow(int intMessage) {
        int delta = Integer.MAX_VALUE - buffer;
        if (intMessage > delta) {
            //buffer = Integer.MAX_VALUE;
            forPrint += Integer.MAX_VALUE + "\n";
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
        forPrint += formatVisitor.formatInteger(this);
    }

    @Override
    public void flush() {
        buffer = 0;
        isFlush = false;
    }

    @Override
    public boolean isFlush() {
        return isFlush;
    }

    public int getIntMessage(){
        return intMessage;
    }

    public int getBuffer(){
        return buffer;
    }

    public String toString(){
        return forPrint;
    }
}
