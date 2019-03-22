package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q646 {
    //执行用时: 45 ms, 在Maximum Length of Pair Chain的Java提交中击败了84.14% 的用户
    //内存消耗: 49.4 MB, 在Maximum Length of Pair Chain的Java提交中击败了0.00% 的用户

    //先将二维数组按第一个数升序排序
    //建立数组dp[]来存储长度为n的数对链的结尾最小值，
    //遍历每个数对,如果数对起始pair[0]>dp[n],比较dp[n+1]和pair[1],如果pair[1] < dp[n+1] 说明长度为n+1的数对链的末尾要更换为更小的值
    public int findLongestChain(int[][] pairs) {
        int res = 1;
        if(pairs.length<=1) return pairs.length;
        Comparator<int[]> comp = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]>o2[0] ? 1 : (o1[0]==o2[0] ? 0 : -1);
            }
        };
        Arrays.sort(pairs,comp);
        int[] dp = new int[pairs.length+1];
        dp[0] = Integer.MIN_VALUE;
        dp[1] = pairs[0][1];
        for(int[] pair : pairs){
            if(pair[0]>dp[res]) {
                dp[++res] = pair[1];
                continue;
            }
            for(int i=res-1 ; i>=0 ; i--){
                if(pair[0] > dp[i]){
                    if(pair[1] < dp[i+1]){
                        dp[i+1] = pair[1];
                    }
                }
            }
        }

        return res;
    }
}
