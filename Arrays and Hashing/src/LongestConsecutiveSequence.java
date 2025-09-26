//LC q no 128

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int[] nums = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};


        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutive2(nums));
        System.out.println(longestConsecutive3(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i] - 1;

            if (map.containsKey(num1)) {
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }

            int num2 = nums[i] + 1;
            if (map.containsKey(num2)) {
                map.put(num2, false);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        int maxLength = 0;

        for (int key: keys) {

            if ((map.get(key))) {
                int count = 0;

                while (map.containsKey(key + count)) {
                    count++;
                }

                if (count > maxLength) {
                    maxLength = count;
                }
            }
        }
        return maxLength;
    }


    public static int longestConsecutive2(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num1 = nums[i] - 1;

            if (map.containsKey(num1)) {
                map.put(nums[i], false);
            } else {
                map.put(nums[i], true);
            }

            int num2 = nums[i] + 1;
            if (map.containsKey(num2)) {
                map.put(num2, false);
            }
        }

        // ✅ OPTIMIZED: Direct iteration instead of ArrayList
        int maxLength = 0;
        for (int key : map.keySet()) {  // No ArrayList needed!
            if (map.get(key) == true) {
                int count = 0;
                while (map.containsKey(key + count)) {
                    count++;
                }
                if (count > maxLength) {
                    maxLength = count;
                }
            }
        }
        return maxLength;
    }

    public static int longestConsecutive3(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num: numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int count = 0;

                while (numSet.contains(currentNum + count)) {
                    count++;
                }

                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }
}
