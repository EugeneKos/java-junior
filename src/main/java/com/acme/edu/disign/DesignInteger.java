package com.acme.edu.disign;

/**
 * @author MishaAndEugen
 * класс DesignInteger отвечает за возможность изменения стиля вывода
 */
public class DesignInteger extends Design {

    private String ssss;

    public DesignInteger(String type, String ssss) {
        super(type);
        this.ssss = ssss;
    }

    public String getSsss() {
        return ssss;
    }
}
