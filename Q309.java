package leetcode;
//最佳买卖股票时机含冷冻期
public class Q309 {
    //执行用时: 16 ms, 在Best Time to Buy and Sell Stock with Cooldown的Java提交中击败了73.31% 的用户
    //内存消耗: 26.4 MB, 在Best Time to Buy and Sell Stock with Cooldown的Java提交中击败了40.47% 的用户

    //思路是先降维，将买、卖、冷冻，降维成两个维度：持有股票和未持有股票。
    // 持有股票：今天买入和之前买入但未卖出
    // 未持有：今天卖出和冷冻期
    // 所以有的传递式： buy[i]=max(buy[i-1],sell[i-2]-prices[i]);
    // 意思是当前持有的股票的最大收益是昨天持有的股票（可能今天并未有任何操作）
    // 和之前卖出的最大收益-今天买入的(i-2的意思是今天买入的话，昨天就应该是冷冻期)。
    // set[i]=max(sell[i-1],buy[i-1]+prices[i]);
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1)    return 0;
        int len=prices.length;
        int[] sell=new int[len];
        int[] buy=new int[len];
        sell[0]=0;
        buy[0]=-prices[0];
        sell[1]=Math.max(prices[1]-prices[0],sell[0]);
        buy[1]=Math.max(-prices[1],-prices[0]);
        for(int i=2;i<len;i++){
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
        }
        return sell[len-1];
    }
}
