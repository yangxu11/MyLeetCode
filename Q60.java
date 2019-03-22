package leetcode;

import java.util.ArrayList;
import java.util.List;
//第K个排列
public class Q60 {
    //执行用时: 9 ms, 在Permutation Sequence的Java提交中击败了98.45% 的用户
    //内存消耗: 37.3 MB, 在Permutation Sequence的Java提交中击败了3.26% 的用户

    //计算（k-1）/(n-1)!就可以判断第一位数是多少，以此类推求出接下来的各个数
    //注意当前面数已经使用过后，后面不可再用，(k-1)/(n-1)!只能表示剩下的升序排序数组中的第几个数，所有建立list存储剩下的数
    //当k能整除阶乘数（k%step==0）时（k已经为剩下数字组成的最大数），将剩下的数降序输出
    public String getPermutation(int n, int k) {
        if(n==1) return "1";
        int step = 1;
        //存储剩下的数字
        List<Integer> list = new ArrayList<>();
        for(int i=1 ; i<=n ; i++){
            list.add(i);
        }
        //阶乘
        for(int i=1 ; i<n ; i++){
            step *=i;
        }
        StringBuilder sb = new StringBuilder();
        n = n-1;
        while(n>0 && k>0){
            int x = list.remove( (k-1)/step );//得到第x位数，并将其移除list
            sb.append(x);
            k = k%step;
            step = step/n;
            n--;
        }
        for(int j=list.size()-1 ; j>=0 ; j--){//当k能整除阶乘数时，将剩下的数降序输出
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}
