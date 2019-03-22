package leetcode;

import java.util.Arrays;
//组合总数IV
public class Q377 {
    //执行用时: 3 ms, 在Combination Sum IV的Java提交中击败了61.00% 的用户
    //内存消耗: 19.6 MB, 在Combination Sum IV的Java提交中击败了65.15% 的用户

    //使用一个数组dp存储和小于target的组合的总数
    //计算和为target的组合数时，遍历Nums数组dp[target] += dp[target-nums[j]]
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for(int i=1 ; i<=target ; i++){
            for(int j=0 ; j<len ; j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}
