package leetcode;
//使用最小花费爬楼梯
public class Q746 {
    //执行用时: 21 ms, 在Min Cost Climbing Stairs的Java提交中击败了64.56% 的用户
    //内存消耗: 46.4 MB, 在Min Cost Climbing Stairs的Java提交中击败了0.88% 的用户

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2 ; i<=cost.length ; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}
