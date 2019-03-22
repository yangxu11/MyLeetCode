package leetcode;

import java.util.*;
//四数之和
public class Q18 {
    //56%转化为三数之和
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {//跳过重复项
                continue;
            }
            for(int j=i+1 ; j<nums.length-2 ; j++){
                if(j>=i+2 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i],nums[j], nums[left], nums[right]));

                        while (left + 1 < right && nums[left] == nums[left + 1]) {//跳过重复项
                            left++;
                        }

                        while (right - 1 > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
