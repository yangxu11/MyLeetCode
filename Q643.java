package leetcode;

public class Q643 {

    // 滑动窗口，先算总和最大
    // 减去前一个值，加上后一个值，判断其是否为当前最大
    //最后算平均值
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0 ; i<k ; i++){
            sum += nums[i];
        }
        int res = sum;
        for(int i=k ; i<nums.length ; i++){
            sum -= nums[i-k];
            sum += nums[i];
            res = Math.max(res,sum);
        }
        return res*1.0/k;
    }
}
