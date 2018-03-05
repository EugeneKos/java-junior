package com.acme.edu.disign;

/**
 * @author MishaAndEugen
 * класс дизайн отвечает за стиль вывода
 */
public class Design {
    private final String type;
    private String prefix;
    private String postfix;

    public Design(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPostfix() {
        return postfix;
    }

    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }
}
