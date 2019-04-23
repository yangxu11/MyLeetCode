package leetcode;

import java.util.*;

//零钱兑换
public class Q322 {

    //贪心，先从最大的面值入手，考虑不同数量的当前最大面值，类似回溯
    private int result;
    public int coinChange(int[] coins, int amount) {
        result = Integer.MAX_VALUE;
        Arrays.sort(coins);
        min(coins,amount,coins.length-1,0);
        return result==Integer.MAX_VALUE ? -1 : result;
    }
    private void min(int[] coins,int left,int pos,int res){
        int coin = coins[pos];
        if(pos==0){
            if(left%coin==0){
                result = Math.min(result,res+left/coin);
            }
        } else{
            for(int i = left/coin ; i>=0 && res+i<result ; i--){
                min(coins,left-i*coin,pos-1,res+i);
            }
        }
    }



    //执行用时: 46 ms, 在Coin Change的Java提交中击败了44.04% 的用户
    //内存消耗: 33.6 MB, 在Coin Change的Java提交中击败了9.42% 的用户

    //建立一个数组存储amount之前的可以组成的数字所需硬币的个数
    //当前dp[amount] =Math.min (dp[amount-coin] + 1,min);
    public int coinChange1(int[] coins, int amount) {
        // 动态规划
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);
                }
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }
}
