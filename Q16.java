package leetcode;

import java.util.Arrays;
//最接近的三数之和
public class Q16 {
    //75% 与三数之和类似，先将数组排序（便于跳过重复值），
    //从头开始遍历，取当前数为第一个数，遍历这个数之后的数组，取另外两个数
    //另外两个数使用双指针，如果之和>target end-- （跳过重复）， 如果<target start++（跳过重复）,如果差值为当前最小，更新它
    public int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0 ; i<nums.length-2 ; i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(Math.abs(nums[end]+nums[start]+nums[i]-target)<diff){//更新最小差值
                    result = nums[end]+nums[start]+nums[i];
                    diff = Math.abs(nums[end]+nums[start]+nums[i]-target);
                    if(diff==0) return target;
                }
                if(nums[end]+nums[start]+nums[i] > target){
                    end--;
                    while(start<end && nums[end+1]==nums[end]){//跳过重复值
                        end--;
                    }
                } else {
                    start++;
                    while(start<end && nums[start-1]==nums[start]){//跳过重复值
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
