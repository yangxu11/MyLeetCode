package leetcode;

/**
 * 买卖股票的最佳时机II
 *
 * @author yx
 * @create 2019-03-29  20:50
 **/
public class Q122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length<2) return 0;
        for(int i=1 ; i<prices.length ; i++){
            if(prices[i]>prices[i-1]){
                res += prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
