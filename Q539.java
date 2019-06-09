package leetcode;

import java.util.Collections;
import java.util.List;

/**
 * 最小时间差
 *
 * @author yx
 * @create 2019-06-09  20:14
 **/
public class Q539 {
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int res = 1440;
        for(int i=1 ; i<timePoints.size() ; i++){
            int diff = getDiff(timePoints.get(i),timePoints.get(i-1));
            res = Math.min(res,diff);
        }
        int d1 = getDiff(timePoints.get(0),"00:00");
        int d2 = getDiff("24:00",timePoints.get(timePoints.size()-1));

        return Math.min(res,d1+d2);

    }

    private int getDiff(String t1,String t2){
        String[] s1 = t1.split(":");
        String[] s2 = t2.split(":");
        int h = Integer.parseInt(s1[0])-Integer.parseInt(s2[0]);
        int m = Integer.parseInt(s1[1])-Integer.parseInt(s2[1]);
        return h*60+m;
    }
}
