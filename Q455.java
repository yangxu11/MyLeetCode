package leetcode;

import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author yx
 * @create 2019-05-23  20:04
 **/
public class Q455 {
    //贪心算法
    //对两个数组进行排序
    //当前最大的饼干只给最接近它大小的人
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0 || g.length==0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int res = 0;
        int i = g.length-1;
        int j = s.length-1;

        while(i>=0 && j>=0){
            if(s[j]>=g[i]){
                res++;
                j--;
                i--;
            } else{
                i--;
            }
        }
        return res;

    }
}
