package leetcode;
//新21点
public class Q837 {
    //执行用时: 17 ms, 在New 21 Game的Java提交中击败了62.96% 的用户
    //内存消耗: 38.6 MB, 在New 21 Game的Java提交中击败了0.00% 的用户

    //使用动态规划，dp[i]表示得到点数i的概率，只有当现在的总点数少于K的时候，才会继续取数。那么状态转移方程可以写成：
    //
    //当i <= K时，dp[i] = （前W个dp的和）/ W；(爬楼梯得到总楼梯数为i的概率）

    //当K < i < K + W时，那么在这次的前一次的点数范围是[i - W, K - 1]。
    // 我们的dp数组表示的是得到点i的概率，所以dp[i]=(dp[K-1]+dp[K-2]+…+dp[i-W])/W.（可以从前一次的基础的上选[1,W]个数字中的一个）

    //当i>=K+W时，这种情况下无论如何不都应该存在的，所以dp[i]=0.

    public double new21Game1(int N, int K, int W) {
        if (K == 0 || N >= (K + W)) return 1.0;
        double dp[] = new double[N+1];
        double res = 0.0;
        double sum = 0.0;
        for (int i = 1; i <= N; i++) {
            dp[i] = i <= W ? sum / W + 1.0 / W : sum/W;
            if (i < K) sum += dp[i];
            if (i > W) sum -= dp[i - W];
            if (i >= K) res += dp[i];
        }
        return res;
    }
    //执行用时: 724 ms, 在New 21 Game的Java提交中击败了3.70% 的用户
    //内存消耗: 37.8 MB, 在New 21 Game的Java提交中击败了0.00% 的用户

    //先计算一步能超出范围的点数的概率
    //然后计算这些一步超出的概率总和，1-，得到结果
    public double new21Game(int N, int K, int W) {
        if(K==0) return 1;
        double[] dp = new double[K];
        double step = 1*1.0/W;
        dp[0] = 1;
        //dp[1] = step;
        for(int i=1 ; i<K ; i++){
            for(int j=i-1 ; j>=0 && j>=i-W ; j--){
                dp[i] += dp[j]*step;
            }
        }
        double res = 0;
        for(int i=K-1 ; i>=N-W && i>=0 ; i--){
            res += (i+W-N)*dp[i]*step;
        }
        return 1-res;
    }
}
