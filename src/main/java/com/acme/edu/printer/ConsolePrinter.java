package com.acme.edu.printer;

import com.acme.edu.commander.Command;

public class ConsolePrinter implements Printer {
    @Override
    public void print(Command command) {
        System.out.println(command);
    }
}
