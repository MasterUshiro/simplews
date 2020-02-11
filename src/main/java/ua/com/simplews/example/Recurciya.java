package ua.com.simplews.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recurciya {


    public static void main(String[] args) {
        Recurciya rec = new Recurciya();
        Node node = rec.new Node();
        List<Node> list = node.genNodes(1,2,3);




        for (Node item: list) {

            System.out.println( item.item != null ? ("node ind = " + item.value + " next > "+ item.item.value) : "0");

        }

    }

    class Node {

        public Node() {
        }

        private int value;
        private Node item;

        public Node(int value, Node item) {
            this.value = value;
            this.item = item;
        }

        List<Node> genNodes(int... values) {

            List<Node> list = new ArrayList();

            Node item = null;
            for (int i = 0; i <values.length ; i++) {

                if (i==0) {
                    item = new Node(i, item);
                } else {
                    item = new Node(i, new Node(i,item));
                }
                list.add(item);

            }
            return list;
        }


        Node genRec(int... values) {

            if (values.length==0) {
                return null;
            } else {
                int[] newArray = Arrays.copyOfRange(values, 1, values.length);
                return new Node(values[0],genRec(newArray));
            }

        }




    }




}
