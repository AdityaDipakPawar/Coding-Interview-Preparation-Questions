public class firstMissingPositive {
    public static void main(String[] args) {
    int[] nums = {1,2,0};
        System.out.println(firstMissingPositive1(nums));
        System.out.println(firstMissingPositive2(nums));
    }

    public static int firstMissingPositive1(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i++;
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index + 1) {
                return index + 1;
            }
        }

        return nums.length + 1;
    }

    public static void swap(int[] arr, int first, int last) {
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }


    public static int firstMissingPositive2(int[] nums) {
        int n = nums.length;
        int contains = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains++;
            }
        }

        if (contains == 0) {
            return 1;
        }

        for (int i = 0; i < n; i++) {

            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);

            if ( a == n) {
                nums[0] = - Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) {
            return n;
        }

        return n + 1;
    }
}
