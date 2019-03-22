package leetcode;

import java.util.Arrays;

//有效三角形的个数
public class Q611 {
    //128ms 38%
    //暴力解法
    //先排序，遍历寻找前两个的和，然后判断第三个是否<前两个之和
    public int triangleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length-2 ; i++){
            for(int j=i+1 ; j<nums.length-1 ; j++){
                int sum = nums[i] + nums[j];
                for(int k=j+1 ; k<nums.length ; k++){
                    if(sum>nums[k]){
                        result++;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
