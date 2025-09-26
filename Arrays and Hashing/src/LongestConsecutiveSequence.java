//LC q no 128

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

        int[] nums = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6};


        System.out.println(longestConsecutive(nums));
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
        int maxStarting = 0;

        for (int key: keys) {

            if ((map.get(key))) {
                int count = 0;

                while (map.containsKey(key + count)) {
                    count++;
                }

                if (count > maxLength) {
                    maxLength = count;
                    maxStarting = key;
                }
            }
        }
        return maxLength;
    }

}
