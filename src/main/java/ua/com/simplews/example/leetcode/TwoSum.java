package ua.com.simplews.example.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {
    //https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            System.out.println("target - nums[i] = " + (target - nums[i]));
            if (visited.containsKey(target - nums[i])) {
                result[0] = visited.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            System.out.println("put key = " + nums[i] + " val = " + i);
            visited.put(nums[i], i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {4, 6, 3, 5, 7, 2, 2, 15};

        int[] res = new TwoSum().myusum2(arr, 17);

        IntStream.of(res).boxed().forEach(System.out::println);



        System.out.println(">> res + 1 = " + new TwoSum().nextValue(arr));


    }


    int[] myusum2(int[] in, int target) {

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < in.length; i++) {

            if (map.containsKey(target - in[i])) {
                result[0] = map.get(target - in[i]);
                result[1] = i;
                return result;
            } else {
                map.put(in[i], i);
            }


        }

        return result;

    }

    public int nextValue(int[] array) {
        int result = 0;

        HashSet<Integer> hs = new HashSet<>(IntStream.of(array).boxed().collect(Collectors.toList()));

        hs.stream().forEach(System.out::println);

        for (int i = 0; i < array.length; i++) {

            int reTemp = array[i] + 1;
            if (!hs.contains(reTemp)) {
                result = reTemp;
                return reTemp;
            }

        }

        return result;
    }


}
