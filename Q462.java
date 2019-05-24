package leetcode;

import java.util.Arrays;

/**
 * 最少移动次数使数组元素相等II
 *
 * @author yx
 * @create 2019-05-24  19:24
 **/
public class Q462 {
    //中位数
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int res = 0;
        while(start<end){
            res += nums[end]-nums[start];
            start++;
            end--;
        }
        return res;
    }
}
