package leetcode.bishi360;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1
 *
 * @author yx
 * @create 2019-09-26  20:28
 **/
public class Q1 {

    public void getMaxLen(int[][] nums){
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return b[0] - b[1];
            }
        };

        Arrays.sort(nums,comp);

        int v = 0;

        double res = 0;

        for(int[] num : nums){
            int a = num[0];
            int t = num[1];

            res += v*t + 0.5*a*t*t;

            v+=a*t;
        }


        System.out.println(String.format("%.1f",res));
    }

}
