package leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱数组
 *
 * @author yx
 * @create 2019-05-01  10:59
 **/
public class Q384 {
    int[] nums;
    Random random;

    public Q384(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = Arrays.copyOf(nums,nums.length);
        for(int i=1 ; i<nums.length ; i++){
            int n = random.nextInt(i+1);
            int tmp = res[i];
            res[i] = res[n];
            res[n] = tmp;
        }
        return res;
    }
}
