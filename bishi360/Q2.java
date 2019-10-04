package leetcode.bishi360;

/**
 * 2
 *
 * @author yx
 * @create 2019-09-26  23:10
 **/
public class Q2 {
    public static void main(String[] args) {
        //int[] nums = {}
    }
    public static double getMaxAvg(int[] nums,int M,int N){
        int sum = nums[0];
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = sum;

        for(int i=1 ; i<len ; i++){
            if(sum>0){
                sum += nums[i];
            } else{
                sum = nums[i];
            }
            dp[i+1] = sum;
        }
        sum = 0;
        for(int i=0 ; i<M ; i++){
            sum += nums[i];
        }
        int max = Integer.MIN_VALUE;

        for(int i=M ; i<len ; i++){
            sum -= nums[i-M];
            sum += nums[i];
            max = Math.max(sum+dp[i-M],max);
        }

        return max/(M*1.0);
    }
}
