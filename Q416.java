package leetcode;

import java.util.HashSet;
import java.util.Set;
//分割等和子集
public class Q416 {
//执行用时: 24 ms, 在Partition Equal Subset Sum的Java提交中击败了72.75% 的用户
//内存消耗: 23.9 MB, 在Partition Equal Subset Sum的Java提交中击败了78.18% 的用户

    //建立数组dp存储所有可能的和，如果出现sum/2为true
    public boolean canPartition1(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 != 0) return false;

        boolean[] dp = new boolean[sum+1];
        dp[0]= true;
        for(int i=0 ; i<len ; i++){
            for(int j=sum ; j>=0 ; j--){
                if(dp[j]){
                    dp[j+nums[i]] = true;
                }
            }
            if (dp[sum / 2])
                return true;
        }

        return false;
    }
    //执行用时: 171 ms, 在Partition Equal Subset Sum的Java提交中击败了2.81% 的用户
    //内存消耗: 27.7 MB, 在Partition Equal Subset Sum的Java提交中击败了40.00% 的用户
    public boolean canPartition(int[] nums) {
        int len = nums.length;

        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum%2 != 0) return false;
        int target = sum/2;

        Set<Integer> dp = new HashSet<>();
        if(target == nums[0]) return true;
        dp.add(0);

        for(int i=0 ; i<len ; i++){
            Set<Integer> list = new HashSet<>(dp);
            for(int num : dp){
                if(num + nums[i]==target){
                    return true;
                } else {
                    list.add(num+nums[i]);
                }
            }
            dp = list;
        }

        return false;
    }
}
