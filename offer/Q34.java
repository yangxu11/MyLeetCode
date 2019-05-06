package leetcode.offer;

import java.util.Arrays;

/**
 * 第一次只出现一次的字符
 *
 * @author yx
 * @create 2019-05-06  20:36
 **/
public class Q34 {
    public int FirstNotRepeatingChar(String str) {
        int[] nums = new int[128];
        Arrays.fill(nums,-1);
        int res = 10000;
        for(int i=0 ; i<str.length() ; i++){
            int index = str.charAt(i);
            if(nums[index]==10000){
                continue;
            }
            if(nums[index]>=0){
                nums[index] = 10000;
            } else{
                nums[index] = i;
            }
        }
        for(int num : nums){
            if(num>=0){
                res = Math.min(num,res);
            }
        }
        return res == 10000 ? -1 : res;
    }
}
