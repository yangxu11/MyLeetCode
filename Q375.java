package leetcode;
//猜数字大小 II
public class Q375 {
    //执行用时: 17 ms, 在Guess Number Higher or Lower II的Java提交中击败了53.90% 的用户
    //内存消耗: 18.6 MB, 在Guess Number Higher or Lower II的Java提交中击败了100.00% 的用户

    //dp[i][j]表示从[i,j]中猜出正确数字所需要的最少花费金额.(dp[i][i] = 0)
    // 假设在范围[i,j]中选择k, 则选择x的最少花费金额为: max(dp[i][x-1], dp[x+1][j]) + k
    // 用max的原因是我们要计算最坏反馈情况下的最少花费金额(选了x之后, 正确数字落在花费更高的那侧)
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int j=2;j<=n;j++){
            for(int i=j-1;i>=1;i--){
                int global_min = Integer.MAX_VALUE;
                for(int k=i+1;k<j;k++){
                    int max = k + Math.max(dp[i][k-1],dp[k+1][j]);
                    global_min = Math.min(global_min,max);
                }
                dp[i][j] = i+1 == j ? i : global_min;
            }
        }
        return dp[1][n];
    }
}
