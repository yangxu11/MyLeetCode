package leetcode;

public class Q643 {
    public static void main(String[] args) {
        Q643 q = new Q643();
        int[] a = {9,7,3,5,6,2,0,8,1,9};
        System.out.println(q.findMaxAverage1(a,6));
    }
    //12ms 94%
    // 滑动窗口，先算总和最大
    // 减去前一个值，加上后一个值，判断其是否为当前最大
    //最后算平均值
    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        for(int i=0 ; i<k ; i++){
            sum += nums[i];
        }
        int result = sum;
        for(int i=0 ; i<nums.length-k ; i++){
            sum -= nums[i];
            sum += nums[i+k];
            result = Math.max(sum,result);
        }
        result = Math.max(sum,result);

        return ((double)result)/k;
    }
    //暴力解法  2000ms 3%
    public double findMaxAverage2(int[] nums, int k) {
        double result = (double)Integer.MIN_VALUE;
        for(int i=0 ; i<nums.length-k+1 ; i++){
            double sum = 0;
            for(int j=i ; j<k+i ; j++){
                sum += nums[j];
            }
            double average = sum/k;
            result = Math.max(result,average);
        }
        return result;
    }
}
