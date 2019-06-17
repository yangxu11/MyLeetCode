package leetcode;

/**
 * 范围求和
 *
 * @author yx
 * @create 2019-06-17  17:10
 **/
public class Q598 {
    public int maxCount(int m, int n, int[][] ops) {
        int x = m;
        int y = n;

        for(int[] op : ops){
            x = Math.min(op[0],x);
            y = Math.min(op[1],y);
        }

        return x*y;

    }
}
