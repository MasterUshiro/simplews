package ua.com.simplews.example;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Memory {


    public static void main(String[] args) {
        new Memory().test();
    }

    List list = new ArrayList();


    void test() {
        list.add("z");
        try {
            System.out.println("capa = "  + getCapacity((ArrayList<?>) list));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int getCapacity(ArrayList<?> l) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        Object[]     data = (Object[]) dataField.get(l);
        for(Object d : data ) {
            System.out.println("d = " + d);
        }

        return ((Object[]) dataField.get(l)).length;
    }

    public static void  f(IntHolder obj) {
    }

    IntHolder x = new IntHolder(0)  ;

    class IntHolder {

        public int value;

        List list = new ArrayList();

        void test() {
            System.out.println(list.size());
        }
        public IntHolder(int value) {
            this.value = value;
        }

    }

}
