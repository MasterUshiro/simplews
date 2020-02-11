package ua.com.simplews.example.collection;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToTo {

    @Test
    void toto() {

        String[] stringsArray = {"Pedro", "Chmo", "Conchita"};

        System.out.println(Arrays.toString(stringsArray));

        //[]=>List
        List<String> stringList = Stream.of(stringsArray).collect(Collectors.toList());
        List<String> stringList2 = Arrays.asList(stringsArray);

        stringList.forEach(System.out::println);
        stringList2.forEach(x -> System.out.println("> " + x));

        //List=>HashSet
        HashSet<String> stringHashSet = new HashSet<>(stringList);
        stringHashSet.stream().forEach(System.out::println);
        stringHashSet.stream().forEach(x -> System.out.println(">> " + x));
        //HashSet=>ArrayList
        List<String> listString = new ArrayList<>(stringHashSet);
        listString.forEach(x -> System.out.println(">>> " + x));

        //HashMap=>HashSet

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "32");
        map.put(2, "2");
        map.put(11, "23");

        map.put(1, "2");
        map.put(3, "4");

        HashSet<Integer> hss = new HashSet<>(map.keySet());
        hss.stream().forEach(x -> System.out.println("hss = " + x));

        map.forEach((integer, s) -> System.out.println("integer = " + integer + " string = " + s));

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }

}
