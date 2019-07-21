package leetcode;

/**
 * 寻找数组的中心索引
 *
 * @author yx
 * @create 2019-07-21  16:24
 **/
public class Q724 {
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        if(nums.length==1) return 0;

        int sum = 0;
        int[] dp = new int[nums.length];

        for(int i=nums.length-1 ; i>=0 ; i--){
            dp[i] = sum;
            sum += nums[i];
        }

        sum = 0;

        for(int i=0 ; i<nums.length ; i++){
            if(sum == dp[i]){
                return i;
            }
            sum+=nums[i];
        }

        return -1;
    }
}
