package com.acme.edu.handler;


/**
 * @author MishaAndEugen
 * класс Рandler отвечает за добавление новых типов с помощью полиморфизма
 */
public interface Handler {

    void handle();
    void flush();
    void setBuffer(String buffer);
    String getBuffer();
}
