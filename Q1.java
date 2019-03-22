package leetcode;

import java.util.HashMap;
import java.util.Map;
//两数之和
public class Q1 {
    //一次遍历，先将暂时不符合条件的值放入Map，如果之后出现了符合条件的差值，返回
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
