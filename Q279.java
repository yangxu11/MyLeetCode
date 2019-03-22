package leetcode;
//完全平方数
public class Q279 {
    //执行用时: 46 ms, 在Perfect Squares的Java提交中击败了51.20% 的用户
    //内存消耗: 21 MB, 在Perfect Squares的Java提交中击败了86.76% 的用户

    //动态规划，建立数组存储n之前所有数字的最小的平方数个数
    //计算n时，比较n去掉一个<n的平方数剩余数字的平方数个数，取其最小值，比如1，n-1  1+result[n-1] ; 4, n-4  1+result[n-4]
    public int numSquares(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        int x=2;
        int i=1;

        while(x<=n){
            while(i*i<=x){
                i++;
            }
            i--;
            int min = 1+result[x-i*i];
            for(int j=i-1 ; j>=1 ; j--){
                min = Math.min(min,1+result[x-j*j]);
            }
            result[x] = min;
            x++;
        }

        return result[n];
    }
}
