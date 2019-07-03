package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Q646 {

    public int findLongestChain(int[][] pairs) {
        int res = 1;

        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]==b[0] ? a[1]-b[1] : a[0]-b[0];
            }
        };

        Arrays.sort(pairs,comp);
        int len = pairs.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);

        for(int i=0 ; i<len ; i++){
            for(int j=i-1 ; j>=0 ; j--){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                    break;
                }
            }
        }
        return dp[len-1];
    }
}
