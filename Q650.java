package leetcode;
//只有两个键的键盘
public class Q650 {
//执行用时: 10 ms, 在2 Keys Keyboard的Java提交中击败了73.79% 的用户
//内存消耗: 36.2 MB, 在2 Keys Keyboard的Java提交中击败了2.27% 的用户

    //n对应的最小值为其因式分解的所有值之和（除去1和n），如果n为素数,return n
    public int minSteps1(int n) {
        if(n == 1)
            return 0;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0)
                return i + minSteps1(n / i);
        }
        return n;
    }

    //执行用时: 66 ms, 在2 Keys Keyboard的Java提交中击败了8.06% 的用户
    //内存消耗: 37.1 MB, 在2 Keys Keyboard的Java提交中击败了2.27% 的用户

    //动态规划
    //建立数组dp存储1~n的最小步数，dp[i]的最小值为 其因式j对应的dp[j] + i/j
    public int minSteps(int n) {
        if(n<=1) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2 ; i<=n ; i++){
            for(int j=i-1 ; j>0 ; j--){
                if(i%j == 0) {
                    dp[i] = Math.min(i,dp[j]+i/j);
                }
            }
        }
        return dp[n];
    }
}
