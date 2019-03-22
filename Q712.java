package leetcode;
//两个字符串的最小ASCII删除和
public class Q712 {
    //执行用时: 46 ms, 在Minimum ASCII Delete Sum for Two Strings的Java提交中击败了57.82% 的用户
    //内存消耗: 43.2 MB, 在Minimum ASCII Delete Sum for Two Strings的Java提交中击败了0.00% 的用户

/*
标准的动态规划题目，难点在于想出将两个字符串删除到相同的过程
这里从两个字符串的开头字符考虑，一个一个得考虑到最后一个，我们用二维数组dp[i][j]代表  字符串1前i个字符  和 字符串2前j个字符 实现相同所需要
删除的ASCII value,有三种方法可以到达dp[i][j]:
（1）当 str1[i] != str2[j] 时
1.dp[i-1][j] + str1[i]:由于从dp[i-1][j]到dp[i][j]是多考虑了str1的一个字符，但是str2字符数没变，所以要想相同，必须删除str[i],考虑value的话就是加上str[i]
2.dp[i][j-1] + str1[j]:对应于1，这个是多考虑str2的一个字符，所以要删除str2[j]
dp[i][j] = 两个中的较小值
（2）当 str1[i] == str2[j]时
dp[i][j] = dp[i-1][j-1]
 */
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2= s2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 1; i <= l1; i++)
            dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
        for(int i = 1; i <= l2; i++)
            dp[0][i] = s2.charAt(i-1) + dp[0][i-1];
        for(int i = 1; i <= l1; i++)
            for(int j = 1; j <= l2; j++){
                char c1 = s1.charAt(i-1);
                char c2 = s2.charAt(j-1);
                if(c1 == c2)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j] + c1, dp[i][j-1] + c2);
            }
        return dp[l1][l2];
    }
}
