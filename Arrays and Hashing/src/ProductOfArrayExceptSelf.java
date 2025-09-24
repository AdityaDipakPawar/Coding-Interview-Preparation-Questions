//LC Q no 238


import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf1(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

    public static int[] productExceptSelf1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int[] ans = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];

        // First pass: store left products in result array
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        // Second pass: multiply by right products on the fly
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }
}
