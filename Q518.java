package leetcode;

/**
 * 零钱兑换II
 *
 * @author yx
 * @create 2019-06-05  19:38
 **/
public class Q518 {
    //完全背包问题
    //二层遍历要从头至尾遍历，因为元素可以无限重复
    public int change(int amount, int[] coins) {
        if(amount==0) return 1;
        if(coins.length==0) return 0;
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i=0 ; i<coins.length ; i++){
            for(int j=coins[i] ; j<=amount ; j++){
                dp[j] += dp[j-coins[i]];
            }
        }

        return dp[amount];
    }



}
