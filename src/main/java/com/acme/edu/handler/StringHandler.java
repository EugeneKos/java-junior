package com.acme.edu.handler;

import com.acme.edu.disign.Design;
import com.acme.edu.printer.Printer;

public class StringHandler extends Handler {
    private String lastStr = "";
    private String fullStr = "";
    private int buffer;

    public StringHandler(Printer printer, Design design) {
        super(printer, design);
    }


    @Override
    public void perform(Object message) {
        buildStr((String) message);
    }

    private void buildStr(String message){
        if(message.equals(lastStr)){
            buffer++;
        } else {
            indexingStr();
            fullStr += message + "\n";
        }
        lastStr = message;
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
        printer.print(design.getType()+fullStr);
        fullStr = "";
        lastStr = "";
    }


}
