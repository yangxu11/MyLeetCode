package leetcode.offer;

/**
 * 丑数
 *
 * @author yx
 * @create 2019-05-06  20:20
 **/
public class Q33 {
    public int GetUglyNumber_Solution(int index) {
        if(index<=1) return index;
        int[] dp = new int[index];
        dp[0] = 1;
        int num2 = 2;
        int num3 = 3;
        int num5 = 5;
        int index2=0,index3=0,index5=0;

        for(int i=1 ; i<index ; i++){
            int min = Math.min(num2,Math.min(num3,num5));
            dp[i] = min;
            if(min == num2){
                num2 = 2*dp[++index2];
            }
            if(min == num3){
                num3 = 3*dp[++index3];
            }
            if(min == num5){
                num5 = 5*dp[++index5];
            }
        }
        return dp[index-1];
    }
}
