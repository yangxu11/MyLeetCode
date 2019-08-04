package leetcode;

import java.util.Arrays;

/**
 * 锯齿数组
 *
 * @author yx
 * @create 2019-08-04  11:19
 **/
public class Q5147 {
    public static void main(String[] args) {
        int[] a = {7,4,8,9,7,7,5};
        System.out.println(movesToMakeZigzag(a));
    }
    public static int movesToMakeZigzag(int[] nums) {
        int res = Integer.MAX_VALUE;

        int[] copy = Arrays.copyOf(nums,nums.length);
        int x1=0;
        for(int i=0 ; i<nums.length ; i+=2){
            if(i==0){
                if(nums[0]<=nums[1]){
                    x1 += nums[1]-nums[0]+1;
                    nums[1] = nums[0]-1;
                }
            } else if(i==nums.length-1){
                if(nums[i]<=nums[i-1]){
                    x1 += nums[i-1]-nums[i]+1;
                    nums[i-1] = nums[i]-1;
                }
            } else{
                if(nums[i]<=nums[i-1]){
                    x1 += nums[i-1]-nums[i]+1;
                    nums[i-1] = nums[i]-1;
                }
                if(nums[i]<=nums[i+1]){
                    x1 += nums[i+1]-nums[i]+1;
                    nums[i+1] = nums[i-1];
                }
            }
        }
        int x2=0;
        for(int i=1 ; i<nums.length ; i+=2){
            if(i==copy.length-1){
                if(copy[i]<=copy[i-1]){
                    x2 += copy[i-1]-copy[i]+1;
                    copy[i-1] = copy[i]-1;
                }
            } else{
                if(copy[i]<=copy[i-1]){
                    x2 += copy[i-1]-copy[i]+1;
                    copy[i-1] = copy[i]-1;

                }
                if(copy[i]<=copy[i+1]){
                    x2 += copy[i+1]-copy[i]+1;
                    copy[i+1] = copy[i]-1;
                }
            }
        }

        return Math.min(x1,x2);
    }
}
