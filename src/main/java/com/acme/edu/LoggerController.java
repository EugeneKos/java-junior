package com.acme.edu;

import com.acme.edu.commander.BooleanCommand;
import com.acme.edu.commander.Command;
import com.acme.edu.formatter.FormatVisitor;
import com.acme.edu.formatter.PrefixFormatVisitor;
import com.acme.edu.printer.Printer;

/**
 * Класс управления командами, форматированием и печатью.
 * @author eugene
 */

public class LoggerController {
    private Printer printer;
    private Command currentCommand = new BooleanCommand();
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
        if(currentCommand.isReadyFlush()){
            formatAndSave();
            currentCommand.flush();
        }
    }

    private void formatAndSave(){
        formatter.visit(currentCommand);
        printer.print(currentCommand);
    }

}
