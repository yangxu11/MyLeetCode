package leetcode;

import java.util.HashSet;
import java.util.Set;
//最小的矩形面积  二维化作一维  利用对角线，（1，1）（2，2） 1*1+2*2 = （1，2）（2，1） 1*1+2*2
//40000是为了防止重复  比如（1，1）与（2，0）
public class Q939 {
    public int minAreaRect(int[][] points) {
        Set<Integer> set = new HashSet<>();
        int res = Integer.MAX_VALUE;
        final int MAX = 40000;
        for (int[] point : points) {
            for (int[] anotherPoint : points) {
                if (point[0] == anotherPoint[0] || point[1] == anotherPoint[1])
                    continue;
                if (set.contains(point[0] * MAX + anotherPoint[1]) && set.contains(anotherPoint[0] * MAX + point[1]))
                    res = Math.min(res, Math.abs((point[0] - anotherPoint[0]) * (point[1] - anotherPoint[1])));
            }
            set.add(point[0] * MAX + point[1]);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
