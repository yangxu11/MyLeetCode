package leetcode;
//石子游戏
public class Q877 {
    //我们每次只能拿两端的石头堆的石头，但我们又不知道拿完后剩下的石头堆的情况，
    // 因此我们考虑先解决子问题。例如我们求出2个相邻石头堆的胜负情况，
    // 我们可以根据求出的数据求出相邻3个石头堆的胜负情况，
    // 以此类推，我们可以根据n-1个相邻石头堆的胜负情况，求出n个相邻石头堆的胜负情况，即我们的原问题。
    //根据我们的类推我们可以设dp[i][j]为piles[i]~piles[j] Alex最多可以赢Lee的分数。
    // 每次取石头堆只能从两端取，因此:dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])。
    // 其中piles[i] - dp[i+1][j]表示Alex取走i上的石头堆，piles[j] - dp[i][j-1]表示Alex取走的是j上的石头堆。
    // 注意，为什么dp[i+1][j]表示piles[i+1]~piles[j]之间Alex最多可以赢Lee的分数，而piles[i]要减去该值而不是加上该值呢？
    // 由于我们的要求是每一步Alex和Lee采取的都是最优策略，当取piles[i]时，piles[i+1]~piles[j]中Alex和Lee的走法会调换。
    // 意即Lee走Alex的走法，Alex走Lee的走法，因此这里要做减法。
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[][] al = new int[len][len];

        for(int i = 0;i < len;i++) al[i][i] = piles[i];
        for(int d = 1;d < len;d++){
            for(int i = 0;i+d< len ;i++){
                al[i][i+d] = Math.max(piles[i]-al[i+1][i+d],piles[i+d]-al[i][i+d-1]);
            }
        }
        return al[0][len-1]>0;
    }
}
