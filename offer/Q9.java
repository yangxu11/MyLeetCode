package leetcode.offer;

/**
 * 变态跳台阶
 *
 * @author yx
 * @create 2019-05-03  11:36
 **/
public class Q9 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int i=1 ; i<=target ; i++){
            for(int j=i-1 ; j>=0 ; j--){
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
