package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class StringHandler implements Handler {
    private String stringMessage;
    private Printer printer;
    private String lastStr = "";
    private String fullStr = "";
    private int buffer;

    public StringHandler(String message, Printer printer) {
        stringMessage = message;
        this.printer = printer;
    }


    @Override
    public void handle() {
        buildStr(stringMessage);
    }

    private void buildStr(String stringMessage){
        if(stringMessage.equals(lastStr)){
            buffer++;
        } else {
            indexingStr();
            fullStr += stringMessage + "\n";
        }
        lastStr = stringMessage;
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

    @Override
    public void flush() {
        indexingStr();
        deleteLastSymStr();
        printer.print("string: "+fullStr);
        fullStr = "";
        lastStr = "";
    }

    @Override
    public void setBuffer(String buffer) {
        String[] masBuffer = buffer.split(":");
        lastStr = masBuffer[0];
        fullStr = masBuffer[1];
        this.buffer = Integer.parseInt(masBuffer[2]);
    }

    @Override
    public String getBuffer() {
        return lastStr+":"+fullStr+":"+buffer;
    }


}
