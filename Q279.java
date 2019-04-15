package leetcode;
//完全平方数
public class Q279 {
    //执行用时: 46 ms, 在Perfect Squares的Java提交中击败了51.20% 的用户
    //内存消耗: 21 MB, 在Perfect Squares的Java提交中击败了86.76% 的用户

    //动态规划，建立数组存储n之前所有数字的最小的平方数个数
    //计算n时，比较n去掉一个<n的平方数剩余数字的平方数个数，取其最小值，比如1，n-1  1+result[n-1] ; 4, n-4  1+result[n-4]
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2 ; i<=n ; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=1 ; j*j<=i ; j++){
                dp[i] = Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[n];
    }
}
