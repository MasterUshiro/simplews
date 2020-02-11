package ua.com.simplews.example;

import java.util.ArrayList;
import java.util.List;

public class Generics<T> {

    T ob;

    Generics(T e) {
        this.ob = e;
    }

    T getOb() {
        return ob;
    }


    // Показать тип T
    void showType() {
        System.out.println("Тип T: " + ob.getClass().getName());
    }


    public static <I> I[] getSomething(I... a) {
        return a;
    }

    public  <H> H getH(H h) {
        return h;
    }

    public  List getH(List<?> no) {
        return no;
    }

}

class TestGen {
    public static void main(String[] args) {

        Integer i = 100;
        Generics<Integer> intTest = new Generics<Integer>(i);
        System.out.println("intTest = " + intTest.getOb());
        intTest.showType();

        Integer[] t = {1, 23, 45};

        Integer[] something = Generics.getSomething(t);

        List<Integer> testList = new ArrayList();
        testList.add(1);
        testList.add(12);

        for (Integer tt : testList) {
            System.out.println("tt = " + tt);
        }

        testList.forEach(integer -> System.out.println(integer.toString().replaceAll("1", "888")));


        //testList.forEach(item -> System.out.println("lambda for testList = " + item));

        for (Integer ii : something) {
            System.out.println("getSomething = " + ii);
        }


    }
}
