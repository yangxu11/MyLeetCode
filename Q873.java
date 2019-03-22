package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//最长的斐波那契子序列的长度
public class Q873 {

    //执行用时: 44 ms, 在Length of Longest Fibonacci Subsequence的Java提交中击败了99.09% 的用户
    //内存消耗: 37.6 MB, 在Length of Longest Fibonacci Subsequence的Java提交中击败了56.86% 的用户

    //dp[i][j]表示以A[i]、A[j]结尾的子序列的最大斐波那契数列长度
    //遍历到n时，在1~n-1中寻找A[i]+A[j] = A[n] 如果有dp[j][n] = Math.max(dp[r][i], dp[l][r] + 1)
    public int lenLongestFibSubseq1(int[] A) {
        int n = A.length;
        int res = 0, sum;
        int[][] dp = new int[n][n];
        //dp[i][j]表示以A[i]、A[j]结尾的子序列的最大斐波那契数列长度
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 2);
        }
        int l = 0, r = 0;
        for(int i  = 1; i < n; i++) {
            l = 0;
            r = i - 1;
            while(l < r) {
                sum = A[l] + A[r];
                if(sum == A[i]) {
                    dp[r][i] = Math.max(dp[r][i], dp[l][r] + 1);
                    res = Math.max(dp[r][i], res);
                    l++;
                    r--;
                }else if(sum < A[i]) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
    //超时答案
    //dp[]来存储map,使用map存储当前数可构成斐波那契数列的前一个数和该数列的长度map<prenum,length>
    //遍历A，遍历A之前的值A[j]，查找A[j]对应的dp[j]是否有 prenum = A[i]-A[j],如果有dp[i]的map.put(A[j],dp[j].get(A[i]-A[j])+1)
    //注意不管能否构成，A[i]和之前的任意A[j]都要put
    public int lenLongestFibSubseq(int[] A) {
        Map<Integer,Integer>[] dp = new HashMap[A.length];
        dp[1] = new HashMap<>();
        dp[1].put(A[0],2);
        int max = 0;

        for(int i=2 ; i<A.length ; i++){
            dp[i] = new HashMap<>();
            for(int j=i-1 ; j>0 ; j--){
                Map<Integer,Integer> map = dp[j];
                for(int key : map.keySet()){
                    if(key == A[i] - A[j]){
                        dp[i].put(A[j],map.get(key) + 1);
                        max = Math.max(map.get(key) + 1,max);
                    }
                }
                dp[i].put(A[j],Math.max(dp[i].getOrDefault(A[j],0),2));
            }
            dp[i].put(A[0],2);
        }

        return max;
    }
}
