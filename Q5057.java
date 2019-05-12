package leetcode;

/**
 * 分隔数组得到最大值
 *
 * @author yx
 * @create 2019-05-12  11:33
 **/
public class Q5057 {
    public static void main(String[] args) {
        int[] a = {1,15,7,9,2,5,10};
        Q5057 q = new Q5057();
        System.out.println(q.maxSumAfterPartitioning(a,3));
    }
    public int maxSumAfterPartitioning(int[] A, int K) {
        int x = A.length % K;
        int len = A.length/K;
        int[] dp = new int[len+1];
        int sum = 0;
        int index = 0;
        for(int i=0 ; i<A.length ; i+=K){
            int max= Integer.MIN_VALUE;
            for(int j=i ; j<i+K && j<A.length ; j++){
                max = Math.max(A[j],max);
            }

            if(i+K >= A.length){
                sum += max * x;
                dp[index++] = max*x;
            } else{
                sum += max * K;
                dp[index++] = max*K;
            }

        }
        if(x==0) return sum;
        index--;
        int res = sum;
        for(int i=A.length-x-K ; i>=0 ; i-=K){
            int max1= Integer.MIN_VALUE;
            for(int j=i ; j<i+x ; j++){
                max1 = Math.max(max1,A[j]);
            }
            int sum1 = max1*x;
            int max2= Integer.MIN_VALUE;
            for(int j=i+x ; j<i+x+K ; j++){
                max2 = Math.max(max2,A[j]);
            }
            int sum2 = max2*K;
            sum = sum - dp[index]-dp[index-1] + sum1 + sum2;

            dp[index] = sum2;
            dp[--index] = sum1;
            res = Math.max(res,sum);
        }
        return res;

    }
}
