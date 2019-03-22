package leetcode;
//最长回文子序列
public class Q516 {
    //执行用时: 41 ms, 在Longest Palindromic Subsequence的Java提交中击败了81.64% 的用户
    //内存消耗: 37.7 MB, 在Longest Palindromic Subsequence的Java提交中击败了62.50% 的用户

    //建立数组DP[][] 存储i - j之间最长回文子序列的长度
    //dp[i][j]的长度，如果char[i] == char[j] dp[i][j] = dp[i+1][j-1]+2
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int[][] dp = new int[length][length];


        for (int i = length-1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i+1; j < length; j++){
                if (chars[i] == chars[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }

            }
        }

        return dp[0][length-1];
    }
}
