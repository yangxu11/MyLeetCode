package leetcode;
//一和零
public class Q474 {
    //执行用时: 32 ms, 在Ones and Zeroes的Java提交中击败了77.32% 的用户
    //内存消耗: 22.8 MB, 在Ones and Zeroes的Java提交中击败了65.00% 的用户

    //建立数组dp存储x个0和y个1（x<=m  y<=n）所能组成的最多字符串
    //dp[m][n] = max(max,dp[m-zeros][n-ones]+1)
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int zeros, ones;
        // dp[i][j]代表遍历到当前字符串时使用i个0和j个1所能组成的最大字符串数量
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < l ; i++){
            zeros = 0;
            ones = 0;
            for(int j = 0; j < strs[i].length(); j++){
                if(strs[i].charAt(j) == '0'){
                    zeros++;
                }else{
                    ones++;
                }
            }
            for(int j = m; j >= zeros; j--){
                for(int k = n; k >= ones; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeros][k-ones] + 1);
                }
            }
        }
        return dp[m][n];

    }
}
