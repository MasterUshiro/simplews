package ua.com.simplews.example.sorting;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

//сортировка вставками
//Реализация сортировки очень проста, всего 3 строчки. Функция swap меняет местами элементы x[j-1] и x[j].
//Вложенный цикл ищет место для вставки.
public class Inserts {


    @Test
    void insertsSorting() {

        int[] arr = {12, 77, 4, 6, 88, 1, 0, 18};

        for (int i=1; i<arr.length; i++) {
            int x = arr[i];
            int j=i;
            while(j > 0 && arr[j - 1] > x ) {
                arr[j] = arr[j-1];
                j=j-1;
            }
            arr[j] = x;
        }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    void repeate() {

        int[] testArr = {2, 0, 55, 3};

        for (int i = 1; i < testArr.length; i++) {

            int j=i;
            int x = testArr[i];
            while (j>0 && testArr[j-1]>x) {
                testArr[j] = testArr[j-1];
                j--;
            }
            testArr[j] = x;

        }

        System.out.println(Arrays.toString(testArr));


    }














}
