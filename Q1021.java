package leetcode;
//最佳观光组合
public class Q1021 {
    //思路同Q53 最大子序列和
    //当A[i] + i - j <= A[j]时，则j之前的就要舍弃，i=j，从j开始
    public int maxScoreSightseeingPair(int[] A) {
        int i = 0;
        int j = 1;
        int ans = A[i] + A[j] + i - j;
        while(j < A.length){
            ans = Math.max(ans, A[i] + A[j] + i - j);
            if(A[j] >= A[i] + i - j){
                i = j;
            }
            j++;
        }
        return ans;
    }
}
