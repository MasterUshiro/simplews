package ua.com.simplews.example.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

class ArrayListCollection {

    @Test
    public void test1() {

        int[] intArr = {2, 1, 6, 345};
        List<Integer> list = IntStream.of(intArr).boxed().collect(Collectors.toList());


        double[] stringArr = {1, 13, 66, 32};
        List<Double> listString = DoubleStream.of(stringArr).boxed().collect(Collectors.toList());

        listString.forEach(System.out::println);
        System.out.println("+++++++++++");

        List sortedList = list.stream().sorted().collect(Collectors.toList());

        System.out.println("------------");

        sortedList.forEach(System.out::println);
        System.out.println("Size = " + sortedList.size());
        sortedList.remove(1);
        System.out.println("------------");
        sortedList.forEach(System.out::println);
        System.out.println("Size = " + sortedList.size());


        System.out.println("---div---");
        //проверка работы с разными тимами

        ArrayListCollection alc = new ArrayListCollection();


        List testTypes = new ArrayList();
        testTypes.add(1);
        testTypes.add("2");
        testTypes.add(new Object());
        testTypes.add(new ArrayList<>());
        testTypes.add(this.new T1("testname").toString());

        testTypes.forEach(x -> System.out.println("hcode " + x.hashCode()));

        System.out.println("---divFIX-Object--");
        List<Object> testTypesFix = new ArrayList();
        testTypesFix.add("1");
        testTypesFix.add(new Object());
        testTypesFix.add(new Integer(1));
        testTypesFix.add(this.new T1("aaa"));
        testTypes.forEach(x -> System.out.println("hcode " + x.hashCode()));

        System.out.println("---divFIX List---");
        List<List> testTypesFixList = new ArrayList();
        testTypesFixList.add(new ArrayList());
//        testTypesFixList.add(new Integer(1));
//        testTypesFixList.add(this.new T1("aaa"));
        testTypesFixList.forEach(x -> System.out.println("hcode " + x.hashCode()));


        ArrayListCollection.T1 item = new ArrayListCollection.T1("test");
        ArrayListCollection.T1 item2 = this.new T1("test");
        new T2();
    }
    //внутренний класс
    class T1 {

        private String name;
        private ArrayListCollection linkToOuter;

        public T1(String name) {
            linkToOuter = ArrayListCollection.this;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
//вложенный ласс
class T2 {

}


