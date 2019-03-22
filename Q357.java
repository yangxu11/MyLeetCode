package leetcode;

import java.util.ArrayList;
import java.util.List;
//计算各个位数不同的数字个数
public class Q357 {
//执行用时 : 0 ms, 在Count Numbers with Unique Digits的Java提交中击败了100.00% 的用户
//内存消耗 : 32.1 MB, 在Count Numbers with Unique Digits的Java提交中击败了2.50% 的用户

    //动态规划
    //i位数的结果数dp[i] = (10-位数+1)*dp[i-1]
    public int countNumbersWithUniqueDigits1(int n) {
        if (n == 0) return 1;
        if (n > 10) n = 10;
        // dp[i]表示i位数的个数
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 9;
        int res = 10;
        for (int i=2; i<=n; i++) {
            // 每一位上都可以是0~9共10位数，但最高位不能是0，
            // 所以这种算法会出现如013这种数字这种最高位为0的结果，这种数字可以用来表示将0和次高位的数字替换的结果，为103
            dp[i] = (10 - i + 1) * dp[i-1];
            res += dp[i];
        }

        return res;
    }
    //执行用时 : 151 ms, 在Count Numbers with Unique Digits的Java提交中击败了2.02% 的用户
    //内存消耗 : 32.3 MB, 在Count Numbers with Unique Digits的Java提交中击败了2.50% 的用户
    //回溯
    int res = 0;
    public int countNumbersWithUniqueDigits2(int n) {
        if(n==0) return 1;
        List<Integer> list = new ArrayList<>();
        for(int i=1 ; i<=9 ; i++){
            list.add(i);
            dfs(n,1,list);
            list.remove(list.size()-1);
        }
        return res+1;
    }
    public void dfs(int n,int index,List<Integer> list){
        res++;
        if(index >= n) return;
        for(int i=0 ; i<=9 ; i++){
            if(!list.contains(i)){
                list.add(i);
                dfs(n,index+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}
