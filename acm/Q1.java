package leetcode.acm;

/**
 * 长度不小于K的最大连续子序列和
 *
 * @author yx
 * @create 2019-09-27  10:38
 **/
public class Q1 {

    public static void main(String[] args) {
        Q1 q = new Q1();
        int[] nums = {6,4,2,10,3,8,5,9,4,1};
        System.out.println(q.getMaxAvg(nums,6));
    }

    public int getMaxSum(int[] nums,int K){
        int len = nums.length;
        int[] sum = new int[len+1];
        sum[0] = nums[0];
        for(int i=1 ; i<=len ; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        int max = sum[1];
        int min = Integer.MAX_VALUE;
        for(int i=K ; i<=len ; i++){
            min = Math.min(min,sum[i-K]);
            max = Math.max(max,sum[i]-min);
        }

        return max;
    }

    /* 长度不小于K的最大连续子数组的平均值
     * @Author YX
     * @Description
     * @Date 10:54 2019/9/27
     * @Param
     * @return
     **/

    public double getMaxAvg(int[] nums,int K){
        double exps = 1e-5;
        double r = 1e6;
        double l = -1e6;
        int len = nums.length;
        while(r-l>exps){
            double mid = (l+r)/2;

            double[] sum = new double[len+1];

            double[] b = new double[len+1];
            for(int i=1 ; i<=len ; i++){
                b[i] = nums[i-1]-mid;
            }
            for(int i=1 ; i<=len ; i++){
                sum[i] = sum[i-1]+b[i];
            }
            double max = sum[1];
            double min = Double.MAX_VALUE;
            for(int i=K ; i<=len ; i++){
                min = Math.min(min,sum[i-K]);
                max = Math.max(max,sum[i]-min);
            }
            if(max>=0){
                l = mid;
            } else{
                r = mid;
            }
        }
        System.out.println(String.format("%.3f",r));
        return r;
    }

}
