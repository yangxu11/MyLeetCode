package leetcode.tecent;

import java.util.Arrays;

/**
 * 1
 *
 * @author yx
 * @create 2019-09-01  19:39
 **/
public class Q1 {
    public static void main(String[] args) {
        Q1 q = new Q1();
        System.out.println(q.f(3,4));
    }

    public int getNum(int[] nums,int k){
        int len = nums.length;
        int totalLen = nums[len-1];

        int[] dp = new int[totalLen];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        return 0;
    }

    int f(int target,int N){
        int[][] dp = new int[N][target+1];
        Arrays.fill(dp[0],1);
        for(int i=1 ; i<N ; i++){
            for(int j=0 ; j<=target ; j++){
                for(int k=0 ; k<=target && j-k>=0 ; k++){
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        return dp[N-1][target];
    }
}
