package leetcode;
//买卖股票的最佳时机
public class Q121 {
    //2ms 88%
    //优先更新最小值
    //比较输出最大差值
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int min = prices[0];
        int result = 0;

        for(int i=0 ; i<prices.length ; i++){
            if(prices[i] <= min ){
                min = prices[i];
            } else {
                result = Math.max(prices[i]-min,result);
            }
        }
        return result;
    }
}
