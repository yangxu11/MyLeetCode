package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//三数之和
public class Q15 {
    //44% 先排序（方便跳过重复元素），遍历数组，以当前数组值的相反数为和，向后寻找两数之和
    //寻找两数之和时，使用双指针，如果>target end-- ,<target start++,如果相同记录下来，继续，注意跳过重复项
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length-2 ; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+nums[start]+nums[end];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[start],nums[end]));
                    start++;
                    end--;
                    while(start<end && nums[start]==nums[start-1]){//跳过重复项
                        start++;
                    }
                    while(start<end && nums[end]==nums[end+1]){
                        end--;
                    }
                }else if(sum<0){
                    start++;
                    while(start<end && nums[start]==nums[start-1]){//跳过重复项
                        start++;
                    }

                } else {
                    end--;
                    while(start<end && nums[end]==nums[end+1]){//跳过重复项
                        end--;
                    }
                }
            }
        }
        return res;
    }
}
