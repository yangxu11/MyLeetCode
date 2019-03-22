package leetcode;

import java.util.Arrays;
import java.util.Comparator;

//用最少的箭射爆气球 同435无重叠区间  对end升序排序  每只箭尽可能射爆尽可能多的气球
public class Q452 {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        int count = 0;
        Comparator comp = new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[1]>b[1] ? 1 : (a[1]==b[1] ? 0 : -1);
            }
        };

        Arrays.sort(points,comp);
        int lastend = points[0][1];

        for(int i=1 ; i<points.length ; i++) {
            if(points[i][0]>lastend){
                lastend = points[i][1];
                count++;
            }
        }
        return count+1;
    }
}
