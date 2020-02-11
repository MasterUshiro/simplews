package ua.com.simplews.example.general;

import org.junit.jupiter.api.Test;

import java.util.*;

public class CompareEqualsHashCode implements Comparable{

    private String text;
    private Integer inte;
    private int ii;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompareEqualsHashCode that = (CompareEqualsHashCode) o;
        return ii == that.ii &&
                Objects.equals(text, that.text) &&
                Objects.equals(inte, that.inte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, inte, ii);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Test
    void compa() {
        PumboComparator puuu = new PumboComparator();
        Set<Pumbo> testSet = new TreeSet<Pumbo>(puuu);

        testSet.add(new Pumbo("ZOpa",11));
        testSet.add(new Pumbo("Opa",1));
        testSet.add(new Pumbo("pa",21));
        testSet.add(new Pumbo("Oa",331));

        testSet.stream().forEach(System.out::println);

    }

    class Pumbo implements Comparable<Pumbo> {

        private String name;
        private Integer age;

        public Pumbo(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public Pumbo(String name, int age) {
            this.name = name;
            this.age = age;
        }


        @Override
        public int compareTo(Pumbo o) {
            return name.toLowerCase().compareTo(o.name.toLowerCase());
        }

        @Override
        public String toString() {
            return "Pumbo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    class PumboComparator implements Comparator<Pumbo> {

        public int compare(Pumbo a, Pumbo b){

            if(a.getAge()> b.getAge())
                return 1;
            else if(a.getAge()< b.getAge())
                return -1;
            else
                return 0;


        }
    }


}


class HashTest {

    StringComarator stringComarator = new StringComarator();

    TreeMap<String,Integer> navigableMap = new TreeMap<>(stringComarator);

    @Test
    void compo() {
        navigableMap.put("C_Germany", 12);
        navigableMap.put("Spain",1);
        navigableMap.put("A_France",-1);
        navigableMap.put("B_Italy",0);

        navigableMap.forEach((s, integer) -> System.out.println("key = " + s + " val = " + integer ));
        System.out.println("==");
//        navigableMap.descendingKeySet().forEach((s) -> System.out.println("key = " + s));
        System.out.println("======");
        navigableMap.tailMap("B_Italy").forEach((s, integer) -> System.out.println("key = " + s + " val = " + integer ));
    }

}

class StringComarator implements Comparator<String> {

    @Override
    public int compare(String obj1, String obj2) {
        return obj1.compareTo(obj2)>0 ? 1 : (obj1.compareTo(obj2)<0 ? -1 : 0);
    }
}


class LinkedHashTest {

    @Test
    void test() {
        LinkedHashMap<Integer, String> hashMap =new LinkedHashMap<>();
        hashMap.put(5,"a");
        hashMap.put(4,"b");
        hashMap.put(3,"c");
        for (Map.Entry<Integer,String> entry: hashMap.entrySet()) {
            System.out.println("k = " + entry.getKey() + " val " + entry.getValue());
        }
    }
}


class  EnumMapTest {
    enum EN_KEY {
        T1, T3, A1, A4
    }

    @Test
    void enMap() {
        EnumMap<EN_KEY, String> enumMap = new EnumMap<>(EN_KEY.class);
        enumMap.put(EN_KEY.T1,"ZOPA");
        enumMap.keySet().forEach((en_key) -> System.out.println("KEY = " + en_key));
    }

}
