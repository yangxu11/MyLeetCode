package leetcode;

/**
 * 航班预定统计
 *
 * @author yx
 * @create 2019-07-07  15:37
 **/
public class Q5118 {
    //后面的数由前面累加得来
    //为了防止后面的数加到额外的数字，比如[1,2,10]，为了防止3出加上10，在3处-10，这样3以及3后面的值都不会被10影响
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            res[b[0]-1] += b[2];
            if(b[1] != n) {
                res[b[1]] -= b[2];
            }
        }
        int now = 0;
        for (int i=0;i<n;i++) {
            now += res[i];
            res[i] = now;
        }
        return res;
    }
}
