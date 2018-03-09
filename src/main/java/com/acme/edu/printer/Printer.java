package com.acme.edu.printer;

import com.acme.edu.commander.Command;

/**
 * @author MishaAndEugen
 * класс Printer отвечает за возможность изменения места вывода с помощью полиморфизма
 */
public interface Printer {
    void print(Command command);
}
