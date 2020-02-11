package ua.com.simplews.example.collection;

import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapTest {

    @Test
    public void hmTest() {

        Map<Integer, String> map = new HashMap();

        map.put(20, "Zora");
        map.put(10, "Vaysa");
        map.put(15, "Conchita");
        map.put(20, "Pedro");

        Set<Map.Entry<Integer, String>> st = map.entrySet();

        Iterator<Map.Entry<Integer, String>> iterator = st.iterator();

        Set<Integer> setKey = map.keySet();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(" key = " + next.getKey() + " value = " + next.getValue());
        }


        for (Integer key : setKey) {
            System.out.println("key = " + key);
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if("something".equals(entry.getValue())){
                System.out.println(" key = " + entry.getKey() + " value = " + entry.getValue());
            }
        }

        map.entrySet().stream().forEach(x -> System.out.println("x = " +x.getKey() +" y= " + x.getValue()));

        Map<Integer, String> collect = map.entrySet().stream()
                .filter(x -> x.getKey() == 20)
                .collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
        System.out.println(collect.get(20));


        Map<Integer, String> collect2 = map.entrySet().stream()
                .filter(x -> x.getKey() == 15)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }




    @Test
    public void hmTest2() {

        Map<Th, String> test = new HashMap();

        Th th1 = new Th("123");
        System.out.println("th1 hc = " + th1.hashCode());

        test.put(th1, "Pedro");
        test.put(th1, "Pedro2");
        test.put(new Th("12344"), "Conchita2");
        test.put(new Th("222"), "Gomosyaka");
        test.put(new Th("333"), "Gomosyaka3");
        System.out.println(test);
        test.entrySet().stream().forEach(x-> System.out.println(" >> k = " +x.getKey() +" val = " +x.getValue() ));

        String[] stringValues =  new String[test.values().size()];

        test.values().toArray(stringValues);

        test.keySet().stream().forEach(x-> System.out.println("x -> " +
                x.getName()));
        Arrays.stream(stringValues).forEach(x-> System.out.println("data = " + x));


        //hashset to arraylist
        List<Th> list = new ArrayList<>(test.keySet());
        list.stream().forEach(x-> System.out.println("keySet to arrayList " + x.getName()));

        //arrayList to hashSet
        Set<Th> set = new HashSet<>(list);


    }


}

class Th {
    private String name;

    public Th(String name) {
        this.name = name;
    }

//    @Override
//    public int hashCode() {
//        System.out.println("test HS name = "+name+"  >> " +(int)name.charAt(0));
//        return (int)name.charAt(0);
//    }


    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.trim().length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Th th = (Th) o;
        return Objects.equals(name, th.name);
    }
}




