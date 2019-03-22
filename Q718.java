package leetcode;
//最长重复子数组
public class Q718 {
    //执行用时: 96 ms, 在Maximum Length of Repeated Subarray的Java提交中击败了50.71% 的用户
    //内存消耗: 65.4 MB, 在Maximum Length of Repeated Subarray的Java提交中击败了0.00% 的用户

    //建立dp[][]存储 A中以A[i]为末尾的数组 和 B中 以B[i]为末尾的数组 的最长重复子数组（必须包含A[i],B[j]）
    //如果A[i]=B[j] dp[i][j] = dp[i-1][j-1]+1;然后比较取最大值
    //如果不相等则为0
    public int findLength(int[] A, int[] B) {
        int l1 = A.length;
        int l2 = B.length;
        int res = 0;

        int[][] dp = new int[l1+1][l2+1];

        for(int i=1 ; i<=l1 ; i++){
            for(int j=1 ; j<=l2 ; j++){
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                    res = Math.max(dp[i][j],res);
                }
            }
        }
        return res;
    }
}
