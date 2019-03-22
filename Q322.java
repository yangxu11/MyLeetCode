package leetcode;

import java.util.*;

//零钱兑换
public class Q322 {
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
    //超时答案
    //思路：同Q139  单词拆分
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        List<Integer> list = new ArrayList<>();
        for(int i : coins){
            list.add(i);
        }

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);

        for(int i=1 ; i<=amount ; i++){
            int min=Integer.MAX_VALUE;
            for(Integer key : map.keySet()){
                if(list.contains(i-key)){
                    min = Math.min(min,map.get(key)+1);
                }
            }
            if(min != Integer.MAX_VALUE){
                map.put(i,min);
            }
        }
        return map.containsKey(amount) ? map.get(amount) : -1;
    }

}
