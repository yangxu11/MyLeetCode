package leetcode;

import java.util.Arrays;

/**
 * 两地调度
 *
 * @author yx
 * @create 2019-04-21  12:04
 **/
public class Q1029 {
    public int twoCitySchedCost(int[][] cs) {
        int z = cs.length;

        int a[] = new int[z];

        int s = 0;
        for(int i=0;i<z;++i){
            a[i] = cs[i][1]-cs[i][0];
            s += cs[i][0];
        }
        Arrays.sort(a);

        for(int i=0;i<z/2;i++){
            s += a[i];
        }
        return s;




    }
}
