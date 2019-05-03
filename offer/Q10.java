package leetcode.offer;

/**
 * 矩形覆盖
 *
 * @author yx
 * @create 2019-05-03  11:36
 **/
public class Q10 {
    public int RectCover(int target) {
        if(target==0 || target==1||target==2||target==3) return target;

        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4 ; i<=target ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}
