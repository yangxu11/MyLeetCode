package leetcode;

/**
 * 删除一次得到子数组最大和
 *
 * @author yx
 * @create 2019-09-08  11:07
 **/
public class Q5182 {
    public static void main(String[] args) {
        Q5182 q = new Q5182();
        int[] a = {11,-10,-11,8,7,-6,9,4,11,6,5,0};
        System.out.println(q.maximumSum(a));
    }
    //动态规划
    public int maximumSum(int[] arr) {
        int len = arr.length;
        int[] A = arr;
        int sum = A[0];

        int res = A[0];

        int[] dp1 = new int[len];
        dp1[0] = A[0];

        for(int i=1 ; i<len ; i++){
            if(sum>0){
                sum += A[i];
            } else{
                sum = A[i];
            }
            dp1[i] = sum;
        }

        int[] dp = new int[len];

        dp[0] = dp1[0];
        for(int i=1 ; i<len ; i++){
            if(A[i]<0){
                dp[i] = Math.max(dp[i-1]+A[i],dp1[i-1]);
            } else{
                dp[i] = dp[i-1]+A[i];
            }
            int num = Math.max(dp[i],dp1[i]);
            res = Math.max(res,num);
        }

        return res;

    }
}
