package ua.com.simplews.example;

import java.util.*;


//https://leetcode.com/
class Epam20200108 {

    public static final Epam20200108 INSTANCE = new Epam20200108();

    private Epam20200108() {

    }

    public static void main(String[] args) {
        new ZOPA2().get();
    }


    private final int date = new Random().nextInt();

    public int getDate() {
        return date;
    }

    public static Epam20200108 getINSTANCE() {
        return INSTANCE;
    }

    private String test;
}


class ZOPA {

    public void get() {
        Epam20200108 epam = Epam20200108.INSTANCE;
        System.out.println("start = " + epam.getDate());
        Thread mainThread = Thread.currentThread();
        System.out.println("mainThread.getName() = " + mainThread.getName());

        Integer i = 1_000_000;
        while (true) {
            i--;
            if (i <= 0) break;
        }

        System.out.println("finish = " + epam.getDate());
    }
}

class TestSingl {

    private static TestSingl inst;

    private TestSingl() {

    }

    public static synchronized TestSingl getInst() {
        if (inst == null) {
            inst = new TestSingl();
        }
        return inst;
    }

    private final int date = new Random().nextInt();

    public int getDate() {
        return date;
    }

}


class ZOPA2 {

    public void get() {
        TestSingl epam = TestSingl.getInst();
        System.out.println("start = " + epam.getDate());
        Thread mainThread = Thread.currentThread();
        System.out.println("mainThread.getName() = " + mainThread.getName());

        Integer i = 1_000_000;
        while (true) {
            i--;
            if (i <= 0) break;
        }

        System.out.println("finish = " + epam.getDate());
    }

}


interface Fruit {

    void getString();

}

class Apple implements Fruit {

    public void getString() {
        System.out.println("Apple " + this.getClass().getName());
    }

}

class Orange implements Fruit {

    public void getString() {
        System.out.println("Orange " + this.getClass().getName());
    }

}

class TestG {

    private String zopa = "KAKAPUO";
    static List<Fruit> list = new ArrayList<>();


    public static void main(String[] args) {

        list.add(new Orange());
        list.add(new Apple());

        list.forEach(item-> item.getString());

        TestG i = new TestG();
        TestG i2 = new TestG();
        TestG i3 = new TestG();
        System.out.println("i1.hashCode() = " + i.hashCode());
        System.out.println("i2.hashCode() = " + i2.hashCode());
        System.out.println("i3.hashCode() = " + i3.hashCode());
        i.add();


    }

    void add() {

        list.add(new Orange());
        list.add(new Apple());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}


class TestHS {
    public static void main(String[] args) {
        Set<Integer> test = new HashSet<>();
        Integer[] i = new Integer[]{-1, 0, 12, 3, 5, 2, 1};
        test.addAll(Arrays.asList(i));

        for (Integer t : test) {
            if (test.contains(t + 1) == false) {
                System.out.println("> " + (t+1));
                break;
            }
        }

    }
}

class Sorter {
    private int[] in = new int[]{101,2,3,6,7,90,-1};
    void soso() {

    }
}