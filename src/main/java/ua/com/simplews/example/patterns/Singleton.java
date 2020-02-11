package ua.com.simplews.example.patterns;

import org.junit.jupiter.api.Test;

public class Singleton {

    private String text;

    private Singleton(String text) {
        this.text = text;
    }

    private static volatile Singleton instance;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Singleton getInstance(String value) {


        if (instance!=null) {
            return instance;
        }
        synchronized (Singleton.class) {
            if (instance==null) {
                instance = new Singleton(value);
            }
            return instance;
        }


    }


}


class Ke {
    @Test
    void go() {
        Singleton si1 = Singleton.getInstance("zopa1");
        si1 = Singleton.getInstance("zopa2");
        System.out.println(si1.getText());
    }
}