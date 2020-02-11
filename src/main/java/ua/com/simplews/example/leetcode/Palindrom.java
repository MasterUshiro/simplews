package ua.com.simplews.example.leetcode;

import org.junit.jupiter.api.Test;

public class Palindrom {
    static String s;

    static {
        s = "ШалаШ";
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}


interface radioable {

    public static final int freaquance = 0;

    void sound();

    default int style() {

        System.out.println("It is my style " + freaquance);
        return freaquance;
    }

}

class radioZopa implements radioable {

    @Override
    @Test
    public void sound() {
        System.out.println(">> "  +style()) ;
    }
}