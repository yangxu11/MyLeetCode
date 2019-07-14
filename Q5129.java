package leetcode;

/**
 * b表现良好的最长时间段
 *
 * @author yx
 * @create 2019-07-14  11:57
 **/
public class Q5129 {
    public int longestWPI(int[] hours) {
        int res = 0;
        int len = hours.length;

        int[] dp = new int[len];
        dp[0] = hours[0]>8 ? 1 : 0;
        for(int i=1 ; i<len ; i++){
            if(hours[i]>8){
                dp[i] = dp[i-1]+1;
            } else{
                dp[i] = dp[i-1];
            }
        }
        for(int i=0 ; i<len ; i++){
            if(len-i<res){
                break;
            }
            if(i==0){
                for(int j=len-1 ; j>=0 ; j--){
                    if(dp[j]>(j+1)/2){
                        res = Math.max(res,j+1);
                    }
                }
            }else{
                for(int j=len-1 ; j>=i ; j--){
                    if((dp[j]-dp[i-1] > (j-i+1)/2)){
                        res = Math.max(res,j-i+1);
                    }
                }
            }

        }
        return res;
    }
}
