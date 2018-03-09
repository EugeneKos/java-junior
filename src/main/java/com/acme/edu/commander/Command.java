package com.acme.edu.commander;


import com.acme.edu.formatter.FormatVisitor; /**
 * @author MishaAndEugen
 * класс Рandler отвечает за добавление новых типов с помощью полиморфизма
 */
public interface Command {
    Command perform(Command command);
    void accept(FormatVisitor formatVisitor);
    boolean isFlush();
    void flush();
}
