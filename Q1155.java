package leetcode;

/**
 * 掷骰子的方法
 *
 * @author yx
 * @create 2019-08-11  12:05
 **/
public class Q1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d][target + 1];
        final int mod = 1000000007;
        for(int i = 1; i <= f && i <= target; i++)
            dp[0][i] = 1;
        for(int i = 1; i < d; i++){
            for(int j = 0; j <= target; j++){
                if(dp[i - 1][j] == 0)
                    continue;
                for(int k = 1; k <= f && j + k <= target; k++){
                    dp[i][j + k] += dp[i-1][j];
                    dp[i][j + k] %= mod;
                }
            }
        }
        return dp[d-1][target];
    }
}
