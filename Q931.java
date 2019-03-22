package leetcode;
//下降路径最小和
public class Q931 {
    //执行用时: 9 ms, 在Minimum Falling Path Sum的Java提交中击败了72.99% 的用户
    //内存消耗: 43.9 MB, 在Minimum Falling Path Sum的Java提交中击败了0.00% 的用户

    //使用数组dp存储上一层到达该点的最小路径和
    //则当前点的最小路径和 = Math.min(dp[i-1],dp[i],dp[i+1]) + a[i]
    public int minFallingPathSum(int[][] A) {
        int[] dp = new int[A.length];
        dp = A[0];
        for(int i=1 ; i<A.length ; i++){
            int[] a = A[i];
            int[] temp = new int[A.length];
            temp[0] = Math.min(dp[0],dp[1])+a[0];
            temp[A.length-1] = Math.min(dp[A.length-1],dp[A.length-1])+a[A.length-1];
            for(int j=1 ; j<A.length-1 ; j++){
                temp[j] = Math.min(dp[j-1],Math.min(dp[j],dp[j+1]))+a[j];
            }
            dp = temp;
        }
        return getMin(dp);
    }
    public int getMin(int[] a){
        int min = Integer.MAX_VALUE;
        for(int num : a){
            if(num<min){
                min = num;
            }
        }
        return  min;
    }
}
