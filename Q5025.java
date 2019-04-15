package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长的等差数列
 *
 * @author yx
 * @create 2019-04-14  11:47
 **/
public class Q5025 {
    public static void main(String[] args) {
        int[] a = new int[]{3,3,3,3};
        Q5025 q = new Q5025();
        System.out.println(q.longestArithSeqLength(a));
    }
    public int longestArithSeqLength(int[] A) {
        int len = A.length;
        int res = 1;
        Map<Integer,Integer>[] dp = new HashMap[len];

        for(int i=0 ; i<len ; i++){
            dp[i] = new HashMap<>();
            for(int j=i-1 ; j>=0 ; j--){
                if(dp[j].containsKey(A[i]-A[j])){
                    dp[i].put(A[i]-A[j],Math.max(dp[i].getOrDefault(A[i]-A[j],0),dp[j].get(A[i]-A[j])+1));
                } else{
                    dp[i].put(A[i]-A[j],Math.max(dp[i].getOrDefault(A[i]-A[j],0),1));
                }
                res = Math.max(dp[i].get(A[i]-A[j]),res);
            }
        }
        return res+1;

    }
}
