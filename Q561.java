package leetcode;

import java.util.Arrays;
//数组拆分I
public class Q561 {
    //41ms 51%
    //先将数组排序，取奇数位加和
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length ; i+=2){
            result += nums[i];
        }
        return result;
    }
}
