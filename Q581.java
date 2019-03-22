package leetcode;

import java.util.Arrays;
//最短无序连续子数组
public class Q581 {
    //25ms 74%
    //排好序，新旧数组对照，找出首尾第一个出现不同的数字
    public int findUnsortedSubarray(int[] nums) {
        int[] pre = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++){
            pre[i] = nums[i];
        }
        Arrays.sort(nums);
        int start=10000;
        int end=10000;
        for(int i=0 ; i<nums.length ; i++){
            if(nums[i]!=pre[i]){
                start=i;
                break;
            }
        }
        for(int i=nums.length-1 ; i>=0 ; i--){
            if(nums[i]!=pre[i]){
                end=i;
                break;
            }
        }

        return end==10000 ? 0 : end-start+1;
    }
}
