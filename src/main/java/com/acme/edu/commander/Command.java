package com.acme.edu.commander;


import com.acme.edu.formatter.FormatVisitor;

/**
 * @author MishaAndEugen
 * класс Command отвечает за добавление новых типов с помощью полиморфизма
 */

public interface Command {
    Command perform(Command command);
    void accept(FormatVisitor formatVisitor);
    boolean isReadyFlush();
    void flush();
}
