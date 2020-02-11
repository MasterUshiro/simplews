package ua.com.simplews.example.leetcode;

import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/add-two-numbers/
/*
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {


    @Test
    void doo() {
        ListNode ln1 = new ListNode(9);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ln1.next = ln2;
        ln2.next = ln3;


        ListNode ln11 = new ListNode(5);
        ListNode ln12 = new ListNode(6);
        ListNode ln13 = new ListNode(4);
        ln11.next = ln12;
        ln12.next = ln13;

        //ListNode res = addTwoNumbers(ln1,ln11);

        goNode(ln1, ln11);

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    void goNode(ListNode node1, ListNode node2) {
        ListNode dummyHead =  null;
        ListNode res = null;
        int add = 0;
        while (node1 != null || node2 != null) {

            int one = (node1 != null) ? node1.val : 0;
            int two = (node2 != null) ? node2.val : 0;
            int sum = one + two + add;
            add = sum / 10;


            if (dummyHead==null) {
                dummyHead =  new ListNode(sum % 10);
                res = dummyHead;
            } else {
                res.next = new ListNode(sum % 10);
                res = res.next;
            }


            if (node1 != null) node1 = node1.next;
            if (node2 != null) node2 = node2.next;

        }

        printNode(dummyHead);

    }

    void printNode(ListNode node) {
        while (node != null) {
            System.out.println(">> << " + node.val);
            node = node.next;
        }
    }

    @Test
    void div() {
        int i = 12;
        System.out.println(19 / 10);
        System.out.println(19 % 10);
    }

    @Test
    void nodeDancing() {

        ListNode dummyHead =  null;
        ListNode res = null;

        for (int i = 1; i < 5; i++) {
            if (dummyHead==null) {
                dummyHead =  new ListNode(i);
                res = dummyHead;
            } else {
                res.next = new ListNode(i);
                res = res.next;
            }


        }
        printNode(dummyHead);
    }


}


