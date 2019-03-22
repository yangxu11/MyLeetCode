package leetcode;
//整数拆分
public class Q343 {
    //执行用时: 0 ms, 在Integer Break的Java提交中击败了100.00% 的用户
    //内存消耗: 23.4 MB, 在Integer Break的Java提交中击败了27.38% 的用户

    //建立数组存储n之前整数的最大拆分乘积，整数n可以转化为n=i+j,则res[n] = res[i]*res[j]
    //注意1，2，3时的情况，res[2] = 2,res[3]=3,而实际n=2时return 1  n=3时 return 2
    public int integerBreak(int n) {
        int[] res = new int[n+1];
        if(n==2) return 1;
        if(n==3) return 2;
        res[1] = 1;
        res[2] = 2;
        res[3] = 3;

        for(int i=4 ; i<=n ; i++){
            int max = 0;
            for(int j=1 ; j<=i/2 ; j++){
                max= Math.max(res[j]*res[i-j],max);
            }
            res[i] = max;
        }
        return res[n];
    }
}
