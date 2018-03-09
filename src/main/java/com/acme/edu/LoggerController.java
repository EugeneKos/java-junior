package com.acme.edu;

import com.acme.edu.commander.DefaultCommand;
import com.acme.edu.commander.Command;
import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.formatter.PrefixFormatVisitor;
import com.acme.edu.printer.Printer;

public class LoggerController {
    private Printer printer;
    private Command currentCommand = new DefaultCommand();
    private FormatVisitor formatter = new PrefixFormatVisitor();

    public LoggerController(Printer printer) {
        this.printer = printer;
    }

    public void execute(Command command){
        if(!command.getClass().equals(currentCommand.getClass())){
            flush();
            currentCommand = command;
        }
        currentCommand = currentCommand.perform(command);
    }


    public void flush(){
        if(currentCommand.isFlush()){
            formatAndSave();
            currentCommand.flush();
        }
    }

    private void formatAndSave(){
        formatter.visit(currentCommand);
        printer.print(currentCommand);
    }

}
