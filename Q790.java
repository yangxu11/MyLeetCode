package leetcode;
//多米诺和托米诺平铺
public class Q790 {
    //执行用时: 4 ms, 在Domino and Tromino Tiling的Java提交中击败了82.76% 的用户
    //内存消耗: 36.1 MB, 在Domino and Tromino Tiling的Java提交中击败了0.00% 的用户

    //找规律
    public int numTilings(int N) {
        int[] dp = new int[N + 5];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        for (int i = 4; i <= N; ++i) {
            dp[i] = (2 * dp[i - 1]%1000000007 + dp[i - 3])%1000000007;
        }

        return dp[N];
    }
    //从最后一列数
    //最后一列为单独 竖排  有dp[i-1]中
    //最后两列为两个横排叠加,有dp[i-2]种
    //此后首尾为托米诺，有2*dp[i-x](x>=3)中
    public int numTilings2(int N) {
        if(N==1) return 1;
        int[] dp = new int[N+1];
        dp[1] = 1;
        if(N==2) return 2;

        dp[2] = 2;
        int mod = 1000000007;

        for(int i=3 ; i<=N ; i++){
            dp[i] = (dp[i-1] + dp[i-2])%mod;
            for(int j=i-3 ; j>=1 ; j--){
                dp[i] = (dp[i]+2*dp[j]%mod)%mod;
            }
            dp[i] += 2;
        }
        return dp[N];
    }
}
