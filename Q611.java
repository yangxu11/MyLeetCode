package leetcode;

import java.util.Arrays;

//有效三角形的个数
public class Q611 {
    public int triangleNumber(int[] nums) {
        if(nums.length<3) return 0;

        Arrays.sort(nums);

        int res = 0;

        for(int i=nums.length-1 ; i>=2 ; i--){
            int start = 0;
            int end = i-1;
            while(start<end){
                if(nums[start]+nums[end]>nums[i]){
                    res += end-start;
                    end--;
                } else{
                    start++;
                }
            }
        }

        return res;
    }
}
